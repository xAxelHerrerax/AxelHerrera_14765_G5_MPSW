package ec.edu.espe.deinglogin.model;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class Inventory {

    private int id;
    private String Name;
    private int amount;
    private float price;

    public Inventory(int id, String Name, int amount, float price) {
        this.id = id;
        this.Name = Name;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public int getAmount() {
        return amount;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
