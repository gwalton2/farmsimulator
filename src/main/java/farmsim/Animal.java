package farmsim;

public class Animal {
    int level;
    int price;
    String product;
    int productPrice;

    /**
     *This is the constructor for Animal.
     * @param price int price to start at
     * @param product string indicating product animal has
     * @param productPrice int price the animals product goes for
     */
    public Animal(int price, String product, int productPrice) {
        level = 1;
        this.price = price;
        this.product = product;
        this.productPrice = productPrice;
    }

    /**
     *This method handles leveling up the animal.
     */
    public void levelUp() {
        if (level < 10) {
            level++;
            productPrice += 10;
            price += 50;
        } else {
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
