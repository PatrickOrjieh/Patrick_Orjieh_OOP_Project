package Farm_Model;

import java.util.UUID;

public abstract class Animal {
//    Add an animal to the farm. Duplicates are not allowed. ID values are unique and
//    auto-generated.
    private UUID uniqueId;
    private String name;

    public Animal(){
        this.uniqueId = UUID.randomUUID();

    }
    public Animal (String name){
        this.uniqueId = UUID.randomUUID();
        this.name = name;
    }

    public String getUniqueId() {
        return uniqueId.toString();
    }

    public void setUniqueId(String genId) {
        this.uniqueId = UUID.fromString(genId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" + "\n" +
                "uniqueId=" + uniqueId.toString() +
                ", name='" + name +
                '}';
    }
}
