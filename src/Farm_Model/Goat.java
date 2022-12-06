package Farm_Model;

import java.util.Random;
import java.util.UUID;

public class Goat extends Animal implements Milkable{

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
        this.milkYield =+ produced;
        return produced;
    }

    @Override
    public String toString() {
        return "Goat{" + "\n" +
                "id= " + this.getUniqueId() + "\n" +
                ", name= " + getName() + "\n" +
                " Total yield Since Initial Production= " + milkYield + "\n" +
                '}';
    }
}
