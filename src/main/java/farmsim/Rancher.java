package farmsim;

public class Rancher extends Farmer {
    protected Farmer farmer;

    public Rancher(Farmer farmer, double animalMult, double cropMult) {
        super(animalMult, cropMult);
        this.farmer = farmer;
    }

    /**
     *This method handles leveling up the rancher.
     * @return boolean indicating success or failure
     */
    public boolean levelUp() {
        if (level < 10) {
            level++;
            salary += 10;
            animalMult = (double) Math.round(animalMult * 10 + 2) / 10;
            cropMult = (double) Math.round(cropMult * 10 + 2) / 10;
            return true;
        } else {
            System.out.println("You have already maxed this rancher.");
            return false;
        }
    }

    public int getLevel() {
        return level;
    }

    public int getSalary() {
        return salary + farmer.getSalary();
    }

    public double getAnimalMult() {
        return (double) Math.round(animalMult * 10 + farmer.getAnimalMult() * 10) / 10;
    }

    public double getCropMult() {
        return (double) Math.round(cropMult * 10 + farmer.getCropMult() * 10) / 10;
    }
}
