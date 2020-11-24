package farmsim;

public class Facade {
    private Farm farm;

    /**
     *This method makes use of the builder pattern to create a farm object.
     * @param farmChoice orientation of farm (crop or animal).
     * @param farmerChoice orientation of first farmer (crop or animal).
     * @return Farm object
     */
    public Farm createFarm(String farmChoice, String farmerChoice) {
        FarmBuilder builder;
        if (farmChoice.equals("crops")) {
            builder = new CropFarm();
        } else {
            builder = new AnimalFarm();
        }

        Farmer farmer;
        if (farmerChoice.equals("crops")) {
            farmer = new CropGrower();
        } else {
            farmer = new AnimalRearer();
        }

        farm = new FarmDirector().constructFarm(builder, farmer);
        return farm;
    }

    /**
     *This method calculates the cost of running the farm for one cycle.
     * It also calculates the income generated from one cycle.
     */
    public void runCycle() {
        int passiveCost = 0;
        int passiveIncome = 0;

        int cropIncome = farm.getAcres() * 50;
        for (Farmer farmer : farm.getFarmers()) {
            passiveCost += farmer.getSalary();
            cropIncome *= farmer.getCropMult();
        }
        passiveIncome += cropIncome;
        for (Animal animal : farm.getAnimals()) {
            passiveCost += 5 * animal.getLevel();
            int animalIncome = animal.getProductPrice();
            for (Farmer farmer : farm.getFarmers()) {
                animalIncome *= farmer.getAnimalMult();
            }
            passiveIncome += animalIncome;
        }
        farm.updateMoney(passiveIncome - passiveCost);
        System.out.println("For this cycle, your farm cost you $" + passiveCost
                + " and made you $" + passiveIncome);
    }

    /**
     *This method handles all the cases of buying and adding an animal to the farm.
     * @param type string indicating if animal is sheep or cow
     * @return boolean indicating success or failure
     */
    public boolean buyAnimal(String type) {
        Animal animal;
        if (type.equals("cow")) {
            animal = new Cow();
        } else {
            animal = new Sheep();
        }
        int price = animal.getPrice();
        if (farm.getMoney() >= price) {
            if (farm.addAnimal(animal)) {
                farm.updateMoney(price * -1);

                System.out.println(type + " purchased for $" + price);
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("You do not have enough money to purchase this animal. It costs $"
                    + price);
            System.out.println("Try again");
            return false;
        }
    }

    /**
     *This method handles all the cases of selling and removing an animal from the farm.
     * @param index int indicating which animal to remove
     */
    public void sellAnimal(int index) {
        int price = farm.getAnimals().get(index).getPrice();
        farm.updateMoney(price);
        farm.removeAnimal(index);

        System.out.println("You have sold this animal for $" + price);
    }

    /**
     *This method handles all the cases of hiring and adding a farmer to the farm.
     * @param type string indicating the farmers orientation
     */
    public void hireFarmer(String type) {
        Farmer farmer;
        if (type.equals("crop")) {
            farmer = new CropGrower();
        } else {
            farmer = new AnimalRearer();
        }
        farm.addFarmer(farmer);
        System.out.println("Hired new farmer!");
    }

    /**
     *This method handles all the cases of leveling up your farm.
     * @return boolean indicating success or failure
     */
    public boolean levelUpFarm() {
        int price = farm.getLevel() * 100;
        if (farm.getMoney() >= price) {
            farm.levelUp();
            farm.updateMoney(price * -1);
            System.out.println("Leveled up your farm for $" + price);
            return true;
        } else {
            System.out.println("You do not have enough money to level up your farm. It costs $"
                    + price);
            System.out.println("Try again");
            return false;
        }
    }

    /**
     *This method handles all the cases of leveling up a farmer.
     * @param index int indicating the farmer to level up
     * @return boolean indicating success or failure
     */
    public boolean levelUpFarmer(int index) {
        Farmer farmer = farm.getFarmers().get(index);
        int price = farmer.getLevel() * 50;
        if (farm.getMoney() >= price) {
            if (farmer.levelUp()) {
                farm.updateMoney(price * -1);
                System.out.println("Leveled up this farmer for $" + price);
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("You do not have enough money to level up this farmer. It costs $"
                    + price);
            System.out.println("Try again");
            return false;
        }
    }

    /**
     *This method handles all the cases of upgrading a farmer to a rancher.
     * @param index int indicating the farmer to upgrade
     * @return boolean indicating success or failure
     */
    public boolean upgradeFarmer(int index) {
        Farmer farmer = farm.getFarmers().get(index);
        if (farmer.getLevel() < 5) {
            System.out.println("A farmer must be at least a level 5 to upgrade");
            System.out.println("Try again");
            return false;
        }
        int price = farmer.getLevel() * 100;
        if (farm.getMoney() >= price) {
            Farmer upgradedFarmer;
            if (farmer instanceof CropGrower) {
                upgradedFarmer = new CornChild(farmer);
            } else if (farmer instanceof AnimalRearer) {
                upgradedFarmer = new CritterWhisperer(farmer);
            } else {
                System.out.println("Cannot upgrade a rancher.");
                System.out.println("Try again");
                return false;
            }
            farm.removeFarmer(index);
            farm.addFarmer(upgradedFarmer);
            System.out.println("Upgraded farmer for $" + price);
            return true;
        } else {
            System.out.println("You do not have enough money to upgrade this farmer. It costs $"
                    + price);
            System.out.println("Try again");
            return false;
        }
    }

    /**
     *This method handles all the cases of leveling up an animal.
     * @param index int indicating which animal to level up
     * @return boolean indicating success or failure
     */
    public boolean levelUpAnimal(int index) {
        Animal animal = farm.getAnimals().get(index);
        int price = animal.getLevel() * 50;
        if (farm.getMoney() >= price) {
            animal.levelUp();
            farm.updateMoney(price * -1);
            System.out.println("Leveled up this animal for $" + price);
            return true;
        } else {
            System.out.println("You do not have enough money to level up this animal. It costs $"
                    + price);
            System.out.println("Try again");
            return false;
        }
    }
}
