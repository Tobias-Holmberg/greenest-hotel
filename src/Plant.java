public abstract class Plant implements LiquidAmount{

    private final String name;
    private final double height;
    private final PlantType type;

    public Plant(String name, double height, PlantType type) {
        this.name = name;
        this.height = height;
        this.type = type;
    }

    public String getName() {return name;}
    public double getHeight() {return height;}

    @Override
    public String toString() {
        return type + " - " + name + " - height: " + height + " m, liquid: " + getLiquidType() ;
    }
}
/*
        Abstract: skapar en mal för växterna och kan inte instansieras direkt.
        Arv: Plant är min förälder (superklass) där alla växter ärver från.
        Interface: Plant implementerar LiquidAmount som kräver två metoder.

        Inkapsling: Använder private för name, height och type.
        Som gör att de kan inte nås eller ändras utifrån utan nås via getters
 */