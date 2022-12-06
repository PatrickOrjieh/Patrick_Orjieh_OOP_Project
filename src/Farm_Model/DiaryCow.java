package Farm_Model;

import java.util.Random;
import java.util.UUID;

public class DiaryCow extends Animal implements Milkable {
    // udders were referring to udder capacity so i will take this out
//    private int udders;
private double milkYield;
//    private double udderCapacity;
//    Dairy cows produce milk. Dairy cows have ids, names and udders. Udder capacity is a
//    random value between 20 and 40. This describes how much milk the dairy cow produces per
//    day. Cows can choose to be milked as many times as they want a day. Most farmers milk
//    their cows twice a day but with robotic milking systems cows sometimes choose to be
//    milked four to five times a day.

    //    public DairyCow() creates a new cow with a random name
    public DiaryCow() {
        this.setName(new Utility().randomName());
    }

    public DiaryCow(String name) {
        super(name);
    }

    //    public int getUdders() {
//        return udders;
//    }
//
//    double getCapacity() returns the udder capacity
//    Udder capacity is a random value between 20 and 40.
// since method
    private double getUdderCapacity() {
        Random rand = new Random();
        double udderCapacity = rand.nextDouble(20.1, 40);
        return udderCapacity;
    }

//    public void setUdderCapacity(int udderCapacity) {
//        this.udderCapacity = udderCapacity;
//    }
//    public void setUdders(int udders) {
//        this.udders = udders;
//    }

    //comment
    @Override
    public double produceMilk() {
        double produced = this.getUdderCapacity();
        this.milkYield =+ produced;
        return produced;
    }

    @Override
    public String toString() {
        return "DiaryCow{" + "\n" +
                "id= " + this.getUniqueId() + "\n" +
                ", name= " + getName() + "\n" +
                " Total yield Since Initial Production= " + milkYield +"\n" +
                '}';
    }
    //create milk yield
}
