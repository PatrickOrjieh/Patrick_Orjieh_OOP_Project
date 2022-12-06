package Farm_Model;

public class MilkingMachine {
    private MilkTank tank;
    private String name;
    //created an attribute to store the amount of times we want to milk the animal
//    private int times;

//    returns the connected milk tank or null if the tank isn’t installed
    public MilkingMachine(){

    }
    public MilkingMachine(String name){
        this.name = name;
    }

    public MilkingMachine(MilkTank tank){
        this.tank = tank;
    }

    public MilkingMachine(String name,MilkTank tank){
        this.name = name;
        this.tank = tank;
    }

    public MilkTank getMilkTank() {
        return tank;
    }

    public void setMilkTank(MilkTank tank) {
        this.tank = tank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//    public int getTimes() {
//        return times;
//    }
//
//    public void setTimes(int times) {
//        this.times = times;
//    }

    //    void milk(IMilkable milkable) milks the cow and fills the connected milk tank; the method
//    returns an IllegalStateException if no tank has been installed
    public void milk(Milkable animal){
            if(this.getMilkTank() != null){
                double amount = animal.produceMilk();
                this.tank.addToTank(amount);
            }
            else{
                throw new IllegalStateException("No tank has been installed");
            }

    }
    //to show the milking machine and its associated tank

//    @Override
//    public String toString() {
//        return "MilkingMachine{" + "\n" +
//                "Connected to " +
//                "tank=" + tank +
//                '}';
//    }
}
