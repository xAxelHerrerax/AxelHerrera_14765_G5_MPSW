package ec.edu.espe.deinglogin.model;

import java.util.Date;

/**
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class Employee {

    private int id;
    private String name;
    private int age;
    private Date startWork;
    private String contactNumber;

    @Override
    public String toString() {
        return "\n\t\tid:" + id + "\n\tNombre:" + name + "\n\tEdad:"
                + age + "\n\tEmpieza a Trabajar:" + startWork
                + "\n\tNumero de Contacto:" + contactNumber + "\n";
    }

    public Employee(int id, String name, int age, Date startWork, String contactNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.startWork = startWork;
        this.contactNumber = contactNumber;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getStartWork() {
        return startWork;
    }

    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
