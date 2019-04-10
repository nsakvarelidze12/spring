package pak.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "emp")
@SequenceGenerator(name="seq_emp", sequenceName = "seq_emp", allocationSize=50)
@Inheritance(strategy=InheritanceType.JOINED)
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_emp")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
