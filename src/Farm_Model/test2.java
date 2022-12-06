//package Farm_Model;
//
//import java.sql.SQLOutput;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class test2 {
//    public static void main(String[] args) {
//        Scanner keyboard  = new Scanner(System.in);
//
////        sort for goat and milk
////        Shed s2 = new Shed();
////        System.out.print("How many Goat would you like to add: ");
////         int  m = keyboard.nextInt();
////        ArrayList<Goat> list = new ArrayList<>();
////        for(int i = 0; i < m; i++){
////            Goat d1 = new Goat();
////            System.out.print("Input name of Goat("+ i + ") : ");
////            String gName = keyboard.next();
////            d1.setName(gName);
////            s2.addAnimal(d1);
////        }
////        for(int i = 0; i < s2.getHerd().size();i++){
////            if(s2.getHerd().get(i) instanceof Goat){
////            list.add((Goat) s2.getHerd().get(i));
////            }
////        }
////        System.out.println(list);
////        MilkTank t5 = new MilkTank();
////        MilkingMachine jj = new MilkingMachine();
////        s2.installMilkingMachine(jj);
////        s2.setTank(t5);
////        s2.milkShed();
////        ArrayList<Goat> slist = new ArrayList<>();
////        for(int i = 0; i < s2.getHerd().size();i++){
////            if(s2.getHerd().get(i) instanceof Goat){
////                slist.add((Goat) s2.getHerd().get(i));
////            }
////        }
////        Collections.sort(slist);
////        System.out.println(slist);
//
//        Shed s2 = new Shed();
//        System.out.print("How many BeefCows would you like to add: ");
//        int  m = keyboard.nextInt();
//        ArrayList<BeefCow> list = new ArrayList<>();
//        for(int i = 0; i < m; i++){
//            BeefCow d1 = new BeefCow();
//            System.out.print("Input name of BeefCow("+ i + ") : ");
//            String gName = keyboard.next();
//            d1.setName(gName);
//            System.out.println("Input the Pedigree of BeefCow("+ i + ") : ");
//            String pedName = keyboard.next();
//            d1.setPedigree(pedName);
//            System.out.println("Input weight of BeefCow("+ i + ") : ");
//            double weight = keyboard.nextDouble();
//            d1.setWeight(weight);
//            System.out.println("Input Age of BeefCow("+ i + ") : ");
//            int age = keyboard.nextInt();
//            d1.setAge(age);
//            s2.addAnimal(d1);
//        }
//        for(int i = 0; i < s2.getHerd().size();i++){
//            if(s2.getHerd().get(i) instanceof BeefCow){
//                list.add((BeefCow) s2.getHerd().get(i));
//            }
//        }
//        System.out.println(list);
//        MilkTank t5 = new MilkTank();
//        MilkingMachine jj = new MilkingMachine();
//        s2.installMilkingMachine(jj);
//        s2.setTank(t5);
//        s2.milkShed();
//        ArrayList<BeefCow> slist = new ArrayList<>();
//        for(int i = 0; i < s2.getHerd().size();i++){
//            if(s2.getHerd().get(i) instanceof BeefCow){
//                slist.add((BeefCow) s2.getHerd().get(i));
//            }
//        }
//        Collections.sort(slist,new CompBeefWeight());
//        System.out.println(slist);
//    }
//}
