package Farm_Model;

import org.jetbrains.annotations.NotNull;
//githiub repo link - https://github.com/PatrickOrjieh/Patrick_Orjieh_OOP_Project.git

import java.util.Objects;
import java.util.UUID;

public abstract class Animal{
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null) return false;
        if (!(o instanceof Animal animal)) return false;
        return getUniqueId().equals(animal.getUniqueId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUniqueId());
    }

}
