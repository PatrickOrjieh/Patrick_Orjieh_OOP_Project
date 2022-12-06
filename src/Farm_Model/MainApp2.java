//package Farm_Model;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.SQLOutput;
//import java.util.ArrayList;
//import java.util.InputMismatchException;
//import java.util.Random;
//import java.util.Scanner;
//
//public class MainApp2 {
//    //variable to taker user's name and use that as the owner string of the farm
//    public static String name = "";
//    public static int income = 75000;
//
//    public static Farm farm;
//
//
//    //got the design from https://stackoverflow.com/questions/27977973/how-to-use-print-format-to-make-box-around-text-java
//    public static void displayIncome() {
//        Scanner in = new Scanner(System.in);
//        int length = 10;
//        int spacesNeeded = 0;
//        int size = 1;
//        String[] inputs = new String[size];
//        for (int i = 0; i < size; i++) {
//            inputs[i] = "Revenue : €" + income;
//        }
//        System.out.print("+");
//
//        int maxsize = 0;
//
//        for (String s : inputs) {
//            if (s.length() > maxsize) {
//                maxsize = s.length();
//            }
//        }
//
//        for (int i = 0; i <= maxsize + 1; i++) {
//            System.out.print("-");
//        }
//
//        System.out.print("+");
//        System.out.println();
//        for (int j = 0; j < inputs.length; j++) {
//            System.out.print("| " + inputs[j]);
//
//            for (int i = inputs[j].length(); i <= maxsize; i++) {
//                System.out.print(" ");
//            }
//            System.out.print("|");
//            System.out.println();
//
//        }
//        System.out.print("+");
//
//        for (int i = 0; i <= maxsize + 1; i++) {
//            System.out.print("-");
//        }
//
//        System.out.print("+");
//        System.out.println();
//    }
//
//    //created a fixed menu input method that prevents the application
//    // from crashing when the user tries to input a non integer as the menu option
//
//    public static int getMenuInput() {
//        try {
//            int inputValue;
//            Scanner keyboard = new Scanner(System.in);
//            System.out.print("Input Value: ");
//            inputValue = keyboard.nextInt();
//            return inputValue;
//        } catch (InputMismatchException e) {
//            System.out.println("Pleaser enter a number..");
//        }
//        return 20;
//    }
//
//    //method that reads from the file placed and populates the user's farm
//    static void autoSetUp() {
//        try (Scanner sc = new Scanner(new File("CFarm3.txt"))) { //try with resources, no need for finally block
//            farm = new Farm(name);
//            //to hold the number of sheds to be created
//            int countOfSheds;
//
//            //store the name of the first Tank in the shed
//            String Tank1;
//
//            //store the name of the second shed
//            String Tank2;
//
//            //to store the capacity of tank1
//            double capacity1;
//
//            //to store the capacity of tank2
//            double capacity2;
//
//            //to store the number of animals in the first shed
//            int countFirstShed;
//
//            //to keep the type of the first Animal to be stored in the first shed
//            String firstAnimaltypefirstShed;
//
//            //to store the number of animals to be stored in the second shed
//            int countSecondShed;
//
//            //to keep the type of the second Animal to be stored in the second shed
//            String secondAnimaltypeShed;
//
//            //to store the number of animals to be stored in the third shed
//            int countThirdShed;
//
//            //to keep the type of the second Animal to be stored in the second shed
//            String thirdAnimaltypeShed;
//
//            while (sc.hasNext()) {
//                 countOfSheds = sc.nextInt();
//                //this reads the first integer from the file and populates the farm with the number of sheds
//                for(int i =0; i < countOfSheds; i++){
//                    Shed s = new Shed();
//                    farm.addShed(s);
//                }
//                Tank1 = sc.next();
//                capacity1 = sc.nextDouble();
//                Tank2 = sc.next();
//                capacity2 = sc.nextDouble();
//                MilkTank TankG = new MilkTank(Tank1,capacity1);
//                MilkTank TankC  = new MilkTank(Tank2,capacity2);
//
//                countFirstShed = sc.nextInt();
//                //the loop adds the next three lines of animals into the first shed
//                for(int i =0; i < countFirstShed; i++) {
//                    firstAnimaltypefirstShed = sc.next();
//                    Animal a;
//                    //following assumption that all data is valid
//                    if (firstAnimaltypefirstShed.equalsIgnoreCase("beefcow")) {
//                        a = new BeefCow(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
//                    } else if (firstAnimaltypefirstShed.equalsIgnoreCase("sheep")) {
//                        a = new Sheep(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
//                    } else if (firstAnimaltypefirstShed.equalsIgnoreCase("dairycow")) {
//                        a = new DiaryCow(sc.next());
//                    }
//                    else
//                    {
//                        a = new Goat(sc.next());
//                    }
//                    farm.getShed().get(0).addAnimal(a);
//                }
//
//                //since one shed can only have one type of milkable in a shed
//                //wrote this so that it checks if there is a goat or DairyCow in the shed
//                //if a goat connect the goat tank TankG or if DairyCow TankC or if no milkable just skip
//                int milkingCheck = 0;
//                for(Animal kk : farm.getShed().get(0).getHerd()){
//                    if(kk instanceof Goat){
//                        milkingCheck = 1;
//                        break;
//                    }
//                    else if(kk instanceof DiaryCow){
//                        milkingCheck = 2;
//                        break;
//                    }
//                    else{
//                        milkingCheck = 0;
//                    }
//                }
//                if(milkingCheck == 1){
//                    MilkingMachine m1 = new MilkingMachine(sc.next());
//                    farm.getShed().get(0).installMilkingMachine(m1);
//                    farm.getShed().get(0).setTank(TankG);
//                }
//                else if(milkingCheck == 2){
//                    MilkingMachine m1 = new MilkingMachine(sc.next());
//                    farm.getShed().get(0).installMilkingMachine(m1);
//                    farm.getShed().get(0).setTank(TankC);
//                }
//                else{
//                    sc.next();
//                }
//
//                countSecondShed = sc.nextInt();
//                for(int i =0; i < countSecondShed; i++) {
//                    secondAnimaltypeShed = sc.next();
//                    Animal a;
//                    //following assumption that all data is valid
//                    if (secondAnimaltypeShed.equalsIgnoreCase("beefcow")) {
//                        a = new BeefCow(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
//                    } else if (secondAnimaltypeShed.equalsIgnoreCase("sheep")) {
//                        a = new Sheep(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
//                    } else if (secondAnimaltypeShed.equalsIgnoreCase("dairycow")) {
//                        a = new DiaryCow(sc.next());
//                    }
//                    else
//                    {
//                        a = new Goat(sc.next());
//                    }
//                    farm.getShed().get(1).addAnimal(a);
//                }
//
//                countThirdShed = sc.nextInt();
//                for(int i =0; i < countThirdShed; i++) {
//                    thirdAnimaltypeShed = sc.next();
//                    Animal a;
//                    //following assumption that all data is valid
//                    if (thirdAnimaltypeShed.equalsIgnoreCase("beefcow")) {
//                        a = new BeefCow(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
//                    } else if (thirdAnimaltypeShed.equalsIgnoreCase("sheep")) {
//                        a = new Sheep(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
//                    } else if (thirdAnimaltypeShed.equalsIgnoreCase("dairycow")) {
//                        a = new DiaryCow(sc.next());
//                    }
//                    else
//                    {
//                        a = new Goat(sc.next());
//                    }
//                    farm.getShed().get(2).addAnimal(a);
//                }
//
//                //since one shed can only have one type of milkable in a shed
//                //wrote this so that it checks if there is a goat or DairyCow in the shed
//                //if a goat connect the goat tank TankG or if DairyCow TankC or if no milkable just skip
//                 milkingCheck = 0;
//                for(Animal kk : farm.getShed().get(0).getHerd()){
//                    if(kk instanceof Goat){
//                        milkingCheck = 1;
//                        break;
//                    }
//                    else if(kk instanceof DiaryCow){
//                        milkingCheck = 2;
//                        break;
//                    }
//                    else{
//                        milkingCheck = 0;
//                    }
//                }
//                if(milkingCheck == 1){
//                    MilkingMachine m1 = new MilkingMachine(sc.next());
//                    farm.getShed().get(2).installMilkingMachine(m1);
//                    farm.getShed().get(2).setTank(TankG);
//                }
//                else if(milkingCheck == 2){
//                    MilkingMachine m1 = new MilkingMachine(sc.next());
//                    farm.getShed().get(2).installMilkingMachine(m1);
//                    farm.getShed().get(2).setTank(TankG);
//                }
//                else{
//                    sc.next();
//                }
//
//
//                System.out.println();
//                System.out.println("+++ " + name +" successfully Populated+++");
//                System.out.println();
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not found");
//        }
//        income = 30000;
//        displayIncome();
//    }
//
//    //a amethod that allows the user to manually set up the farm
//    static void manualSetUp(){
//        boolean isRunning = true;
//        farm = new Farm(name);
//        displayIncome();
//        System.out.println("We need Sheds in the farm and Each shed cost 2000€");
//        System.out.print("How many Shed(s) would you like to create: ");
//        int countOfSheds = getMenuInput();
//        for(int i = 0; i < countOfSheds; i++){
//            Shed s = new Shed();
//            farm.addShed(s);
//        }
//        income = income - countOfSheds *2000;
//        displayIncome();
//
//        addToShed();
//    }
//
//    //a common method that carries adding operations on the farm shed
//    static void addToShed(){
//        Scanner keyboard =new Scanner(System.in);
//        boolean initial = true;
//        while(initial) {
//            //initially displays the sheds in the farm for the user to pick which shed to add to
//            farm.displaySheds();
//            System.out.println("What Shed would you like to add to");
//            System.out.println("OR Input 0 to go back");
//            int pickShed = getMenuInput();
//            if(pickShed != 0) {
//                boolean isRunning = true;
//                while (isRunning) {
//                    System.out.println("");
//                    System.out.println("What (more) would you like to add into your shed");
//                    System.out.println("******* 1. Goat *******");
//                    System.out.println("******* 2. Sheep *******");
//                    System.out.println("******* 3. BeefCow *******");
//                    System.out.println("******* 4. DairyCow *******");
//                    System.out.println("******* 5. Milking Machine *******");
//                    System.out.println("******* 0. Nothing Else *******");
//                    int choice = getMenuInput();
//                    switch (choice) {
//                        case 0:
//                            System.out.println("Exit");
//                            isRunning = false;
//                            break;
//
//                        case 1:
//                            System.out.println("Each goat Costs €2500");
//                            System.out.print("How many goats would you like to add: ");
//                            int m = getMenuInput();
//                            income = income - 2500 * m;
//                            for (int i = 0; i < m; i++) {
//                                Goat g1 = new Goat();
//                                System.out.print("Input name of goat(" + i + ") : ");
//                                String gName = keyboard.next();
//                                g1.setName(gName);
//                                farm.getShed().get(pickShed-1).addAnimal(g1);
//                            }
//                            displayIncome();
//                            break;
//
//                        case 2:
//                            System.out.println("Each Sheep Costs €3000");
//                            System.out.print("How many sheeps would you like to add: ");
//                            m = getMenuInput();
//                            income = income - 3000 * m;
//                            for (int i = 0; i < m; i++) {
//                                Sheep sh1 = new Sheep();
//                                System.out.print("Input name of Sheep(" + i + ") : ");
//                                String sh1Name = keyboard.next();
//                                sh1.setName(sh1Name);
//                                System.out.print("Input Pedigree for the sheep(" + i + ") : ");
//                                String sh1ped = keyboard.next();
//                                sh1.setPedigree(sh1ped);
//                                System.out.print("Input Weight for the sheep(" + i + ") : ");
//                                double sh1weight = keyboard.nextDouble();
//                                sh1.setWeight(sh1weight);
//                                System.out.print("Input Age for the sheep(" + i + ") : ");
//                                int sh1age = keyboard.nextInt();
//                                sh1.setAge(sh1age);
//                                farm.getShed().get(pickShed-1).addAnimal(sh1);
//                            }
//                            displayIncome();
//                            break;
//
//                        case 3:
//                            System.out.println("Each BeefCow Costs €5000");
//                            System.out.print("How many BeefCows would you like to add: ");
//                            m = getMenuInput();
//                            income = income - 5000 * m;
//                            for (int i = 0; i < m; i++) {
//                                BeefCow bc1 = new BeefCow();
//                                System.out.print("Input name of BeefCow(" + i + ") : ");
//                                String bc1Name = keyboard.next();
//                                bc1.setName(bc1Name);
//                                System.out.print("Input Pedigree for the BeefCow(" + i + ") : ");
//                                String bc1ped = keyboard.next();
//                                bc1.setPedigree(bc1ped);
//                                System.out.print("Input Weight for the BeefCow(" + i + ") : ");
//                                double bc1weight = keyboard.nextDouble();
//                                bc1.setWeight(bc1weight);
//                                System.out.print("Input Age for the BeefCow(" + i + ") : ");
//                                int bc1age = keyboard.nextInt();
//                                bc1.setAge(bc1age);
//                                farm.getShed().get(pickShed-1).addAnimal(bc1);
//                            }
//                            displayIncome();
//                            break;
//
//                        case 4:
//                            System.out.println("Each DiaryCow Costs €6000");
//                            System.out.print("How many DiaryCows would you like to add: ");
//                            m = getMenuInput();
//                            income = income - 6000 * m;
//                            for (int i = 0; i < m; i++) {
//                                DiaryCow dc1 = new DiaryCow();
//                                System.out.print("Input name of DiaryCow(" + i + ") : ");
//                                String dcName = keyboard.next();
//                                dc1.setName(dcName);
//                                farm.getShed().get(pickShed-1).addAnimal(dc1);
//                            }
//                            displayIncome();
//                            break;
//
//                        case 5:
//                            System.out.println("A milking Machine costs €10000");
//                            MilkTank tank1 = new MilkTank();
//                            System.out.print("Set the name of the Milking Machine: ");
//                            String m1Name = keyboard.next();
//                            MilkingMachine m1 = new MilkingMachine(m1Name);
//                            farm.getShed().get(pickShed-1).installMilkingMachine(m1);
//                            farm.getShed().get(pickShed-1).setTank(tank1);
//                            income = income - 10000;
//                            displayIncome();
//                            break;
//
//                        default:
//                            System.out.println("Invalid input! Please try again.");
//                            break;
//                    }
//                }
//            }
//            else{
//                System.out.println("Exit");
//                initial = false;
//            }
//        }
//    }
//
//    //method that displays the inital menu that gives the user an
//    // option to populate farm or hard code and build up utilities
//    public static void displayInitialSetUp() {
//        System.out.println("");
//        System.out.println("******* 1. Build Up Farm Set Up with already Made Utilities(Read From File). *******");
//        System.out.println("******* 2. Build Farm Set Up From Scratch.*******");
//        System.out.println("******* 0. Quit the program *******");
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Welcome Chief, Congratulations on your recent acquisition of the Farm Asset");
//        System.out.println("*******Please Input Your Name*******");
//        Scanner keyboard = new Scanner(System.in);
//        System.out.print("Name:  ");
//        String owner = keyboard.next();
//        //I created a public static variable name so that when the user inputs
//        // the name the application automatically stores that as the farm's name
//        name = owner + "'s Farm";
//
//        boolean isRunning = true;
//        while (isRunning) {
//
//           displayInitialSetUp();
//
//            int ca = getMenuInput();
//
//            switch (ca) {
//                case 1:
//                    //autosetup represents the set up directly made from reading the file
//                    autoSetUp();
//                 //   dailyOperations();
//                    isRunning = false;
//                    System.out.println("!!!!!Application Closed!!!!!");
//                    break;
//
//                case 2:
//                   manualSetUp();
//                 //   dailyOperations();
//                    isRunning = false;
//                    System.out.println("!!!!!Application Closed!!!!!");
//                    break;
//
//                case 0:
//                    System.out.println("Exit");
//                    isRunning = false;
//                    break;
//
//                default:
//                    System.out.println("Invalid input! Please try again.");
//                    break;
//            }
//        }
//    }
//}
