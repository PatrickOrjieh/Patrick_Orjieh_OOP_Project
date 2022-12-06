package Farm_Model;

import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        DiaryCow kk = new DiaryCow();
        DiaryCow pa = new DiaryCow("pato");
//        System.out.println(kk);
//        System.out.println(pa);

        Goat kid = new Goat();
//        System.out.println(kid);

        BeefCow b = new BeefCow("pato", "SUI", 78, 6);
//        System.out.println(b);
        Sheep t = new Sheep("fdv","df",45,3);
//        System.out.println(t);

        Shed s9 = new Shed();
        s9.addAnimal(t);
        s9.addAnimal(kk);
//        s9.addAnimal(kid);
        Shed e0 = new Shed();
        Farm hh = new Farm();
        hh.addShed(s9);
        hh.addShed(e0);
        MilkTank t5 = new MilkTank();
        MilkingMachine jj = new MilkingMachine();
        s9.installMilkingMachine(jj);
        s9.setTank(t5);

        Goat gtg = new Goat();
        Shed s6 = new Shed();
        s6.addAnimal(gtg);
        hh.addShed(s6);
        s9.milkShed();
        System.out.println(s9);
//        System.out.println(hh);
//
//        System.out.println(hh.getCountOfSheds());
//        for(int i =0; i < hh.getCountOfSheds(); i++){
//            System.out.println((i+1) +"-Shed: " + hh.getShed().get(i).getUniqueId());
//        }
//
//        System.out.println(hh.getShed().get(0));

//        s9.displayAnimals();
//        hh.getShed().get(0).displayAnimals();
//        System.out.print("Choose the animal you wish to edit: ");
//        int ped = keyboard.nextInt();
//        for(int i = 0; i < hh.getShed().get(0).getHerd().size()+1;i++){
//            if(ped == (i+1)){
//                System.out.print("Input the new Name of the Animal: ");
//                String newName = keyboard.next();
//                hh.getShed().get(0).getHerd().get(i).setName(newName);
//            }
//        }
//        s9.displayAnimals();

//        hh.displaySheds();

//        Random rand =  new Random();
//
//        int kill = rand.nextInt(0, hh.getCountOfSheds());
//        System.out.println(hh.getShed().get(2));
//        System.out.println(kill);
    }
}
