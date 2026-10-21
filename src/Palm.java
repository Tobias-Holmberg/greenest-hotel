public class Palm extends Plant{

    private static final double LITER_PER_DAY = 0.5;

    public Palm(String name, double height) {
        super(name, height, PlantType.PALM);
    }
    @Override
    public double calculateLiquid() {return LITER_PER_DAY * getHeight();}

    @Override
    public LiquidType getLiquidType(){return LiquidType.TAP_WATER;}
}
/*
        Arv: Palm ärver Plant med extends Plant och skickar vidare värden till superklassen

        Polymorfism: Palm har en egen implementation av calculateLiquid()
        Polymorfism: Palm har en egen implementation av getLiquidType()
 */