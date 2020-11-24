package farmsim;

import org.junit.Test;
import static org.junit.Assert.*;

public class farmsimTest {
    @Test
    public void facadeCreateCropFarmCropFarmerTest() {
        Facade facade = new Facade();
        Farm myFarm = facade.createFarm("crops", "crops");

        assertEquals(myFarm.getAcres(), 4);
        assertEquals(myFarm.getPastures(), 2);
        assertEquals(myFarm.getFarmers().size(), 1);
        assertTrue(myFarm.getFarmers().get(0) instanceof CropGrower);
    }

    @Test
    public void facadeCreateCropFarmAnimalFarmerTest() {
        Facade facade = new Facade();
        Farm myFarm = facade.createFarm("crops", "animals");

        assertEquals(myFarm.getAcres(), 4);
        assertEquals(myFarm.getPastures(), 2);
        assertEquals(myFarm.getFarmers().size(), 1);
        assertTrue(myFarm.getFarmers().get(0) instanceof AnimalRearer);
    }

    @Test
    public void facadeCreateAnimalFarmCropFarmerTest() {
        Facade facade = new Facade();
        Farm myFarm = facade.createFarm("animals", "crops");

        assertEquals(myFarm.getAcres(), 2);
        assertEquals(myFarm.getPastures(), 4);
        assertEquals(myFarm.getFarmers().size(), 1);
        assertTrue(myFarm.getFarmers().get(0) instanceof CropGrower);
    }

    @Test
    public void facadeCreateAnimalFarmAnimalFarmerTest() {
        Facade facade = new Facade();
        Farm myFarm = facade.createFarm("animals", "animals");

        assertEquals(myFarm.getAcres(), 2);
        assertEquals(myFarm.getPastures(), 4);
        assertEquals(myFarm.getFarmers().size(), 1);
        assertTrue(myFarm.getFarmers().get(0) instanceof AnimalRearer);
    }

    @Test
    public void facadeRunCycleCropFarmCropFarmerTest() {
        Facade facade = new Facade();
        Farm myFarm = facade.createFarm("crops", "crops");
        facade.runCycle();
        assertEquals(myFarm.getMoney(), 515);
    }

    @Test
    public void facadeRunCycleCropFarmAnimalFarmerTest() {
        Facade facade = new Facade();
        Farm myFarm = facade.createFarm("crops", "animals");
        facade.runCycle();
        assertEquals(myFarm.getMoney(), 502);
    }

    @Test
    public void facadeRunCycleAnimalFarmCropFarmerTest() {
        Facade facade = new Facade();
        Farm myFarm = facade.createFarm("animals", "crops");
        facade.runCycle();
        assertEquals(myFarm.getMoney(), 530);
    }

    @Test
    public void facadeRunCycleAnimalFarmAnimalFarmerTest() {
        Facade facade = new Facade();
        Farm myFarm = facade.createFarm("animals", "animals");
        facade.runCycle();
        assertEquals(myFarm.getMoney(), 654);
    }

    @Test
    public void facadeBuyCowSellAnimalSuccess() {
        Facade facade = new Facade();
        Farm myFarm = facade.createFarm("crops", "crops");
        facade.sellAnimal(0);

        assertTrue(facade.buyAnimal("cow"));
        assertEquals(myFarm.getAnimals().size(), 2);
    }

    @Test
    public void facadeBuySheepSellAnimalSuccess() {
        Facade facade = new Facade();
        Farm myFarm = facade.createFarm("crops", "crops");
        facade.sellAnimal(0);

        assertTrue(facade.buyAnimal("sheep"));
        assertEquals(myFarm.getAnimals().size(), 2);
    }

    @Test
    public void facadeBuyAnimalFailure() {
        Facade facade = new Facade();
        Farm myFarm = facade.createFarm("crops", "crops");

        assertFalse(facade.buyAnimal("cow"));
        assertEquals(myFarm.getAnimals().size(), 2);
    }
}
