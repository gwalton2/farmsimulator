package farmsim;

public class FarmDirector {

    /**
     *This method handles the algorithm for creating a farm using builders.
     * @param builder the farmbuilder to use
     * @param farmer the first farmer to add to the farm
     * @return Farm object that was created
     */
    public Farm constructFarm(FarmBuilder builder, Farmer farmer) {
        builder.addFarmer(farmer);
        builder.addAnimals();

        return builder.getFarm();
    }
}
