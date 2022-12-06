package Farm_Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class Farm {

    private UUID uniqueId;
    private String owner;
    private ArrayList<Shed> sheds;

    public Farm (){
        this.uniqueId = UUID.randomUUID();
        this.sheds = new ArrayList<>();
    }

    public Farm(String owner) {
        this.uniqueId = UUID.randomUUID();
        this.owner = owner;
        this.sheds = new ArrayList<>();
    }

    public Farm(String owner, ArrayList<Shed> sheds) {
        this.uniqueId = UUID.randomUUID();
        this.owner = owner;
        this.sheds = sheds;
    }

    public String getUniqueId() {
        return uniqueId.toString();
    }

    public void setUniqueId(String genId) {
        this.uniqueId = UUID.fromString(genId);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<Shed> getShed() {
        return sheds;
    }

    public void setShed(ArrayList<Shed> sheds) {
        this.sheds = sheds;
    }

    @Override
    public String toString() {
        return "Farm{" + "\n" +
                "uniqueId=" + uniqueId +
                ", owner='" + owner +
                ", shed=" + sheds +
                '}';
    }

    //creating a method that adds sheds to the farm
    public boolean addShed(Shed s){
        return sheds.add(s);
    }
}
