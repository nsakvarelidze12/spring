package pak.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    // As of Spring 4.3, classes with a single constructor can omit the @Autowired annotation
    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveEmployee(final Employee e) {
        String query = "insert into employee values (?, ?, ?)";
        PreparedStatementSetter pss = new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, e.getId());
                ps.setString(2, e.getName());
                ps.setFloat(3, e.getSalary());
            }
        };
        return jdbcTemplate.update(query, pss);
    }

    public int updateEmployee(Employee e) {
        String query = "update employee set name = '"
                + e.getName() + "', salary = '" + e.getSalary() + "' where id = '" + e.getId() + "'";
        return jdbcTemplate.update(query);
    }

    public int deleteEmployee(Employee e) {
        String query = "delete from employee where id='" + e.getId() + "'";
        return jdbcTemplate.update(query);
    }

    public List<Employee> queryEmployee() {
        String query = "select * from employee";
        ResultSetExtractor<List<Employee>> rse = new ResultSetExtractor<List<Employee>>() {
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Employee> list = new ArrayList<Employee>();
                while (rs.next()) {
                    Employee e = new Employee();
                    e.setId(rs.getInt(1));
                    e.setName(rs.getString(2));
                    e.setSalary(rs.getInt(3));
                    list.add(e);
                }
                return list;
            }
        };
        return jdbcTemplate.query(query, rse);
    }

}
