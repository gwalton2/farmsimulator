package farmsim;

public class Farmer {
    int level;
    double animalMult;
    double cropMult;

    public Farmer(double animalMult, double cropMult) {
        level = 0;
        this.animalMult = animalMult;
        this.cropMult = cropMult;
    }

    public void levelUp() {
        level++;
        animalMult += 0.1;
        cropMult += 0.1;
    }

    public int getLevel() {
        return level;
    }

    public double getAnimalMult() {
        return animalMult;
    }

    public double getCropMult() {
        return cropMult;
    }
}
