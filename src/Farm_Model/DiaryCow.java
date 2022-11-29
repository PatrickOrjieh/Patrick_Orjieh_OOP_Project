package Farm_Model;

import java.util.Random;
import java.util.UUID;

public class DiaryCow extends Animal implements Milkable{
    private int udders;
    int desiredLength = 5;
    String random = UUID.randomUUID().toString().substring(0, desiredLength);
//    Dairy cows produce milk. Dairy cows have ids, names and udders. Udder capacity is a
//    random value between 20 and 40. This describes how much milk the dairy cow produces per
//    day. Cows can choose to be milked as many times as they want a day. Most farmers milk
//    their cows twice a day but with robotic milking systems cows sometimes choose to be
//    milked four to five times a day.

//    public DairyCow() creates a new cow with a random name
    public DiaryCow() {
        this.setName(random);
    }

    public DiaryCow(String name, int udders) {
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
//    Udder capacity is a random value between 20 and 40.
    public double getCapacity(){
        Random rand =  new Random();
        double udderCapacity = rand.nextDouble(20.1,40);
        return udderCapacity;
    }

    @Override
    public String toString() {
        return "DiaryCow{" +
                "id= " + this.getUniqueId() +
                ", name= " + getName() +
                ", udders=" + udders +
                '}';
    }
}
