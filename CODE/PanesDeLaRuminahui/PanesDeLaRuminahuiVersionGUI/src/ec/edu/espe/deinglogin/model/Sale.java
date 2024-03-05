package ec.edu.espe.deinglogin.model;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class Sale {

    private String id;
    private String nameProduct;
    private int amount;
    private float unitPrice;
    private float totalPrice;

    public Sale(String id, String nameProduct, int amount, float unitPrice, float totalPrice) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
