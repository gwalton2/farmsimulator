package farmsim;

import java.util.ArrayList;

public class Farm {
    private int level;
    private int pastures;
    private int acres;
    private ArrayList<Farmer> farmers;
    private ArrayList<Animal> animals;

    public Farm(int pastures, int acres) {
        level = 0;
        this.pastures = pastures;
        this.acres = acres;
        farmers = new ArrayList<Farmer>();
        animals = new ArrayList<Animal>();
    }

    public void levelUp() {
        level++;
        pastures++;
        acres++;
    }

    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }

    public void addAnimal(Animal animal) {
        if (animals.size() < acres) {
            animals.add(animal);
        }
        else {
            System.out.println("Not enough pastures for another animal. Level up your farm!");
        }
    }

    public ArrayList<Farmer> getFarmers() {
        ArrayList<Farmer> farmersCopy = new ArrayList<>(farmers);
        return farmersCopy;
    }

    public ArrayList<Animal> getAnimals() {
        ArrayList<Animal> animalsCopy = new ArrayList<>(animals);
        return animalsCopy;
    }
}
