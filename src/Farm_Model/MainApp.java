package Farm_Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class MainApp {
    public static String name = "";
    public static int income = 75000;

    public static Farm farm;


    //got the design from https://stackoverflow.com/questions/27977973/how-to-use-print-format-to-make-box-around-text-java
    public static void displayIncome() {
        Scanner in = new Scanner(System.in);
        int length = 10;
        int spacesNeeded = 0;
        int size = 1;
        String[] inputs = new String[size];
        for (int i = 0; i < size; i++) {
            inputs[i] = "Revenue : €" + income;
        }
        System.out.print("+");

        int maxsize = 0;

        for (String s : inputs) {
            if (s.length() > maxsize) {
                maxsize = s.length();
            }
        }

        for (int i = 0; i <= maxsize + 1; i++) {
            System.out.print("-");
        }

        System.out.print("+");
        System.out.println();
        for (int j = 0; j < inputs.length; j++) {
            System.out.print("| " + inputs[j]);

            for (int i = inputs[j].length(); i <= maxsize; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println();

        }
        System.out.print("+");

        for (int i = 0; i <= maxsize + 1; i++) {
            System.out.print("-");
        }

        System.out.print("+");
        System.out.println();
    }

    //i made this general method to general use as the  input for menu that always prevents error
    public static int getMenuInput() {
        int t = -1;
        try {
            int inputValue;
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Input Value: ");
            inputValue = keyboard.nextInt();
            return inputValue;
        } catch (InputMismatchException e) {
            System.out.println("Pleaser enter a number..");
            return t;
        }
    }

    // a amethod to populate the farm using details given in a  file
    static void autoSetUp() {
        try (Scanner sc = new Scanner(new File("CFarm3.txt"))) { //try with resources, no need for finally block
            farm = new Farm(name);
            //to hold the number of sheds to be created
            int countOfSheds;

            //store the name of the first Tank in the shed
            String Tank1;

            //store the name of the second shed
            String Tank2;

            //to store the capacity of tank1
            double capacity1;

            //to store the capacity of tank2
            double capacity2;

            //to store the number of animals in the first shed
            int countFirstShed;

            //to keep the type of the first Animal to be stored in the first shed
            String firstAnimaltypefirstShed;

            //to store the number of animals to be stored in the second shed
            int countSecondShed;

            //to keep the type of the second Animal to be stored in the second shed
            String secondAnimaltypeShed;

            //to store the number of animals to be stored in the third shed
            int countThirdShed;

            //to keep the type of the second Animal to be stored in the second shed
            String thirdAnimaltypeShed;

            while (sc.hasNext()) {
                countOfSheds = sc.nextInt();
                //this reads the first integer from the file and populates the farm with the number of sheds
                for(int i =0; i < countOfSheds; i++){
                    Shed s = new Shed();
                    farm.addShed(s);
                }
                Tank1 = sc.next();
                capacity1 = sc.nextDouble();
                Tank2 = sc.next();
                capacity2 = sc.nextDouble();
                MilkTank TankG = new MilkTank(Tank1,capacity1);
                MilkTank TankC  = new MilkTank(Tank2,capacity2);

                countFirstShed = sc.nextInt();
                //the loop adds the next three lines of animals into the first shed
                for(int i =0; i < countFirstShed; i++) {
                    firstAnimaltypefirstShed = sc.next();
                    Animal a;
                    //following assumption that all data is valid
                    if (firstAnimaltypefirstShed.equalsIgnoreCase("beefcow")) {
                        a = new BeefCow(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
                    } else if (firstAnimaltypefirstShed.equalsIgnoreCase("sheep")) {
                        a = new Sheep(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
                    } else if (firstAnimaltypefirstShed.equalsIgnoreCase("dairycow")) {
                        a = new DiaryCow(sc.next());
                    }
                    else
                    {
                        a = new Goat(sc.next());
                    }
                    farm.getShed().get(0).addAnimal(a);
                }

                //since one shed can only have one type of milkable in a shed
                //wrote this so that it checks if there is a goat or DairyCow in the shed
                //if a goat connect the goat tank TankG or if DairyCow TankC or if no milkable just skip
                int milkingCheck = 0;
                for(Animal kk : farm.getShed().get(0).getHerd()){
                    if(kk instanceof Goat){
                        milkingCheck = 1;
                        break;
                    }
                    else if(kk instanceof DiaryCow){
                        milkingCheck = 2;
                        break;
                    }
                    else{
                        milkingCheck = 0;
                    }
                }
                if(milkingCheck == 1){
                    MilkingMachine m1 = new MilkingMachine(sc.next());
                    farm.getShed().get(0).installMilkingMachine(m1);
                    farm.getShed().get(0).setTank(TankG);
                }
                else if(milkingCheck == 2){
                    MilkingMachine m1 = new MilkingMachine(sc.next());
                    farm.getShed().get(0).installMilkingMachine(m1);
                    farm.getShed().get(0).setTank(TankC);
                }
                else{
                    sc.next();
                }

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

                countThirdShed = sc.nextInt();
                for(int i =0; i < countThirdShed; i++) {
                    thirdAnimaltypeShed = sc.next();
                    Animal a;
                    //following assumption that all data is valid
                    if (thirdAnimaltypeShed.equalsIgnoreCase("beefcow")) {
                        a = new BeefCow(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
                    } else if (thirdAnimaltypeShed.equalsIgnoreCase("sheep")) {
                        a = new Sheep(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
                    } else if (thirdAnimaltypeShed.equalsIgnoreCase("dairycow")) {
                        a = new DiaryCow(sc.next());
                    }
                    else
                    {
                        a = new Goat(sc.next());
                    }
                    farm.getShed().get(1).addAnimal(a);
                }

                //since one shed can only have one type of milkable in a shed
                //wrote this so that it checks if there is a goat or DairyCow in the shed
                //if a goat connect the goat tank TankG or if DairyCow TankC or if no milkable just skip
                milkingCheck = 0;
                for(Animal kk : farm.getShed().get(0).getHerd()){
                    if(kk instanceof Goat){
                        milkingCheck = 1;
                        break;
                    }
                    else if(kk instanceof DiaryCow){
                        milkingCheck = 2;
                        break;
                    }
                    else{
                        milkingCheck = 0;
                    }
                }
                if(milkingCheck == 1){
                    MilkingMachine m1 = new MilkingMachine(sc.next());
                    farm.getShed().get(1).installMilkingMachine(m1);
                    farm.getShed().get(1).setTank(TankG);
                }
                else if(milkingCheck == 2){
                    MilkingMachine m1 = new MilkingMachine(sc.next());
                    farm.getShed().get(1).installMilkingMachine(m1);
                    farm.getShed().get(1).setTank(TankG);
                }
                else{
                    sc.next();
                }


                System.out.println();
                System.out.println("+++ " + name +" successfully Populated+++");
                System.out.println();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        income = 30000;
        displayIncome();
    }

    //method was created to allow the user to manually fill up the farm with sheds and animals
    static void manualSetUp() {
        boolean isRunning = true;

        Scanner keyboard = new Scanner(System.in);
        try {
            farm = new Farm(name);
            displayIncome();
            System.out.println("We need Sheds in the farm and Each shed cost 2000€");
            System.out.println("How many Sheds would you like to create 1/2");
            System.out.println();
            while (isRunning) {
                int count = getMenuInput();
                switch (count) {
                    case 1:
                        Shed s1 = new Shed();
                        farm.addShed(s1);
                        boolean addi = true;
                        while (addi) {
                            initialAdd();
                            int choice = getMenuInput();
                            switch (choice) {
                                case 0:
                                    System.out.println("Exit");
                                    addi = false;
                                    break;

                                case 1:
                                    System.out.print("How many goats would you like to add: ");
                                    System.out.println();
                                    int m = getMenuInput();
                                    for (int i = 0; i < m; i++) {
                                        Goat g1 = new Goat();
                                        System.out.print("Input name of goat(" + i + ") : ");
                                        String gName = keyboard.next();
                                        g1.setName(gName);
                                        s1.addAnimal(g1);
                                    }
                                    break;

                                case 2:
                                    System.out.print("How many sheeps would you like to add: ");
                                    m = keyboard.nextInt();
                                    for (int i = 0; i < m; i++) {
                                        Sheep sh1 = new Sheep();
                                        System.out.print("Input name of Sheep(" + i + ") : ");
                                        String sh1Name = keyboard.next();
                                        sh1.setName(sh1Name);
                                        System.out.print("Input Pedigree for the sheep(" + i + ") : ");
                                        String sh1ped = keyboard.next();
                                        sh1.setPedigree(sh1ped);
                                        System.out.print("Input Weight for the sheep(" + i + ") : ");
                                        double sh1weight = keyboard.nextDouble();
                                        sh1.setWeight(sh1weight);
                                        System.out.print("Input Age for the sheep(" + i + ") : ");
                                        int sh1age = keyboard.nextInt();
                                        sh1.setAge(sh1age);
                                        s1.addAnimal(sh1);
                                    }
                                    break;

                                case 3:
                                    System.out.print("How many BeefCows would you like to add: ");
                                    m = keyboard.nextInt();
                                    for (int i = 0; i < m; i++) {
                                        BeefCow bc1 = new BeefCow();
                                        System.out.print("Input name of BeefCow(" + i + ") : ");
                                        String bc1Name = keyboard.next();
                                        bc1.setName(bc1Name);
                                        System.out.print("Input Pedigree for the BeefCow(" + i + ") : ");
                                        String bc1ped = keyboard.next();
                                        bc1.setPedigree(bc1ped);
                                        System.out.print("Input Weight for the BeefCow(" + i + ") : ");
                                        double bc1weight = keyboard.nextDouble();
                                        bc1.setWeight(bc1weight);
                                        System.out.print("Input Age for the BeefCow(" + i + ") : ");
                                        int bc1age = keyboard.nextInt();
                                        bc1.setAge(bc1age);
                                        s1.addAnimal(bc1);
                                    }
                                    break;

                                case 4:
                                    System.out.print("How many DiaryCows would you like to add: ");
                                    m = keyboard.nextInt();
                                    for (int i = 0; i < m; i++) {
                                        DiaryCow dc1 = new DiaryCow();
                                        System.out.print("Input name of DiaryCow(" + i + ") : ");
                                        String dcName = keyboard.next();
                                        dc1.setName(dcName);
                                        s1.addAnimal(dc1);
                                    }
                                    break;

                                case 5:
                                    MilkTank tank1 = new MilkTank();
                                    System.out.print("Set the name of the Milking Machine: ");
                                    String m1Name = keyboard.next();
                                    MilkingMachine m1 = new MilkingMachine(m1Name);
                                    s1.installMilkingMachine(m1);
                                    s1.setTank(tank1);
                                    break;

                                default:
                                    System.out.println("Invalid input! Please try again.");
                                    break;
                            }
                        }
                        isRunning = false;
                        break;

                    case 2:
                        Shed s2 = new Shed();
                        Shed s3 = new Shed();
                        farm.addShed(s2);
                        farm.addShed(s3);
                        income = income - 4000;
                        displayIncome();
                        boolean pp = true;
                        while (pp) {
                            System.out.println("Which Shed would you like to add to: 1/2 -- ");
                            System.out.println("Input (0) if you don't want to add anymore");
                            System.out.println();
                            int pick = getMenuInput();
                            switch (pick) {
                                case 1:
                                    boolean ck = true;
                                    while (ck) {
                                        initialAdd();
                                        int choice = getMenuInput();
                                        switch (choice) {
                                            case 0:
                                                System.out.println("Exit");
                                                ck = false;
                                                break;

                                            case 1:
                                                System.out.print("How many goats would you like to add: ");
                                                int m = getMenuInput();
                                                for (int i = 0; i < m; i++) {
                                                    Goat g1 = new Goat();
                                                    System.out.print("Input name of goat(" + i + ") : ");
                                                    String gName = keyboard.next();
                                                    g1.setName(gName);
                                                    s2.addAnimal(g1);
                                                }
                                                break;

                                            case 2:
                                                System.out.print("How many sheeps would you like to add: ");
                                                m = keyboard.nextInt();
                                                for (int i = 0; i < m; i++) {
                                                    Sheep sh1 = new Sheep();
                                                    System.out.print("Input name of Sheep(" + i + ") : ");
                                                    String sh1Name = keyboard.next();
                                                    sh1.setName(sh1Name);
                                                    System.out.print("Input Pedigree for the sheep(" + i + ") : ");
                                                    String sh1ped = keyboard.next();
                                                    sh1.setPedigree(sh1ped);
                                                    System.out.print("Input Weight for the sheep(" + i + ") : ");
                                                    double sh1weight = keyboard.nextDouble();
                                                    sh1.setWeight(sh1weight);
                                                    System.out.print("Input Age for the sheep(" + i + ") : ");
                                                    int sh1age = keyboard.nextInt();
                                                    sh1.setAge(sh1age);
                                                    s2.addAnimal(sh1);
                                                }
                                                break;

                                            case 3:
                                                System.out.print("How many BeefCows would you like to add: ");
                                                m = keyboard.nextInt();
                                                for (int i = 0; i < m; i++) {
                                                    BeefCow bc1 = new BeefCow();
                                                    System.out.print("Input name of BeefCow(" + i + ") : ");
                                                    String bc1Name = keyboard.next();
                                                    bc1.setName(bc1Name);
                                                    System.out.print("Input Pedigree for the BeefCow(" + i + ") : ");
                                                    String bc1ped = keyboard.next();
                                                    bc1.setPedigree(bc1ped);
                                                    System.out.print("Input Weight for the BeefCow(" + i + ") : ");
                                                    double bc1weight = keyboard.nextDouble();
                                                    bc1.setWeight(bc1weight);
                                                    System.out.print("Input Age for the BeefCow(" + i + ") : ");
                                                    int bc1age = keyboard.nextInt();
                                                    bc1.setAge(bc1age);
                                                    s2.addAnimal(bc1);
                                                }
                                                break;

                                            case 4:
                                                System.out.print("How many DiaryCows would you like to add: ");
                                                m = keyboard.nextInt();
                                                for (int i = 0; i < m; i++) {
                                                    DiaryCow dc1 = new DiaryCow();
                                                    System.out.print("Input name of DiaryCow(" + i + ") : ");
                                                    String dcName = keyboard.next();
                                                    dc1.setName(dcName);
                                                    s2.addAnimal(dc1);
                                                }
                                                break;

                                            case 5:
                                                MilkTank tank1 = new MilkTank();
                                                System.out.print("Set the name of the Milking Machine: ");
                                                String m1Name = keyboard.next();
                                                MilkingMachine m1 = new MilkingMachine(m1Name);
                                                s2.installMilkingMachine(m1);
                                                s2.setTank(tank1);
                                                break;

                                            default:
                                                System.out.println("Invalid input! Please try again.");
                                                break;
                                        }
                                    }
                                    break;

                                case 2:
                                    ck = true;
                                    while (ck) {
                                        initialAdd();
                                        int choice = getMenuInput();
                                        switch (choice) {
                                            case 0:
                                                System.out.println("Exit");
                                                ck = false;
                                                break;

                                            case 1:
                                                System.out.print("How many goats would you like to add: ");
                                                int m = keyboard.nextInt();
                                                for (int i = 0; i < m; i++) {
                                                    Goat g1 = new Goat();
                                                    System.out.print("Input name of goat(" + i + ") : ");
                                                    String gName = keyboard.next();
                                                    g1.setName(gName);
                                                    s3.addAnimal(g1);
                                                }
                                                break;

                                            case 2:
                                                System.out.print("How many sheeps would you like to add: ");
                                                m = keyboard.nextInt();
                                                for (int i = 0; i < m; i++) {
                                                    Sheep sh1 = new Sheep();
                                                    System.out.print("Input name of Sheep(" + i + ") : ");
                                                    String sh1Name = keyboard.next();
                                                    sh1.setName(sh1Name);
                                                    System.out.print("Input Pedigree for the sheep(" + i + ") : ");
                                                    String sh1ped = keyboard.next();
                                                    sh1.setPedigree(sh1ped);
                                                    System.out.print("Input Weight for the sheep(" + i + ") : ");
                                                    double sh1weight = keyboard.nextDouble();
                                                    sh1.setWeight(sh1weight);
                                                    System.out.print("Input Age for the sheep(" + i + ") : ");
                                                    int sh1age = keyboard.nextInt();
                                                    sh1.setAge(sh1age);
                                                    s3.addAnimal(sh1);
                                                }
                                                break;

                                            case 3:
                                                System.out.print("How many BeefCows would you like to add: ");
                                                m = keyboard.nextInt();
                                                for (int i = 0; i < m; i++) {
                                                    BeefCow bc1 = new BeefCow();
                                                    System.out.print("Input name of BeefCow(" + i + ") : ");
                                                    String bc1Name = keyboard.next();
                                                    bc1.setName(bc1Name);
                                                    System.out.print("Input Pedigree for the BeefCow(" + i + ") : ");
                                                    String bc1ped = keyboard.next();
                                                    bc1.setPedigree(bc1ped);
                                                    System.out.print("Input Weight for the BeefCow(" + i + ") : ");
                                                    double bc1weight = keyboard.nextDouble();
                                                    bc1.setWeight(bc1weight);
                                                    System.out.print("Input Age for the BeefCow(" + i + ") : ");
                                                    int bc1age = keyboard.nextInt();
                                                    bc1.setAge(bc1age);
                                                    s3.addAnimal(bc1);
                                                }
                                                break;

                                            case 4:
                                                System.out.print("How many DiaryCows would you like to add: ");
                                                m = keyboard.nextInt();
                                                for (int i = 0; i < m; i++) {
                                                    DiaryCow dc1 = new DiaryCow();
                                                    System.out.print("Input name of DiaryCow(" + i + ") : ");
                                                    String dcName = keyboard.next();
                                                    dc1.setName(dcName);
                                                    s3.addAnimal(dc1);
                                                }
                                                break;

                                            case 5:
                                                MilkTank tank1 = new MilkTank();
                                                System.out.print("Set the name of the Milking Machine: ");
                                                String m1Name = keyboard.next();
                                                MilkingMachine m1 = new MilkingMachine(m1Name);
                                                s3.installMilkingMachine(m1);
                                                s3.setTank(tank1);
                                                break;

                                            default:
                                                System.out.println("Invalid input! Please try again.");
                                                break;
                                        }
                                    }
                                    break;

                                case 0:
                                    System.out.println("Exit");
                                    pp = false;
                                    break;

                                default:
                                    System.out.println("Invalid input! Please try again.");
                                    break;
                            }
                        }
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Invalid input! Please try again.");
                        break;
                }
            }
        }
        catch(InputMismatchException e){
            System.out.println("Invalid Input - Back To Menu");
        }
    }

    public static void initialAdd() {
        System.out.println("");
        System.out.println("What (more) would you like to add into your shed");
        System.out.println("******* 1. Goat *******");
        System.out.println("******* 2. Sheep *******");
        System.out.println("******* 3. BeefCow *******");
        System.out.println("******* 4. DairyCow *******");
        System.out.println("******* 5. Milking Machine *******");
        System.out.println("******* 0. Nothing Else *******");
        System.out.println();
    }

    public static void menuAdd() {
        System.out.println("");
        System.out.println("What (more) would you like to add into your shed");
        System.out.println("******* 1. Goat *******");
        System.out.println("******* 2. Sheep *******");
        System.out.println("******* 3. BeefCow *******");
        System.out.println("******* 4. DairyCow *******");
        System.out.println("******* 0. Nothing Else *******");
        System.out.println();
    }
    public static void dailyOperations() {
        Scanner keyboard = new Scanner(System.in);
        try{
            boolean isRun = true;

            while (isRun) {
                System.out.println();
                System.out.println("*****Which Factor on the farm would you like to deal with*****");
                System.out.println("**********Daily Operations**********");
                System.out.println("1)*****Animal*****");
                System.out.println("2)*****Shed*****");
                System.out.println("3)*****Print Details of The Farm*****");
                System.out.println("4)*****Milk All Animals on the Farm*****");
                System.out.println("5)*****An Animal Died*****");
                System.out.println("6)*****Tankers are here to buy the Milk stored*****");
                System.out.println("7)*****Sort Animals On The Farm*****");
                System.out.println("8)*****Print Details Of Farm to Text*****");
                System.out.println("0)*****Exit Application*****");
                System.out.println();


                int jk = getMenuInput();

                //used to pick the daily operations
                switch (jk) {
                    //work with Animal
                    case 1:
                        System.out.println("There are " + farm.getCountOfSheds() + " Shed(s) in " + name);
                        for(int i = 0; i < farm.getCountOfSheds(); i++){
                            System.out.println((i+1) +"-Shed: " + farm.getShed().get(i).getUniqueId());
                        }
                        boolean fg= true;
                        while(fg){
                            System.out.print("Pick the Shed you would like to manipulate the Animal (1/2) :");
                            int vd = getMenuInput();
                            //used to pick between the only two sheds
                            switch(vd){
                                case 1:
                                    boolean jh = true;
                                    while(jh){
                                        animalMenu();
                                        int bg = getMenuInput();
                                        //pick between add/edit/del/print animal
                                        switch (bg){
                                            //add animal
                                            case 1:
                                                boolean  ck = true;
                                                while (ck) {
                                                    menuAdd();
                                                    int choice = getMenuInput();
                                                    switch (choice) {
                                                        case 1:
                                                            System.out.print("How many goats would you like to add: ");
                                                            int m = keyboard.nextInt();
                                                            for (int i = 0; i < m; i++) {
                                                                Goat g1 = new Goat();
                                                                System.out.print("Input name of goat(" + i + ") : ");
                                                                String gName = keyboard.next();
                                                                g1.setName(gName);
                                                                farm.getShed().get(0).addAnimal(g1);
                                                            }
                                                            break;

                                                        case 2:
                                                            System.out.print("How many sheeps would you like to add: ");
                                                            m = keyboard.nextInt();
                                                            for (int i = 0; i < m; i++) {
                                                                Sheep sh1 = new Sheep();
                                                                System.out.print("Input name of Sheep(" + i + ") : ");
                                                                String sh1Name = keyboard.next();
                                                                sh1.setName(sh1Name);
                                                                System.out.print("Input Pedigree for the sheep(" + i + ") : ");
                                                                String sh1ped = keyboard.next();
                                                                sh1.setPedigree(sh1ped);
                                                                System.out.print("Input Weight for the sheep(" + i + ") : ");
                                                                double sh1weight = keyboard.nextDouble();
                                                                sh1.setWeight(sh1weight);
                                                                System.out.print("Input Age for the sheep(" + i + ") : ");
                                                                int sh1age = keyboard.nextInt();
                                                                sh1.setAge(sh1age);
                                                                farm.getShed().get(0).addAnimal(sh1);
                                                            }
                                                            break;

                                                        case 3:
                                                            System.out.print("How many BeefCows would you like to add: ");
                                                            m = keyboard.nextInt();
                                                            for (int i = 0; i < m; i++) {
                                                                BeefCow bc1 = new BeefCow();
                                                                System.out.print("Input name of BeefCow(" + i + ") : ");
                                                                String bc1Name = keyboard.next();
                                                                bc1.setName(bc1Name);
                                                                System.out.print("Input Pedigree for the BeefCow(" + i + ") : ");
                                                                String bc1ped = keyboard.next();
                                                                bc1.setPedigree(bc1ped);
                                                                System.out.print("Input Weight for the BeefCow(" + i + ") : ");
                                                                double bc1weight = keyboard.nextDouble();
                                                                bc1.setWeight(bc1weight);
                                                                System.out.print("Input Age for the BeefCow(" + i + ") : ");
                                                                int bc1age = keyboard.nextInt();
                                                                bc1.setAge(bc1age);
                                                                farm.getShed().get(0).addAnimal(bc1);
                                                            }
                                                            break;

                                                        case 4:
                                                            System.out.print("How many DiaryCows would you like to add: ");
                                                            m = keyboard.nextInt();
                                                            for (int i = 0; i < m; i++) {
                                                                DiaryCow dc1 = new DiaryCow();
                                                                System.out.print("Input name of DiaryCow(" + i + ") : ");
                                                                String dcName = keyboard.next();
                                                                dc1.setName(dcName);
                                                                farm.getShed().get(0).addAnimal(dc1);
                                                            }
                                                            break;

                                                        case 0:
                                                            System.out.println("Exit");
                                                            ck = false;
                                                            break;

                                                        default:
                                                            System.out.println("Invalid input! Please try again.");
                                                            break;
                                                    }
                                                }
                                                break;

                                            //edit animal
                                            case 2:
                                                boolean ed = true;
                                                while(ed){
                                                    farm.getShed().get(0).displayAnimals();
                                                    System.out.print("Choose the animal you wish to edit: ");
                                                    int ped = keyboard.nextInt();
                                                    for(int i = 0; i < farm.getShed().get(0).getHerd().size()+1;i++){
                                                        if(ped == (i+1)){
                                                            System.out.print("Input the new Name of the Animal: ");
                                                            String newName = keyboard.next();
                                                            farm.getShed().get(0).getHerd().get(i).setName(newName);
                                                            System.out.println((i+1)+")"+farm.getShed().get(0).getHerd().get(i));
                                                        }
                                                    }
                                                    ed = false;
                                                }
                                                break;

                                            //delete an animal
                                            case 3:
                                                boolean po = true;
                                                while(po){
                                                    farm.getShed().get(0).displayAnimals();
                                                    System.out.print("Choose the animal you wish to delete: ");
                                                    int ped = keyboard.nextInt();
                                                    for(int i = 0; i < farm.getShed().get(0).getHerd().size()+1;i++){
                                                        if(ped == (i+1)){
                                                            farm.getShed().get(0).getHerd().remove(i);
                                                            farm.getShed().get(0).displayAnimals();
                                                        }
                                                    }
                                                    po = false;
                                                }
                                                break;

                                            case 0:
                                                System.out.println("Exit");
                                                jh = false;
                                                break;

                                            default:
                                                System.out.println("Invalid input! Please try again.");
                                                break;
                                        }

                                    }
                                    break;

                                case 2:
                                    boolean ab = true;
                                    while(ab){
                                        animalMenu();
                                        int bg = getMenuInput();
                                        //pick between add/edit/del/print animal
                                        switch (bg){
                                            //add animal
                                            case 1:
                                                boolean  ck = true;
                                                while (ck) {
                                                    menuAdd();
                                                    int choice = getMenuInput();
                                                    switch (choice) {
                                                        case 1:
                                                            System.out.print("How many goats would you like to add: ");
                                                            int m = keyboard.nextInt();
                                                            for (int i = 0; i < m; i++) {
                                                                Goat g1 = new Goat();
                                                                System.out.print("Input name of goat(" + i + ") : ");
                                                                String gName = keyboard.next();
                                                                g1.setName(gName);
                                                                farm.getShed().get(1).addAnimal(g1);
                                                            }
                                                            break;

                                                        case 2:
                                                            System.out.print("How many sheeps would you like to add: ");
                                                            m = keyboard.nextInt();
                                                            for (int i = 0; i < m; i++) {
                                                                Sheep sh1 = new Sheep();
                                                                System.out.print("Input name of Sheep(" + i + ") : ");
                                                                String sh1Name = keyboard.next();
                                                                sh1.setName(sh1Name);
                                                                System.out.print("Input Pedigree for the sheep(" + i + ") : ");
                                                                String sh1ped = keyboard.next();
                                                                sh1.setPedigree(sh1ped);
                                                                System.out.print("Input Weight for the sheep(" + i + ") : ");
                                                                double sh1weight = keyboard.nextDouble();
                                                                sh1.setWeight(sh1weight);
                                                                System.out.print("Input Age for the sheep(" + i + ") : ");
                                                                int sh1age = keyboard.nextInt();
                                                                sh1.setAge(sh1age);
                                                                farm.getShed().get(1).addAnimal(sh1);
                                                            }
                                                            break;

                                                        case 3:
                                                            System.out.print("How many BeefCows would you like to add: ");
                                                            m = keyboard.nextInt();
                                                            for (int i = 0; i < m; i++) {
                                                                BeefCow bc1 = new BeefCow();
                                                                System.out.print("Input name of BeefCow(" + i + ") : ");
                                                                String bc1Name = keyboard.next();
                                                                bc1.setName(bc1Name);
                                                                System.out.print("Input Pedigree for the BeefCow(" + i + ") : ");
                                                                String bc1ped = keyboard.next();
                                                                bc1.setPedigree(bc1ped);
                                                                System.out.print("Input Weight for the BeefCow(" + i + ") : ");
                                                                double bc1weight = keyboard.nextDouble();
                                                                bc1.setWeight(bc1weight);
                                                                System.out.print("Input Age for the BeefCow(" + i + ") : ");
                                                                int bc1age = keyboard.nextInt();
                                                                bc1.setAge(bc1age);
                                                                farm.getShed().get(1).addAnimal(bc1);
                                                            }
                                                            break;

                                                        case 4:
                                                            System.out.print("How many DiaryCows would you like to add: ");
                                                            m = keyboard.nextInt();
                                                            for (int i = 0; i < m; i++) {
                                                                DiaryCow dc1 = new DiaryCow();
                                                                System.out.print("Input name of DiaryCow(" + i + ") : ");
                                                                String dcName = keyboard.next();
                                                                dc1.setName(dcName);
                                                                farm.getShed().get(1).addAnimal(dc1);
                                                            }
                                                            break;

                                                        case 0:
                                                            System.out.println("Exit");
                                                            ck = false;
                                                            break;

                                                        default:
                                                            System.out.println("Invalid input! Please try again.");
                                                            break;
                                                    }
                                                }
                                                break;

                                            //edit animal
                                            case 2:
                                                boolean ed = true;
                                                while(ed){
                                                    farm.getShed().get(1).displayAnimals();
                                                    System.out.print("Choose the animal you wish to edit: ");
                                                    int ped = keyboard.nextInt();
                                                    for(int i = 0; i < farm.getShed().get(1).getHerd().size()+1;i++){
                                                        if(ped == (i+1)){
                                                            System.out.print("Input the new Name of the Animal: ");
                                                            String newName = keyboard.next();
                                                            farm.getShed().get(1).getHerd().get(i).setName(newName);
                                                            System.out.println((i+1)+")"+farm.getShed().get(1).getHerd().get(i));
                                                        }
                                                    }
                                                    ed = false;
                                                }
                                                break;

                                            //delete an animal
                                            case 3:
                                                boolean po = true;
                                                while(po){
                                                    farm.getShed().get(1).displayAnimals();
                                                    System.out.print("Choose the animal you wish to delete: ");
                                                    int ped = keyboard.nextInt();
                                                    for(int i = 0; i < farm.getShed().get(1).getHerd().size()+1;i++){
                                                        if(ped == (i+1)){
                                                            farm.getShed().get(1).getHerd().remove(i);
                                                            farm.getShed().get(1).displayAnimals();
                                                        }
                                                    }
                                                    po = false;
                                                }
                                                break;

                                            case 0:
                                                System.out.println("Exit");
                                                ab = false;
                                                break;

                                            default:
                                                System.out.println("Invalid input! Please try again.");
                                                break;
                                        }

                                    }
                                    break;

                                case 0:
                                    fg = false;
                                    break;

                                default:
                                    System.out.println("Invalid input! Please try again.");
                                    break;

                            }
                        }
                        break;

                    //work with shed
                    case 2:
                        boolean gg = true;
                        while(gg){
                            System.out.println();
                            System.out.println("There are " + farm.getCountOfSheds() + " Shed(s) in " + name);
                            for(int i = 0; i < farm.getCountOfSheds(); i++){
                                System.out.println((i+1) +"-Shed: " + farm.getShed().get(i).getUniqueId());
                            }
                            System.out.print("Pick Shed you would like to edit:  (1/2) ");
                            System.out.println("\n0 --- Takes back to Menu");
                            int edr = getMenuInput();
                            switch(edr){
                                //first shed
                                case 1:
                                    boolean gf = true;
                                    while(gf){
                                        editShedMenu();
                                        int df = getMenuInput();
                                        switch(df){
                                            //edit the first shed
                                            case 1:
                                                System.out.println("Connecting The Shed to A Milking Machine");
                                                if(farm.getShed().get(0).getTank() != null){
                                                    System.out.println("Shed Already has a connecting Tank");
                                                }
                                                else{
                                                    MilkingMachine ll = new MilkingMachine();
                                                    MilkTank sc = new MilkTank();
                                                    farm.getShed().get(0).installMilkingMachine(ll);
                                                    farm.getShed().get(0).setTank(sc);
                                                    System.out.println("-----------------INSTALLATION SUCCESSFUL---------------");
                                                }
                                                break;

                                            //print details of the shed
                                            case 3:
                                                System.out.println(farm.getShed().get(0));
                                                break;

                                            //delete the shed
                                            case 2:
                                                farm.getShed().remove(0);
                                                System.out.println(farm);
                                                break;

                                            case 0:
                                                gf = false;
                                                break;

                                            default:
                                                System.out.println("Invalid input! Please try again.");
                                                break;
                                        }
                                    }
                                    break;

                                //second shed
                                case 2:
                                    gf = true;
                                    while(gf){
                                        editShedMenu();
                                        int df = getMenuInput();
                                        switch(df){
                                            //edit the second shed
                                            case 1:
                                                System.out.println("Connecting The Shed to A Milking Machine");
                                                if(farm.getShed().get(1).getTank() != null){
                                                    System.out.println("Shed Already has a connecting Tank");
                                                }
                                                else{
                                                    MilkingMachine ll = new MilkingMachine();
                                                    MilkTank sc = new MilkTank();
                                                    farm.getShed().get(1).installMilkingMachine(ll);
                                                    farm.getShed().get(1).setTank(sc);
                                                    System.out.println("-----------------INSTALLATION SUCCESSFUL---------------");
                                                }
                                                break;

                                            //print details of the shed
                                            case 3:
                                                System.out.println(farm.getShed().get(1));
                                                break;

                                            //delete the shed
                                            case 2:
                                                farm.getShed().remove(1);
                                                System.out.println(farm);
                                                break;

                                            case 0:
                                                gf = false;
                                                break;

                                            default:
                                                System.out.println("Invalid input! Please try again.");
                                                break;
                                        }
                                    }
                                    break;

                                //exit
                                case 0:
                                    gg = false;
                                    break;

                                default:
                                    System.out.println("Invalid input! Please try again.");
                                    break;
                            }
                        }
                        break;

                    //print the detail of the farm
                    case 3:
                        System.out.println(farm);
                        break;

                    //Milk the animals on the farm
                    case 4:
                        double totalDailyProduce = 0;
                        for(int i = 0; i < farm.getCountOfSheds(); i++){
                            totalDailyProduce = totalDailyProduce + farm.getShed().get(i).milkShed();
                        }
                        System.out.println("Total Amount Of Milk Produced Today: " + totalDailyProduce + " litres");
                        System.out.println();
                        System.out.println();
                        break;

                    //death of an animal
                    case 5:
                        Random rand = new Random();
                        //to pick between the two sheds for the animal to die from
                        int killShed = rand.nextInt(0,farm.getCountOfSheds());
                        //to random select an animal that will die
                        int killAnimal = rand.nextInt(0,farm.getShed().get(killShed).getHerd().size());
                        System.out.println(farm.getShed().get(killShed).getHerd().get(killAnimal) + " has passed away");
                        farm.getShed().get(killShed).getHerd().remove(killAnimal);
                        break;

                    //milk collection empties all tanks
                    case 6:
                        Random yup = new Random();
                        int cash = yup.nextInt(2000,5001);
                        for(int i = 0; i < farm.getCountOfSheds(); i++){
                            farm.getShed().get(i).getTank().emptyTank();
                        }
                        System.out.println("Revenue Generated From Collection: €" + cash);
                        income = income + (cash);
                        displayIncome();
                        break;

                    //sort animals
                    case 7:
                        boolean uj = true;
                        while(uj) {
                            System.out.println("Pick the Shed you would like to sort the Animals");
                            int sortKey = getMenuInput();

                            switch(sortKey){
                                case 1:
                                    boolean sk = true;
                                    while(sk){
                                        System.out.println();
                                        System.out.println("Pick the animal group to Sort");
                                        System.out.println("*****1.Goat  - Natural Order *****");
                                        System.out.println("*****2.BeefCow - Natural Order *****");
                                        System.out.println("*****3.Sheep - Natural Order*****");
                                        System.out.println("*****4.DairyCow - Natural Order *****");
                                        System.out.println("*****5.BeefCow - Desc Order Weight *****");
                                        System.out.println("*****6.Sheep - Desc Order Age *****");
                                        System.out.println("*****0.Go Back *****");
                                        System.out.println();
                                        int ap = getMenuInput();
                                        switch(ap){
                                            case 1:
                                                ArrayList<Goat> listG = new ArrayList<>();
                                                for(int i = 0; i < farm.getShed().get(0).getHerd().size();i++){
                                                    if(farm.getShed().get(0).getHerd().get(i) instanceof Goat){
                                                        listG.add((Goat) farm.getShed().get(0).getHerd().get(i));
                                                    }
                                                }
                                                System.out.println("Display of Goats Before Sorting");
                                                System.out.println(listG);
                                                ArrayList<Goat> sortedListG = new ArrayList<>();
                                                for(int i = 0; i < farm.getShed().get(0).getHerd().size();i++){
                                                    if(farm.getShed().get(0).getHerd().get(i) instanceof Goat){
                                                        sortedListG.add((Goat) farm.getShed().get(0).getHerd().get(i));
                                                    }
                                                }
                                                Collections.sort(sortedListG);
                                                System.out.println("Display Of Goats After Sorting");
                                                System.out.println(sortedListG);
                                                break;

                                            case 2:
                                                ArrayList<BeefCow> listB = new ArrayList<>();
                                                for(int i = 0; i < farm.getShed().get(0).getHerd().size();i++){
                                                    if(farm.getShed().get(0).getHerd().get(i) instanceof BeefCow){
                                                        listB.add((BeefCow) farm.getShed().get(0).getHerd().get(i));
                                                    }
                                                }
                                                System.out.println("Display of BeefCows Before Sorting");
                                                System.out.println(listB);
                                                ArrayList<BeefCow> sortedListB = new ArrayList<>();
                                                for(int i = 0; i < farm.getShed().get(0).getHerd().size();i++){
                                                    if(farm.getShed().get(0).getHerd().get(i) instanceof BeefCow){
                                                        sortedListB.add((BeefCow) farm.getShed().get(0).getHerd().get(i));
                                                    }
                                                }
                                                Collections.sort(sortedListB);
                                                System.out.println("Display Of BeefCows After Sorting");
                                                System.out.println(sortedListB);
                                                break;

                                            case 3:
                                                ArrayList<Sheep> listS = new ArrayList<>();
                                                for(int i = 0; i < farm.getShed().get(0).getHerd().size();i++){
                                                    if(farm.getShed().get(0).getHerd().get(i) instanceof Sheep){
                                                        listS.add((Sheep) farm.getShed().get(0).getHerd().get(i));
                                                    }
                                                }
                                                System.out.println("Display of Sheeps Before Sorting");
                                                System.out.println(listS);
                                                ArrayList<Sheep> sortedListS = new ArrayList<>();
                                                for(int i = 0; i < farm.getShed().get(0).getHerd().size();i++){
                                                    if(farm.getShed().get(0).getHerd().get(i) instanceof Sheep){
                                                        sortedListS.add((Sheep) farm.getShed().get(0).getHerd().get(i));
                                                    }
                                                }
                                                Collections.sort(sortedListS);
                                                System.out.println("Display Of Sheeps After Sorting");
                                                System.out.println(sortedListS);
                                                break;

                                            case 4:
                                                ArrayList<DiaryCow> listD = new ArrayList<>();
                                                for(int i = 0; i < farm.getShed().get(0).getHerd().size();i++){
                                                    if(farm.getShed().get(0).getHerd().get(i) instanceof DiaryCow){
                                                        listD.add((DiaryCow) farm.getShed().get(0).getHerd().get(i));
                                                    }
                                                }
                                                System.out.println("Display of DiaryCows Before Sorting");
                                                System.out.println(listD);
                                                ArrayList<DiaryCow> sortedListD = new ArrayList<>();
                                                for(int i = 0; i < farm.getShed().get(0).getHerd().size();i++){
                                                    if(farm.getShed().get(0).getHerd().get(i) instanceof DiaryCow){
                                                        sortedListD.add((DiaryCow) farm.getShed().get(0).getHerd().get(i));
                                                    }
                                                }
                                                Collections.sort(sortedListD);
                                                System.out.println("Display Of DiaryCows After Sorting");
                                                System.out.println(sortedListD);
                                                break;

                                            case 5:
                                                ArrayList<BeefCow> listB1 = new ArrayList<>();
                                                for(int i = 0; i < farm.getShed().get(0).getHerd().size();i++){
                                                    if(farm.getShed().get(0).getHerd().get(i) instanceof BeefCow){
                                                        listB1.add((BeefCow) farm.getShed().get(0).getHerd().get(i));
                                                    }
                                                }
                                                System.out.println("Display of BeefCows Before Sorting");
                                                System.out.println(listB1);
                                                ArrayList<BeefCow> sortedListB1 = new ArrayList<>();
                                                for(int i = 0; i < farm.getShed().get(0).getHerd().size();i++){
                                                    if(farm.getShed().get(0).getHerd().get(i) instanceof BeefCow){
                                                        sortedListB1.add((BeefCow) farm.getShed().get(0).getHerd().get(i));
                                                    }
                                                }
                                                Collections.sort(sortedListB1, new CompBeefWeight());
                                                System.out.println("Display Of BeefCows After Sorting");
                                                System.out.println(sortedListB1);
                                                break;

                                            case 6:
                                                ArrayList<Sheep> listS1 = new ArrayList<>();
                                                for(int i = 0; i < farm.getShed().get(0).getHerd().size();i++){
                                                    if(farm.getShed().get(0).getHerd().get(i) instanceof Sheep){
                                                        listS1.add((Sheep) farm.getShed().get(0).getHerd().get(i));
                                                    }
                                                }
                                                System.out.println("Display of Sheeps Before Sorting");
                                                System.out.println(listS1);
                                                ArrayList<Sheep> sortedListS1 = new ArrayList<>();
                                                for(int i = 0; i < farm.getShed().get(0).getHerd().size();i++){
                                                    if(farm.getShed().get(0).getHerd().get(i) instanceof Sheep){
                                                        sortedListS1.add((Sheep) farm.getShed().get(0).getHerd().get(i));
                                                    }
                                                }
                                                Collections.sort(sortedListS1,new CompDescSheepAge());
                                                System.out.println("Display Of Sheeps After Sorting");
                                                System.out.println(sortedListS1);
                                                break;

                                            case 0:
                                                sk = false;
                                                break;

                                            default:
                                                System.out.println("Invalid input! Please try again.");
                                                break;

                                        }

                                    }
                                    break;

                                case 2:
                                    break;

                                case 0:
                                    uj = false;
                                    break;

                                default:
                                    System.out.println("Invalid input! Please try again.");
                                    break;

                            }
                        }
                        break;

                    case 8:
                        FileWriter printer = new FileWriter("src/Farm_Model/CreatedFarm.txt ");
                        printer.write(String.valueOf(farm));
                        printer.close();
                        break;

                    case 0:
                        isRun = false;
                        break;

                    default:
                        System.out.println("Invalid input! Please try again.");
                        break;
                }
            }
        }
        catch(InputMismatchException | IOException e){
            System.out.println("Invalid Input - Back To Menu");
            dailyOperations();
        }
    }

    public static void editShedMenu(){
        System.out.println();
        System.out.println("1)*****Add Milking Machine To Shed*****");
        System.out.println("2)*****Delete The Shed*****");
        System.out.println("3)*****Print Details Of The Shed*****");
        System.out.println("0)*****Close Menu*****");
        System.out.println();
    }

    public static void animalMenu() {
        System.out.println();
        System.out.println("1)*****Add An Animal*****");
        System.out.println("2)*****Edit An Animal*****");
        System.out.println("3)*****Delete An Animal*****");
        System.out.println("0)*****Exit*****");
        System.out.println();
    }

    public static void displayInitialSetUp() {
        System.out.println("");
        System.out.println("******* 1. Build Up Farm Set Up with already Made Utilities. *******");
        System.out.println("******* 2. Build Farm Set Up From Scratch.*******");
        System.out.println("******* 0. Quit the program *******");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome Chief, Congratulations on your recent acquisition of the Farm Asset");
        System.out.println("*******Please Input Your Name*******");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Name:  ");
        String owner = keyboard.next();
        name = owner + "'s Farm";
//        displayInitialSetUp();

        boolean isRunning = true;

        while (isRunning) {

            displayInitialSetUp();

            int ca = getMenuInput();

            switch (ca) {
                case 1:
                    autoSetUp();
                    dailyOperations();
                    isRunning = false;
                    break;

                case 2:
                    manualSetUp();
                    dailyOperations();
                    isRunning = false;
                    break;

                case 0:
                    System.out.println("Exit");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid input! Please try again.");
                    break;
            }
        }
    }
}
