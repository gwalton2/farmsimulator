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

    public void levelUp() {
        if (level < 10) {
            level++;
            salary += 5;
            animalMult += 0.1;
            cropMult += 0.1;
        }
        else {
            System.out.println("You have already maxed this farmer.");
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
