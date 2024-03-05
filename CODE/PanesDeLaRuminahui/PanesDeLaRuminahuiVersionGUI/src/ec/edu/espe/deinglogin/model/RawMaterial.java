package ec.edu.espe.deinglogin.model;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class RawMaterial {

    private int id;
    private String nameMaterial;
    private float priceProduct;
    private int stock;

    @Override
    public String toString() {
        
        return "\n\tRawMaterial " + "\n\t\tid: " + id + "\n\t\tNombre: "
                + nameMaterial + "\n\t\tPrecio: " + priceProduct
                + "\n\t\tStock: " + stock;
    }

    public RawMaterial(int id, String nameMaterial, float priceProduct, int stock) {
        this.id = id;
        this.nameMaterial = nameMaterial;
        this.priceProduct = priceProduct;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    public float getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(float priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
