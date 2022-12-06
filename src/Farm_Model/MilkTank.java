package Farm_Model;

public class MilkTank {
    //creating an attribute for tank to distinguish the tanks after being created
    private String name;
    private double customCapacity;
    private static final int STANDARD_CAPACITY = 2000;

    //creating an attribute to store the freespace of the tank after it has been emptied or milk added
//    private double freeSpace;

    //creating an attribute to store the amount of milk available/ milk stored
    private double milkStored;

    public MilkTank(){
        this.setName(new Utility().randomName());
        this.customCapacity = STANDARD_CAPACITY;
//        this.freeSpace = customCapacity;
//        this.milkStored = this.customCapacity - this.freeSpace;
        this.milkStored = 0;
    }

    public MilkTank(String name) {
        this.name = name;
        this.customCapacity = STANDARD_CAPACITY;
        this.milkStored = 0;
    }

    public MilkTank (double customCapacity){
        this.customCapacity = customCapacity;
//        this.freeSpace = customCapacity;
   //     this.milkStored = this.customCapacity - this.freeSpace;
        this.milkStored = 0;
    }

    public MilkTank(String name, double customCapacity){
        this.name = name;
        this.customCapacity = customCapacity;
        this.milkStored =0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCustomCapacity() {
        return customCapacity;
    }

    public void setCustomCapacity(double customCapacity) {
        this.customCapacity = customCapacity;
    }

//    public double getFreeSpace() {
//        return freeSpace;
//    }

    public double getMilkStored() {
        return milkStored;
    }

    //    public void addToTank(double amount) adds only as much as the tank fits
    //better boolean
    public boolean addToTank(double amount){
        boolean done = false;
//        first check to see if amount to be added is a negative value or if it is greater than the capacity available
        if((amount > 0) && (amount <= (this.customCapacity - this.milkStored))){
            this.milkStored = this.milkStored + amount;
             done = true;
        }
        else{
            done = false;
        }
        return done;
    }
//    public double getFromTank(double amount) tankers come to collect the milk from the tank
    //overload
    //get rid of sout
    public boolean getFromTank(double amount){
        boolean done = false;
        if((amount > 0)&&(amount <= this.milkStored)){
            this.milkStored = this.milkStored - amount;
            done = true;
        }
        else{
            done = false;
        }
        return done;
    }

    public void emptyTank(){
        this.milkStored = 0;
    }

    @Override
    public String toString() {
        return "****MilkTank{" +
                "name= " + name +
                ", customCapacity=" + customCapacity +
                ", freeSpace=" + (customCapacity  - milkStored) +
                ", milkStored=" + milkStored +
                '}';
    }
}
