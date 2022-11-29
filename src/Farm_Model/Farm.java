package Farm_Model;

import java.util.UUID;

public class Farm {

    private UUID uniqueId;
    private String owner;
    private Shed shed;

    public Farm (){
        this.uniqueId = UUID.randomUUID();
    }

    public Farm(String owner) {
        this.uniqueId = UUID.randomUUID();
        this.owner = owner;
    }

    public Farm(String owner, Shed shed) {
        this.uniqueId = UUID.randomUUID();
        this.owner = owner;
        this.shed = shed;
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

    public Shed getShed() {
        return shed;
    }

    public void setShed(Shed shed) {
        this.shed = shed;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "uniqueId=" + uniqueId +
                ", owner='" + owner +
                ", shed=" + shed +
                '}';
    }
}
