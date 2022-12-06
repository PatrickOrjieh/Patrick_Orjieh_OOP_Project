package Farm_Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
//githiub repo link - https://github.com/PatrickOrjieh/Patrick_Orjieh_OOP_Project.git
public class Farm {

    private UUID uniqueId;
    private String owner;
    private ArrayList<Shed> sheds;

    private int count;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Farm farm)) return false;
        return getUniqueId().equals(farm.getUniqueId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUniqueId());
    }

    @Override
    public String toString() {
        return "Farm-----{" +
                "uniqueId=" + uniqueId +
                ", owner='" + owner + "\n" +
                ", shed=" +"\n"+ sheds +
                '}';
    }

    //creating a method that adds sheds to the farm
    public boolean addShed(Shed s){
        count++;
        return sheds.add(s);
    }

    //made this method to keep count of sheds made in thE MainApp2
    public int getCountOfSheds(){
        return this.count;
    }

    public void displaySheds(){
        for(int i = 0; i < this.sheds.size(); i++){
            System.out.println((i+1)+")"+sheds.get(i));
        }
    }
}
