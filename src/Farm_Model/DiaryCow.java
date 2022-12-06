package Farm_Model;

import org.jetbrains.annotations.NotNull;
//githiub repo link - https://github.com/PatrickOrjieh/Patrick_Orjieh_OOP_Project.git

import java.util.Comparator;
import java.util.Random;
import java.util.UUID;

public class DiaryCow extends Animal implements Milkable, Comparable<DiaryCow> {
    // udders were referring to udder capacity so i will take this out
//    private int udders;
private double milkYield = 0;
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
        this.milkYield = this.milkYield + produced;
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
        return "$$$$DiaryCow{" +
                "   id= " + this.getUniqueId() +
                ", name= " + getName() +
                " Total yield Since Initial Production= " + milkYield +"\n" +
                '}';
    }

    //decided to compare the diary cows with the total number of milk yielded since initial production
    @Override
    public int compareTo(DiaryCow o) {
        return ((Double)this.getMilkYield()).compareTo(o.getMilkYield());
    }

    //create milk yield
}
