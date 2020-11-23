package farmsim;

public class AnimalFarm extends FarmBuilder {
    private Farm farm;

    public AnimalFarm() {
        farm = new Farm(4, 2);
    }

    public void addFarmer(Farmer farmer) {
        farm.addFarmer(farmer);
    }
    public void addAnimals() {
        Cow cow1 = new Cow();
        Cow cow2 = new Cow();
        Sheep sheep1 = new Sheep();
        Sheep sheep2 = new Sheep();

        farm.addAnimal(cow1);
        farm.addAnimal(cow2);
        farm.addAnimal(sheep1);
        farm.addAnimal(sheep2);
    }

    public Farm getFarm() {
        return farm;
    }
}
