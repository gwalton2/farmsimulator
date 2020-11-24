package farmsim;

public class Farmer {
    int level;
    int salary;
    double animalMult;
    double cropMult;

    public Farmer(double animalMult, double cropMult) {
        level = 1;
        salary = 50;
        this.animalMult = animalMult;
        this.cropMult = cropMult;
    }

    public boolean levelUp() {
        if (level < 10) {
            level++;
            salary += 5;
            animalMult = (double) Math.round(animalMult * 10 + 1) / 10;
            cropMult = (double) Math.round(cropMult * 10 + 1) / 10;;
            return true;
        }
        else {
            System.out.println("You have already maxed this farmer.");
            return false;
        }
    }

    public int getLevel() {
        return level;
    }

    public int getSalary() {
        return salary;
    }

    public double getAnimalMult() {
        return animalMult;
    }

    public double getCropMult() {
        return cropMult;
    }
}
