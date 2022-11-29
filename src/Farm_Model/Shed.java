package Farm_Model;

import java.util.Collection;
import java.util.UUID;

public class Shed {
//    Animals are milked in sheds. Sheds have an id and room for one milking machine. Note that
//    when milking machines are installed, they are connected to a shed’s milk tank. If a shed
//    does not have a milking machine it cannot be used to milk animals.
    private UUID uniqueId;
    private MilkingMachine milkingMachine;
    private Animal animal;
    private Collection<Animal> herd;

    //creating the shed's milk tank
    private MilkTank tank;

    public Shed(){
        this.uniqueId = UUID.randomUUID();
        this.milkingMachine = null;
        this.herd = null;
    }

    public Shed(MilkingMachine milkingMachine) {
        this.uniqueId = UUID.randomUUID();
        this.milkingMachine = milkingMachine;
        this.herd = null;
    }

    public Shed(Animal animal) {
        this.uniqueId = UUID.randomUUID();
        this.herd.add(animal);
        this.milkingMachine = null;
    }

    public Shed(Collection<Animal> herd) {
        this.uniqueId = UUID.randomUUID();
        this.herd = herd;
        this.milkingMachine = null;
    }

    public Shed(MilkingMachine milkingMachine, Collection<Animal> herd) {
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
        milkingMachine.setMilkTank(this.tank);
    }

    public MilkTank getTank() {
        return tank;
    }

    public void setTank(MilkTank tank) {
        this.tank = tank;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Collection<Animal> getHerd() {
        return herd;
    }

    public void setHerd(Collection<Animal> herd) {
        this.herd = herd;
    }

//    public void milkAnimal(Animal animal) milks the animal with the milking machine, the
//    method throws an IllegalStateException if the milking machine is not installed
    public void milkAnimal(Animal animal) {
        if (this.getMilkingMachine() != null) {
            this.milkingMachine.milk((Milkable) animal);
        }
        else {
            throw new IllegalStateException("No milking machine for this Shed");
        }
    }

//    public void milkAnimal(Collection<Animal> animals) milks the herd of animals with the
//    milking machine, the method throws an IllegalStateException if the milking machine is not
//            installed

    public void milkAnimal(Collection<Animal> herd){
        if(this.getMilkingMachine() != null){
            for(Animal kk : herd){
                this.milkingMachine.milk((Milkable) animal);
            }
        }
        else{
            throw new IllegalStateException("No milking machine for this Shed");
        }
    }

//    public String toString() returns the state of the milk tank contained in the shed
    @Override
    public String toString() {
        return "Shed{" +
                "uniqueId=" + uniqueId +
                ", milkingMachine=" + milkingMachine +
                ", animal=" + animal +
                ", herd=" + herd +
                ", tank=" + tank +
                '}';
    }


}
