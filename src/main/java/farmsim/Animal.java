package farmsim;

public class Animal {
    int level;
    int price;
    String product;
    int productPrice;

    public Animal(int price, String product, int productPrice) {
        level = 0;
        this.price = price;
        this.product = product;
        this.productPrice = productPrice;
    }

    public void levelUp() {
        if (level < 10) {
            level++;
            productPrice += 10;
            price += 50;
        }
        else {
            System.out.println("You have already maxed this animal.");
        }
    }

    public int getPrice() {
        return price;
    }

    public int getLevel() {
        return level;
    }

    public String getProduct() {
        return product;
    }

    public int getProductPrice() {
        return productPrice;
    }
}
