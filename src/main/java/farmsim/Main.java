package farmsim;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader;
    private static Facade farmInterface;

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        farmInterface = new Facade();

        System.out.println("----Welcome to FarmSimulator----");
        System.out.println("First you will need to select your farm's specialization.");

        String farmChoice = "";
        while(!farmChoice.equals("crops") && !farmChoice.equals("animals")) {
            System.out.println("You can choose your farm to favor crops or animals.");
            System.out.println("Type in 'crops' or 'animals'");
            farmChoice = reader.readLine();
        }

        String farmerChoice = "";
        while(!farmerChoice.equals("crops") && !farmerChoice.equals("animals")) {
            System.out.println("You can choose your first farmer to specialize in farming crops or raising animals.");
            System.out.println("Type in 'crops' or 'animals'");
            farmerChoice = reader.readLine();
        }

        farmInterface.createFarm(farmChoice, farmerChoice);
    }

    public boolean testMethod() {
        return true;
    }
}
