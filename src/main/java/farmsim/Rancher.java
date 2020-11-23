package farmsim;

public class Rancher extends Farmer {
    protected Farmer farmer;

    public Rancher(Farmer farmer, double animalMult, double cropMult) {
        super(animalMult, cropMult);
        this.farmer = farmer;
    }

    public void levelUp() {
        level++;
        animalMult += 0.2;
        cropMult += 0.2;
    }

    public int getLevel() {
        return level;
    }

    public int getSalary() {
        return salary + farmer.getSalary();
    }

    public double getAnimalMult() {
        return animalMult + farmer.getAnimalMult();
    }

    public double getCropMult() {
        return cropMult + farmer.getCropMult();
    }
}
