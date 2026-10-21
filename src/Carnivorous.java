public class Carnivorous extends Plant{

    private static final double LITER_PER_DAY = 0.1;
    private static final double LITER_PER_METER = 0.2;

    public Carnivorous(String name, double height) {
        super(name, height, PlantType.CARNIVOROUS);
    }

    @Override
    public double calculateLiquid() {return LITER_PER_DAY + (LITER_PER_METER * getHeight());}
    @Override
    public LiquidType getLiquidType(){return LiquidType.PROTEIN_DRINK;}
}
/*
        Arv: Carnivorous ärver Plant med extends Plant och skickar vidare värden till superklassen

        Polymorfism: Carnivorous har en egen implementation av calculateLiquid()
        Polymorfism: Carnivorous har en egen implementation av getLiquidType()
 */