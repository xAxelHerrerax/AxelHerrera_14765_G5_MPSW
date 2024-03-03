package ec.edu.espe.deinglogin.model;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class Administrator {

    private int id;
    private String name;
    private int age;
    private String contactNumber;

    @Override
    public String toString() {
        return "\n\t\tAdministrador" + "\n\tid:" + id + "\n\tNombre:"
                + name + "\n\tEdad:" + age + "\n\tNumero de contacto:" 
                + contactNumber + "\n";
    }

    public Administrator(int id, String name, int age, String contactNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
