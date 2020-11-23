package farmsim;

public class Animal {
    int level;
    String product;
    double productPrice;
    boolean productReady;

    public Animal(String product, double productPrice) {
        level = 0;
        this.product = product;
        this.productPrice = productPrice;
        productReady = true;
    }

    public void levelUp() {
        level++;
        productPrice += 50;
    }

    public int getLevel() {
        return level;
    }

    public String getProduct() {
        return product;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public boolean getProductReady() {
        return productReady;
    }
}
