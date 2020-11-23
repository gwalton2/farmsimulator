package farmsim;

public class CropFarm extends FarmBuilder {
    private Farm farm;

    public CropFarm() {
        farm = new Farm(2, 4);
    }

    public void addFarmer(Farmer farmer) {
        farm.addFarmer(farmer);
    }

    public void addAnimals() {
        Cow cow = new Cow();
        Sheep sheep = new Sheep();

        farm.addAnimal(cow);
        farm.addAnimal(sheep);
    }

    public Farm getFarm() {
        return farm;
    }
}
