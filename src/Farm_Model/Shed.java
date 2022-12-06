package Farm_Model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
//githiub repo link - https://github.com/PatrickOrjieh/Patrick_Orjieh_OOP_Project.git

public class Shed {
//    Animals are milked in sheds. Sheds have an id and room for one milking machine. Note that
//    when milking machines are installed, they are connected to a shed’s milk tank. If a shed
//    does not have a milking machine it cannot be used to milk animals.
    private UUID uniqueId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shed shed)) return false;
        return getUniqueId().equals(shed.getUniqueId()) && getMilkingMachine().equals(shed.getMilkingMachine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUniqueId(), getMilkingMachine());
    }

    private MilkingMachine milkingMachine;
    private ArrayList<Animal> herd;

    //creating the shed's milk tank
    private MilkTank tank;

    public Shed(){
        this.uniqueId = UUID.randomUUID();
        this.herd = new ArrayList<Animal>();
    }

    public Shed(MilkingMachine milkingMachine) {
        this.uniqueId = UUID.randomUUID();
        this.milkingMachine = milkingMachine;
        this.herd = new ArrayList<Animal>();
    }

    public Shed(ArrayList<Animal> herd) {
        this.uniqueId = UUID.randomUUID();
        this.herd = herd;
        this.milkingMachine = null;
    }

    public Shed(MilkingMachine milkingMachine, ArrayList<Animal> herd) {
        this.uniqueId = UUID.randomUUID();
        this.milkingMachine = milkingMachine;
        this.herd = herd;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public MilkingMachine getMilkingMachine() {
        return milkingMachine;
    }

//    public void installMilkingMachine(MilkingMachine milkingMachine) installs a milking
//    machine and connects it to the shed’s milk tank
    public void installMilkingMachine(MilkingMachine milkingMachine) {
        this.milkingMachine = milkingMachine;
    }

    public MilkTank getTank() {
        return tank;
    }

    public void setTank(MilkTank tank) {
        this.tank = tank;
    }

    public ArrayList<Animal> getHerd() {
        return herd;
    }

    public void setHerd(ArrayList<Animal> herd) {
        this.herd = herd;
    }

//    public void milkAnimal(Animal animal) milks the animal with the milking machine, the
//    method throws an IllegalStateException if the milking machine is not installed
    public void milkAnimal(Animal animal) throws  IllegalStateException{
        if(animal instanceof Milkable) {
            try{
                this.milkingMachine.milk((Milkable) animal);
            } catch(NullPointerException e) {
                throw new IllegalStateException("No milking machine for this Shed");
            }
        }
    }

//    public void milkAnimal(Collection<Animal> animals) milks the herd of animals with the
//    milking machine, the method throws an IllegalStateException if the milking machine is not
//            installed

    //this method was created incase herd from another shed wants to be milked in a shed that has a milking machine
    public void milkAnimal(ArrayList<Animal> herd){
        if(herd instanceof Milkable) {
            if (this.getMilkingMachine() != null) {
                for (Animal kk : herd) {
                    this.milkingMachine.milk((Milkable) kk);
                }
            } else {
                throw new IllegalStateException("No milking machine for this Shed");
            }
        }
    }

    public void milkAnimal1(){
        if(herd instanceof Milkable) {
            if (this.getMilkingMachine() != null) {
                for (Animal kk : this.herd) {
                    this.milkingMachine.milk((Milkable) kk);
                }
            } else {
                throw new IllegalStateException("No milking machine for this Shed");
            }
        }
    }
    public void milkAnimal() throws IllegalStateException{
        if(herd instanceof Milkable) {
            try{
                for (Animal kk : this.herd) {
                    this.milkingMachine.milk((Milkable) kk);
                }
            } catch(NullPointerException e) {
                throw new IllegalStateException("No milking machine for this Shed");
            }
        }
    }

//    public String toString() returns the state of the milk tank contained in the shed
    @Override
    public String toString() {
        return "*****Shed{ " +
                "uniqueId=" + uniqueId + "\n"+
//                ", milkingMachine=" + milkingMachine +
                ", herd= "+ "\n" + herd +
                ", tank=" + tank +
                '}' +"\n" + "\n";
    }

    //method to add animals to a shed herd and i did a preventive method
    //such that if  a type of milkable animal is already in the shed you cannot add
    //another milkable
    public void addAnimal(Animal a){
        int animalShedCheck = 0;
        int animalToAddCheck = 0;

        //this for loop is to know the type of milkable in the shed if there is any
        for(Animal kk : this.herd){
            if(kk instanceof Goat){
                animalShedCheck = 1;
                break;
            }
            else if(kk instanceof DiaryCow){
                animalShedCheck = 2;
                break;
            }
            else{
                animalShedCheck = 0;
            }
        }

        //this is to know the type of animal to be added
        if(a instanceof Goat){
            animalToAddCheck = 1;
        } else if (a instanceof DiaryCow) {
            animalToAddCheck = 2;
        }
        else{
            animalToAddCheck = 0;
        }

        if(animalShedCheck == 1 && animalToAddCheck ==2){
            System.out.println("Can't be added --- Already A Goat In The Shed!!!");
        } else if (animalShedCheck ==2 && animalToAddCheck ==1) {
            System.out.println("Can't be added --- Already A DairyCow In The Shed!!!");
        }else{
            herd.add(a);
            System.out.println("Added");
        }
    }

    public void displayAnimals(){
        for(int i = 0; i < this.herd.size(); i++){
            System.out.println((i+1)+")"+herd.get(i));
        }
    }

    public double milkShed() {
        try {
            double total = 0;
            for (int i = 0; i < herd.size(); i++) {
                if (this.herd.get(i) instanceof Milkable) {
                    total = total + ((Milkable) this.herd.get(i)).produceMilk();
                }
            }
            this.getTank().addToTank(total);
            return total;
        }
        catch(NullPointerException e){
            return 0;
        }
    }

}
