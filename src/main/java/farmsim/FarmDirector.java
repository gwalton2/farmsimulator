package farmsim;

public class FarmDirector {

    public Farm ConstructFarm(FarmBuilder builder, Farmer farmer) {
        builder.addFarmer(farmer);
        builder.addAnimals();

        return builder.getFarm();
    }
}
