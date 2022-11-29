package Farm_Model;

public class MilkTank {
    private double customCapacity;
    private static final int STANDARD_CAPACITY = 2000;

    //creating an attribute to store the freespace of the tank after it has been emptied or milk added
    private double freeSpace;

    //creating an attribute to store the amount of milk available/ milk stored
    private double milkStored;

    public MilkTank(){
        this.customCapacity = STANDARD_CAPACITY;
        this.freeSpace = customCapacity;
        this.milkStored = this.customCapacity - this.freeSpace;
    }

    public MilkTank (double customCapacity){
        this.customCapacity = customCapacity;
        this.freeSpace = customCapacity;
        this.milkStored = this.customCapacity - this.freeSpace;
    }

    public double getCustomCapacity() {
        return customCapacity;
    }

    public void setCustomCapacity(double customCapacity) {
        this.customCapacity = customCapacity;
    }

    public double getFreeSpace() {
        return freeSpace;
    }

    public double getMilkStored() {
        return milkStored;
    }

    //    public void addToTank(double amount) adds only as much as the tank fits
    public void addToTank(double amount){
//        first check to see if amount to be added is a negative value or if it is greater than the capacity available
        if((amount > 0) && (amount <= this.freeSpace)){
            this.freeSpace = this.freeSpace - amount;
            this.milkStored = this.milkStored + amount;
            System.out.println("Successfully Added");
        }
        else{
            System.out.println("Error regarding amount you want to add");
        }
    }
//    public double getFromTank(double amount) tankers come to collect the milk from the tank
    public void getFromTank(double amount){
        if((amount > 0)&&(amount <= this.milkStored)){
            this.milkStored = this.milkStored - amount;
            this.freeSpace = this.freeSpace + amount;
            System.out.println("Farmer Taken Milk");
        }
        else{
            System.out.println("Milk stored not up to amount to be taken");
        }
    }

    @Override
    public String toString() {
        return "MilkTank{" +
                "customCapacity=" + customCapacity +
                ", freeSpace=" + freeSpace +
                ", milkStored=" + milkStored +
                '}';
    }
}
