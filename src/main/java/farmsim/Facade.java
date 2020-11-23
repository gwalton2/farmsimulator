package farmsim;

public class Facade {
    private Farm farm;

    public Farm createFarm(String farmChoice, String farmerChoice) {
        FarmBuilder builder;
        if (farmChoice.equals("crops")) {
            builder = new CropFarm();
        }
        else {
            builder = new AnimalFarm();
        }

        Farmer farmer;
        if (farmerChoice.equals("crops")) {
            farmer = new CropGrower();
        }
        else {
            farmer = new AnimalRearer();
        }

        farm = new FarmDirector().ConstructFarm(builder, farmer);
        return farm;
    }

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
        System.out.println("For this cycle, your farm cost you $" + passiveCost + " and made you $" + passiveIncome);
    }

    public boolean buyAnimal(String type) {
        Animal animal;
        if (type.equals("cow")) {
            animal = new Cow();
        }
        else {
            animal = new Sheep();
        }
        int price = animal.getPrice();
        if (farm.getMoney() <= price) {
            farm.addAnimal(animal);
            farm.updateMoney(price * -1);

            System.out.println(type + " purchased for " + price);
            return true;
        }
        else {
            System.out.println("You do not have enough money to purchase this animal. It costs $" + price);
            System.out.println("Try again");
            return false;
        }
    }

    public void sellAnimal(int index) {
        int price = farm.getAnimals().get(index).getPrice();
        farm.updateMoney(price);
        farm.removeAnimal(index);

        System.out.println("You have sold this animal for " + price);
    }

    public void hireFarmer(String type) {
        Farmer farmer;
        if (type.equals("crop")) {
            farmer = new CropGrower();
        }
        else {
            farmer = new AnimalRearer();
        }
        farm.addFarmer(farmer);
        System.out.println("Hired new farmer!");
    }

    public boolean levelUpFarm() {
        int price = farm.getLevel() * 100;
        if (farm.getMoney() <= price) {
            farm.levelUp();
            farm.updateMoney(price * -1);
            System.out.println("Leveled up your farm for " + price);
            return true;
        }
        else {
            System.out.println("You do not have enough money to level up your farm. It costs $" + price);
            System.out.println("Try again");
            return false;
        }
    }

    public boolean levelUpFarmer(int index) {
        Farmer farmer = farm.getFarmers().get(index);
        int price = farmer.getLevel() * 50;
        if (farm.getMoney() <= price) {
            farmer.levelUp();
            farm.updateMoney(price * -1);
            System.out.println("Leveled up this farmer for " + price);
            return true;
        }
        else {
            System.out.println("You do not have enough money to level up this farmer. It costs $" + price);
            System.out.println("Try again");
            return false;
        }
    }

    public boolean levelUpAnimal(int index) {
        Animal animal = farm.getAnimals().get(index);
        int price = animal.getLevel() * 50;
        if (farm.getMoney() <= price) {
            animal.levelUp();
            farm.updateMoney(price * -1);
            System.out.println("Leveled up this animal for " + price);
            return true;
        }
        else {
            System.out.println("You do not have enough money to level up this animal. It costs $" + price);
            System.out.println("Try again");
            return false;
        }
    }
}
