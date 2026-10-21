public class Cactus extends Plant{

    private static final double LITER_PER_DAY = 0.02;

    public Cactus(String name, double height) {
        super(name, height, PlantType.CACTUS);
    }
    @Override
    public double calculateLiquid() {return LITER_PER_DAY;}

    @Override
    public LiquidType getLiquidType(){return LiquidType.MINERAL_WATER;}
}
/*
        Arv: Cactus ärver Plant med extends Plant och skickar vidare värden till superklassen

        Polymorfism: Cactus har en egen implementation av calculateLiquid()
        Polymorfism: Cactus har en egen implementation av getLiquidType()
 */