package farmsim;

public class Facade {
    private Farm farm;

    public void createFarm(String farmChoice, String farmerChoice) {
        FarmBuilder builder;
        if (farmChoice.equals("crops")) {
            builder = new CropFarm();
        }
        else {
            builder = new AnimalFarm();
        }

        Farmer farmer;
        if (farmerChoice.equals("crops")) {
            farmer = new CropGrower();
        }
        else {
            farmer = new AnimalRearer();
        }

        farm = new FarmDirector().ConstructFarm(builder, farmer);
        System.out.println("Successfully created your farm!");
    }
}
