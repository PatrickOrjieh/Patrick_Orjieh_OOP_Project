package Farm_Model;

import java.util.Random;
import java.util.UUID;

public class Goat extends Animal implements Milkable{
    private int udders;
    int desiredLength = 5;
    String random = UUID.randomUUID().toString().substring(0, desiredLength);

    public Goat() {
        this.setName(random);
    }

    public Goat(String name, int udders) {
        super(name);
        this.udders = udders;
    }

    public int getUdders() {
        return udders;
    }

    public void setUdders(int udders) {
        this.udders = udders;
    }

    @Override
    public double produceMilk(int times) {
        double produced = times * this.getCapacity();
        return produced;
    }

    //    double getCapacity() returns the udder capacity
//    Udder capacity is a random value between 2 and 3.
    public double getCapacity(){
        Random rand =  new Random();
        double udderCapacity = rand.nextDouble(2.1,3);
        return udderCapacity;
    }

    @Override
    public String toString() {
        return "Goat{" +
                "id= " + this.getUniqueId() +
                ", name= " + getName() +
                " udders=" + udders +
                '}';
    }
}
