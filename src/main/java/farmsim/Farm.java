package farmsim;

import java.util.ArrayList;

public class Farm {
    private int money;
    private int level;
    private int pastures;
    private int acres;
    private ArrayList<Farmer> farmers;
    private ArrayList<Animal> animals;

    /**
     *This is the constructor for a farm.
     * @param pastures indicates the number of pastures to start with
     * @param acres indicates the number of acres to start with
     */
    public Farm(int pastures, int acres) {
        money = 100;
        level = 1;
        this.pastures = pastures;
        this.acres = acres;
        farmers = new ArrayList<Farmer>();
        animals = new ArrayList<Animal>();
    }

    /**
     *This method levels up the farm.
     */
    public void levelUp() {
        level++;
        pastures++;
        acres++;
    }

    public int getLevel() {
        return level;
    }

    public int getMoney() {
        return money;
    }

    public void updateMoney(int update) {
        money += update;
    }

    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }

    public void removeFarmer(int index) {
        farmers.remove(index);
    }

    /**
     *This method handles all the cases of adding an animal.
     * @param animal animal object to add
     * @return boolean indicating success or failure
     */
    public boolean addAnimal(Animal animal) {
        if (animals.size() < pastures) {
            animals.add(animal);
            return true;
        } else {
            System.out.println("Not enough pastures for another animal. Level up your farm!");
            return false;
        }
    }

    /**
     *This method removes and returns an animal from the farm.
     * @param index int indicating which animal to remove
     * @return Animal object that was removed
     */
    public Animal removeAnimal(int index) {
        Animal animal = animals.get(index);
        animals.remove(index);

        return animal;
    }

    public ArrayList<Farmer> getFarmers() {
        ArrayList<Farmer> farmersCopy = new ArrayList<>(farmers);
        return farmersCopy;
    }

    public ArrayList<Animal> getAnimals() {
        ArrayList<Animal> animalsCopy = new ArrayList<>(animals);
        return animalsCopy;
    }

    public int getAcres() {
        return acres;
    }

    public int getPastures() {
        return pastures;
    }

    /**
     *This returns the string representation of the farm.
     * @return String
     */
    public String toString() {
        StringBuilder farmStr = new StringBuilder("\n-----Farm-----\n");
        farmStr.append("Level: " + Integer.toString(level) + "    $"
                + Integer.toString(money) + "\n");
        farmStr.append("Pastures: ").append(Integer.toString(pastures)).append("    Acres: ")
                .append(Integer.toString(acres)).append("\n\n");

        for (Farmer farmer : farmers) {
            farmStr.append(farmer.getClass().getName().split("[.]")[1]
                    + "     Level: " + farmer.getLevel());
            farmStr.append("    Salary: " + farmer.getSalary() + "    Animal Multiplier: "
                    + farmer.getAnimalMult() + "    Crop Multiplier: "
                    + farmer.getCropMult() + "\n");
        }
        farmStr.append("\n");
        for (Animal animal : animals) {
            farmStr.append(animal.getClass().getName().split("[.]")[1]
                    + "     Level: " + animal.getLevel());
            farmStr.append("    Price: " + animal.getPrice() + "    Daily income from "
                    + animal.getProduct() + ": " + animal.getProductPrice() + "\n");
        }
        farmStr.append("\n");
        return farmStr.toString();
    }
}
