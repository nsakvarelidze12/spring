package pak.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "reg_emp")
@PrimaryKeyJoinColumn(name = "fk", referencedColumnName = "id")
public class RegEmp extends Emp {

    @Column(name = "salary")
    private float salary;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

}
