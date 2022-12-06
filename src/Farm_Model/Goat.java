package Farm_Model;

import java.util.Random;
import java.util.UUID;

public class Goat extends Animal implements Milkable,Comparable<Goat>{

    private double milkYield;

    public Goat() {
        this.setName(new Utility().randomName());
    }

    public Goat(String name) {
        super(name);
    }

//    public int getUdders() {
//        return udders;
//    }
//
//    public void setUdders(int udders) {
//        this.udders = udders;
//    }

    //    double getCapacity() returns the udder capacity
//    Udder capacity is a random value between 2 and 3.
    public double getCapacity(){
        Random rand =  new Random();
        double udderCapacity = rand.nextDouble(2.1,3);
        return udderCapacity;
    }

    @Override
    public double produceMilk() {
        double produced = this.getCapacity();
        this.milkYield = this.milkYield +  produced;
        return produced;
    }

    public double getMilkYield() {
        return milkYield;
    }

    public void setMilkYield(double milkYield) {
        this.milkYield = milkYield;
    }

    @Override
    public String toString() {
        return "$$$$Goat{" +
                "    id= " + this.getUniqueId() +
                ", name= " + getName() +
                " Total yield Since Initial Production= " + milkYield + "\n" +
                '}';
    }


    @Override
    public int compareTo(Goat o) {
        return ((Double)this.getMilkYield()).compareTo(o.getMilkYield());
    }
}
