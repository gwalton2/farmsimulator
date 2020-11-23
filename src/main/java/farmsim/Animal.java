package farmsim;

public class Animal {
    String product;
    double productPrice;
    int level;

    public Animal(String product, double productPrice) {
        level = 0;
        this.product = product;
        this.productPrice = productPrice;
    }

    public void levelUp() {
        level++;
        productPrice += 50;
    }

    public String getProduct() {
        return product;
    }

    public double getProductPrice() {
        return productPrice;
    }
}
