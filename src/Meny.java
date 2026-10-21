import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Meny {

    // Inkapsling: Konstanter är privata och kan ej ändras utifrån
    private static final String EXIT_PROGRAM_ = "Exiting program... ";
    private static final String OUTBOUND_NUM_INPUT_ = "Error: Invalid input. Enter a number 1-3";
    private static final String INVALID_NUM_INPUT_ = "Error: Invalid input. Enter a number";
    private static final String INVALID_NAME_INPUT_ = "Error: Invalid input. Enter a valid name";

    //---------------------------------------------------------------------------------------------
    //Inkapsling: av Scanner och plantList nås bara inom Meny
    // Polymorfism: plantList innehåller Plant objekt olika växter.
    private static final Scanner userInput = new Scanner(System.in);
    private static final ArrayList<Plant> plantList = new ArrayList<>();
    static{
        plantList.add(new Cactus("Igge",0.2));
        plantList.add(new Palm("Laura",5));
        plantList.add(new Carnivorous("Meatloaf",0.7));
        plantList.add(new Palm("Olof",1));
    }
    //---------------------------------------------------------------------------------------------
    public static void greenest(){
        try {
            mainMeny();
        }
        catch (NoSuchElementException e){
            System.out.println(EXIT_PROGRAM_);
        }
    }
    //---------------------------------------------------------------------------------------------
    public static void mainMenyInfo(){
        System.out.println(" ");
        System.out.println("------- Welcome to Greenest -------\n");
        System.out.println("1. View plants information");
        System.out.println("2. Check water amount");
        System.out.println("3. Close program");
        System.out.print("\nSelect an option: ");
    }

    public static void mainMeny(){
        boolean isRunning = true;
        while (isRunning){
            mainMenyInfo();
            int input = checkNumInput();
            if (input == -1)continue;
            switch (input){
                case 1 -> plantInfo();
                case 2 -> getWaterAmount();
                case 3 ->{System.out.println(EXIT_PROGRAM_);isRunning=false;}
                default -> System.out.println(OUTBOUND_NUM_INPUT_);
            }
        }
    }

    public static int checkNumInput(){
        String input = userInput.nextLine().trim();
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e){
            System.out.println(INVALID_NUM_INPUT_);
            return -1;
        }
    }

    public static void plantInfo(){
        System.out.println("\n-------------- Plant Information --------------\n");

        for (Plant plant: plantList){
            System.out.println(plant.toString()+"\n");
        }
    }
    //---------------------------------------------------------------------------------------------
    public static void availablePlantsInfo(){
        System.out.println("\n---- Available plants ----");
        System.out.println(" - Igge (Cactus)");
        System.out.println(" - Laura (Palm)");
        System.out.println(" - Meatloaf (Carnivorous)");
        System.out.println(" - Olof (Palm)");
        System.out.print("\nEnter a name: ");
    }

    public static void getWaterAmount(){
        availablePlantsInfo();
        String inputName = userInput.nextLine().trim();
        //Polymorfism letar efter ett plant objekt med samma namn som input
        Plant plant = findPlantName(inputName);

        if (plant == null){
            System.out.println(INVALID_NAME_INPUT_);
            return;
        }
        //Polymorfism: olika calculateLiquid(); körs beroende på user input
        // och getLiquidType() hämtas beroende på vilken plant som behöves
        double amount = plant.calculateLiquid();
        LiquidType type = plant.getLiquidType();

        System.out.println(plant.getName() + " needs " + amount + " liters of " + type);
    }

    public static Plant findPlantName(String name){
        for (Plant plant : plantList){
            if (plant.getName().equalsIgnoreCase(name)){
                return plant;
            }
        }
        return null;
    }
}