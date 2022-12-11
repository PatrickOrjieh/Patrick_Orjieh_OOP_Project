package Farm_Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    public static  String name = "";
<<<<<<<<< Temporary merge branch 1
=========
    public static int income = 75000;
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
>>>>>>>>> Temporary merge branch 2
    public static int getMenuInput() {
        try {
            int inputValue;
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Input Value: ");
            inputValue = keyboard.nextInt();
            return inputValue;
        } catch (InputMismatchException e) {
            System.out.println("Pleaser enter a number..");
        }
<<<<<<<<< Temporary merge branch 1
        return 1;
=========
        return 7;
>>>>>>>>> Temporary merge branch 2
    }

    static void autoSetUp(){
        try (Scanner sc = new Scanner(new File("CFarm.txt"))) { //try with resources, no need for finally block
            Farm farm = new Farm(name);
            Shed s1 = new Shed();
            Shed s2 = new Shed();
            MilkTank tank1 = new MilkTank();
            MilkTank tank2 = new MilkTank();
            while (sc.hasNext()) {
                Goat goat1 = new Goat(sc.next());
                Goat goat2 = new Goat(sc.next());
                Sheep sheep1 = new Sheep(sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
                Sheep sheep2 = new Sheep(sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
                DiaryCow dc1 = new DiaryCow(sc.next());
                DiaryCow dc2 = new DiaryCow(sc.next());
                BeefCow bc1 = new BeefCow(sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
                BeefCow bc2 = new BeefCow(sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
                MilkingMachine m1 = new MilkingMachine(sc.next());
                MilkingMachine m2 = new MilkingMachine(sc.next());
                s1.installMilkingMachine(m1);
                s2.installMilkingMachine(m2);
                s1.setTank(tank1);
                s2.setTank(tank2);
                s1.addAnimal(goat1);
                s1.addAnimal(goat2);
                s1.addAnimal(sheep1);
                s1.addAnimal(sheep2);
                s2.addAnimal(dc1);
                s2.addAnimal(dc2);
                s2.addAnimal(bc1);
                s2.addAnimal(bc2);
                farm.addShed(s1);
                farm.addShed(s2);
                System.out.println(farm);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }

    static void manualSetUp(){
<<<<<<<<< Temporary merge branch 1

=========
        boolean isRunning = true;

            Scanner keyboard = new Scanner(System.in);
            Farm farm = new Farm(name);
            displayIncome();
        while(isRunning) {

            System.out.println("We need Sheds in the farm and Each shed cost 2000€");
            System.out.println("How many Sheds would you like to create 1-3");
            int count = getMenuInput();
            switch (count) {
                case 1:
                    Shed s1 = new Shed();
                    farm.addShed(s1);
                    income = income - 2000;
                    displayIncome();
                    isRunning = false;
                    break;

                case 2:
                    Shed s2 = new Shed();
                    Shed s3 = new Shed();
                    farm.addShed(s2);
                    farm.addShed(s3);
                    income = income - 4000;
                    displayIncome();
                    isRunning = false;
                    break;

                case 3:
                    Shed s4 = new Shed();
                    Shed s5 = new Shed();
                    Shed s6 = new Shed();
                    farm.addShed(s4);
                    farm.addShed(s5);
                    farm.addShed(s6);
                    income = income - 6000;
                    displayIncome();
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid input! Please try again.");
                    break;
            }
        }
        System.out.println("What would you like to add to your Shed/Sheds");
    }
    public static void initialAdd(){
        boolean isRunning = true;
        while(isRunning) {
            System.out.println("");
            System.out.println("What (more) would you like to add into your shed");
            System.out.println("******* 1. Goat *******");
            System.out.println("******* 2. Sheep *******");
            System.out.println("******* 3. BeefCow *******");
            System.out.println("******* 4. DairyCow *******");
            System.out.println("******* 5. Milking Machine *******");
            System.out.println("******* 0. Nothing Else *******");
            int count = getMenuInput();
            switch (count) {
                case 1:

                    break;

                case 2:
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Invalid input! Please try again.");
                    break;
            }
        }
>>>>>>>>> Temporary merge branch 2
    }
    public static void displayInitialSetUp() {
        System.out.println("");
        System.out.println("******* 1. Build Up Farm Set Up with already Made Utilities. *******");
        System.out.println("******* 2. Build Farm Set Up From Scratch.*******");
        System.out.println("******* 0. Quit the program *******");
    }

    public static void main(String[] args) {
        System.out.println("Welcome Chief, Congratulations on your recent acquisition of the Farm Asset");
        System.out.println("*******Please Input Your Name*******");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Name:  ");
        String owner = keyboard.next();
         name = owner  + "'s Farm";
//        displayInitialSetUp();

        boolean isRunning = true;

        while (isRunning) {

            displayInitialSetUp();

            int ca = getMenuInput();

            switch (ca) {
                case 1:
                    autoSetUp();
                    break;

                case 2:
                    manualSetUp();
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
