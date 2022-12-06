package Farm_Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    public static  String name = "";
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
        return 1;
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
