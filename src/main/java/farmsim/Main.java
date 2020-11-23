package farmsim;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    private static BufferedReader reader;
    private static Facade farmInterface;
    private static Farm farm;

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
            System.out.println("\nYou can choose your first farmer to specialize in farming crops or raising animals.");
            System.out.println("Type in 'crops' or 'animals'");
            farmerChoice = reader.readLine();
        }

        farm = farmInterface.createFarm(farmChoice, farmerChoice);
        System.out.println(farm.toString());

        runGame();
    }

    public static void runGame() throws Exception {
        System.out.println("The simulator will now cycle through days and nights. You can only make moves during the day");
        System.out.println("You can buy or sell animals, hire more farmers, or level up anything you own.");
        System.out.println("The game will end when you reach $1000 or go bankrupt(reach $0)");
        System.out.println("If you don't want to perform an action you can type out 'skip'");
        int day = 0;
        while (true) {
            gameIsOver();
            farm.toString();

            runDayTime();
            runNightTime();
            farmInterface.runCycle();
        }

    }

    public static void runDayTime() throws Exception {
        System.out.println("\nDaytime");
        String move = reader.readLine().toLowerCase();
        boolean successfulMove = true;

        if (move.equals("buy sheep")) {
            successfulMove = farmInterface.buyAnimal("sheep");
        }
        else if (move.equals("buy cow")) {
            successfulMove = farmInterface.buyAnimal("cow");
        }
        else if (move.equals("sell animal")) {
            int i = 0;
            for (Animal animal : farm.getAnimals()) {
                System.out.print(i + ": " + animal.getClass().getName().split("[.]")[1] + "  Price: " + animal.getPrice());
                i++;
            }
            System.out.println("\nInput the number of the animal you'd like to sell.");
            int index = Integer.parseInt(reader.readLine());
            farmInterface.sellAnimal(index);
        }
        else if (move.equals("hire crop farmer")) {
            farmInterface.hireFarmer("crop");
        }
        else if (move.equals("hire animal rearer")) {
            farmInterface.hireFarmer("animal");
        }
        else if (move.equals("level up farm")) {
            successfulMove = farmInterface.levelUpFarm();
        }
        else if (move.equals("level up farmer")) {
            int i = 0;
            for (Farmer farmer : farm.getFarmers()) {
                System.out.print(i + ": " + farmer.getClass().getName().split("[.]")[1] + "   ");
                i++;
            }
            System.out.println("\nInput the number of the farmer you'd like to upgrade.");
            int index = Integer.parseInt(reader.readLine());
            successfulMove = farmInterface.levelUpFarmer(index - 1);
        }
        else if (move.equals("level up animal")) {
            int i = 0;
            for (Animal animal : farm.getAnimals()) {
                System.out.print(i + ": " + animal.getClass().getName().split("[.]")[1] + "   ");
                i++;
            }
            System.out.println("\nInput the number of the animal you'd like to upgrade.");
            int index = Integer.parseInt(reader.readLine());
            successfulMove = farmInterface.levelUpAnimal(index - 1);
        }
        else if (move.equals("skip")) {
            System.out.println("No move made");
        }
        else {
            System.out.println("Unrecognized command. Try again");
            successfulMove = false;
        }
        if (!successfulMove) {
            runDayTime();
        }
    }

    public static int runNightTime() {
        System.out.println("\nNighttime");
        Random random = new Random();
        int animalEaten = random.nextInt(100);
        int cropsDestroyed = random.nextInt(100);

        if (animalEaten < 10) {
            Animal deadAnimal = farm.removeAnimal(random.nextInt(farm.getAnimals().size()));
            System.out.println("A wolf got onto your farm last night!");
            System.out.println(deadAnimal.getClass().getName().split("[.]")[1] + " " + deadAnimal.getLevel() + " was eaten.");
            return 0;
        }
        if (cropsDestroyed < 10) {
            farm.updateMoney(-50);
            System.out.println("Some rabbits got into your crops last night! You lost $50 worth of crops.");
            return 50;
        }
        return 0;
    }

    public static void gameIsOver() {
        if (farm.getMoney() <= 0) {
            System.out.println("You are broke!!");
            System.out.println(farm.toString());
            System.exit(0);
        }
        else if (farm.getMoney() >= 1000) {
            System.out.println("You're rich! You've beat the game!");
            System.out.println(farm.toString());
            System.exit(0);
        }
    }

    public boolean testMethod() {
        return true;
    }
}
