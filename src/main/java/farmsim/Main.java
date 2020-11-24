package farmsim;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Main {
    private static BufferedReader reader;
    private static Facade farmInterface;
    private static Farm farm;
    private static final int winningAmount = 10000;

    /**
     *This is the main method that takes in the initial input.
     * @param args is not used here
     */
    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        farmInterface = new Facade();

        System.out.println("----Welcome to FarmSimulator----");
        System.out.println("First you will need to select your farm's specialization.");

        String farmChoice = "";
        while (!farmChoice.equals("crops") && !farmChoice.equals("animals")) {
            System.out.println("You can choose your farm to favor crops or animals.");
            System.out.println("Type in 'crops' or 'animals'");
            farmChoice = reader.readLine();
            if (farmChoice == null) {
                throw new Exception();
            }
        }

        String farmerChoice = "";
        while (!farmerChoice.equals("crops") && !farmerChoice.equals("animals")) {
            System.out.println("\nYou can choose your first farmer to specialize in "
                    + "farming crops or raising animals.");
            System.out.println("Type in 'crops' or 'animals'");
            farmerChoice = reader.readLine();
            if (farmerChoice == null) {
                throw new Exception();
            }
        }

        farm = farmInterface.createFarm(farmChoice, farmerChoice);
        System.out.println(farm.toString());

        runGame();
    }

    /**
     *This method handles the main looping through cycles.
     */
    public static void runGame() throws Exception {
        System.out.println("The simulator will now cycle through days and nights."
                + "You can only make moves during the day");
        System.out.println("You can buy or sell animals, hire more farmers,"
                + "or level up anything you own.");
        System.out.println("The game will end when you reach $" + winningAmount
                + " or go bankrupt(reach $0)");
        System.out.println("If you don't want to perform an action you can type out 'skip'");

        while (true) {
            runDayTime();
            runNightTime();
            farmInterface.runCycle();

            gameIsOver();
            System.out.println(farm.toString());
        }

    }

    /**
     *This method parses the commands given for the day.
     */
    public static void runDayTime() throws Exception {
        System.out.println("\nDaytime");
        String move = reader.readLine();
        if (move == null) {
            throw new Exception();
        } else {
            move = move.toLowerCase();
        }
        boolean successfulMove = true;

        if (move.equals("buy sheep")) {
            successfulMove = farmInterface.buyAnimal("sheep");
        } else if (move.equals("buy cow")) {
            successfulMove = farmInterface.buyAnimal("cow");
        } else if (move.equals("sell animal")) {
            int i = 0;
            for (Animal animal : farm.getAnimals()) {
                System.out.print("(" + i + ") " + animal.getClass().getName().split("[.]")[1]
                        + " Price: " + animal.getPrice() + "    ");
                i++;
            }
            System.out.println("\nInput the number of the animal you'd like to sell.");
            int index = Integer.parseInt(reader.readLine());
            farmInterface.sellAnimal(index);
        } else if (move.equals("hire crop farmer")) {
            farmInterface.hireFarmer("crop");
        } else if (move.equals("hire animal rearer")) {
            farmInterface.hireFarmer("animal");
        } else if (move.equals("level up farm")) {
            successfulMove = farmInterface.levelUpFarm();
        } else if (move.equals("level up farmer")) {
            int i = 0;
            for (Farmer farmer : farm.getFarmers()) {
                System.out.print("(" + i + ") " + farmer.getClass().getName().split("[.]")[1]
                        + " Level: " + farmer.getLevel() + "    ");
                i++;
            }
            System.out.println("\nInput the number of the farmer you'd like to level up.");
            int index = Integer.parseInt(reader.readLine());
            successfulMove = farmInterface.levelUpFarmer(index);
        } else if (move.equals("upgrade farmer")) {
            int i = 0;
            for (Farmer farmer : farm.getFarmers()) {
                System.out.print("(" + i + ") " + farmer.getClass().getName().split("[.]")[1]
                        + " Level: " + farmer.getLevel() + "    ");
                i++;
            }
            System.out.println("\nInput the number of the farmer you'd like to upgrade.");
            int index = Integer.parseInt(reader.readLine());
            successfulMove = farmInterface.upgradeFarmer(index);
        } else if (move.equals("level up animal")) {
            int i = 0;
            for (Animal animal : farm.getAnimals()) {
                System.out.print("(" + i + ") " + animal.getClass().getName().split("[.]")[1]
                        + " Level: " + animal.getLevel() +  "   ");
                i++;
            }
            System.out.println("\nInput the number of the animal you'd like to level up.");
            int index = Integer.parseInt(reader.readLine());
            successfulMove = farmInterface.levelUpAnimal(index);
        } else if (move.equals("skip")) {
            System.out.println("No move made");
        } else {
            System.out.println("Unrecognized command. Try again");
            successfulMove = false;
        }
        if (!successfulMove) {
            runDayTime();
        }
    }

    /**
     *This method handles the possibilities of nighttime.
     */
    public static void runNightTime() {
        System.out.println("\nNighttime");
        Random random = new Random();
        int animalEaten = random.nextInt(100);
        int cropsDestroyed = random.nextInt(100);

        if (animalEaten < 10) {
            Animal deadAnimal = farm.removeAnimal(random.nextInt(farm.getAnimals().size()));
            System.out.println("A wolf got onto your farm last night!");
            System.out.println(deadAnimal.getClass().getName().split("[.]")[1] + "(level "
                    + deadAnimal.getLevel() + ") was eaten.\n");
        }
        if (cropsDestroyed < 10) {
            farm.updateMoney(-50);
            System.out.println("Some rabbits got into your crops last night!"
                    + "You lost $50 worth of crops.\n");
        }
        if (animalEaten >= 10 && cropsDestroyed >= 10) {
            System.out.println("An uneventful night has passed.\n");
        }
    }

    /**
     *This method checks if the game is over.
     */
    public static void gameIsOver() {
        if (farm.getMoney() <= 0) {
            System.out.println("\n-----You are broke!!-----");
            System.out.println(farm.toString());
            System.exit(0);
        } else if (farm.getMoney() >= winningAmount) {
            System.out.println("\n-----You're rich! You've beat the game!-----");
            System.out.println(farm.toString());
            System.exit(0);
        }
    }
}
