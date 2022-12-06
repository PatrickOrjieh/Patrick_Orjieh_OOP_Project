package Farm_Model;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;
//githiub repo link - https://github.com/PatrickOrjieh/Patrick_Orjieh_OOP_Project.git

public  class BeefCow extends Animal implements Comparable<BeefCow> {
//    code for validation of enums was gotten from  = https://stackoverflow.com/questions/8389150/java-enum-elements-with-spaces
    public enum beefCowPedigree{

        ANGUS("Angus"),
        LIMOUSIN("Limosuin"),
        CHAROLAIS("Charolais"),
        HEREFORD("Hereford"),
        SIMMENTAL("Simmental"),
        SHORTHORN("Shorthorn"),
        SALERS("Salers"),
        AUBRAC("Aubrac"),
        BLONDE("Blonde"),
        PARTHENAISE("Parthenaise"),
        BELGIAN_BLUE("Belgian blue"),
        PIEDMONTESE("Piedmontese");

        private final String pedigreeType;

        beefCowPedigree(String pedigreeType) {
            this.pedigreeType = pedigreeType;
        }

        @Override
        public String toString() {
            return pedigreeType;
        }

        public static beefCowPedigree valueOfOrDefault(String myValue) {
            for(beefCowPedigree type : beefCowPedigree.class.getEnumConstants()) {
                if(type.toString().equalsIgnoreCase(myValue)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Beef Pedigree " + myValue +  " not Valid");
        }
    }
    private beefCowPedigree pedigree;
    private double weight;
    private int age;

    public BeefCow() {
        this.setName(new Utility().randomName());
    }

    // if a beef cpw is created and the pedigree given is not valid the system automatically gives it ANGUS to beat the error
    public BeefCow(String name, String pedigree, double weight, int age) {
        super(name);
        try {
            this.pedigree = beefCowPedigree.valueOfOrDefault(pedigree);
        }
        catch(IllegalArgumentException e){
            this.pedigree = beefCowPedigree.valueOf("ANGUS");
        }
        this.weight = weight;
        this.age = age;
    }

    public beefCowPedigree getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        try {
            this.pedigree = beefCowPedigree.valueOfOrDefault(pedigree);
        }
        catch(IllegalArgumentException e){
            this.pedigree = beefCowPedigree.valueOf("ANGUS");
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "$$$BeefCow{" +
                "    id= " + this.getUniqueId() +
                ", name= " + this.getName() +
                ", pedigree=" + pedigree +
                ", weight=" + weight +
                ", age=" + age + "\n" +
                '}';
    }


    //comparing the beefcows according to the specification given based on pedigree and if pedigree is the same
    //based on weight and if thats the same sort based on age
    @Override
    public int compareTo(BeefCow o) {
        int x = (this.getPedigree()).compareTo(o.getPedigree());
        int y = ((Double)this.getWeight()).compareTo(o.getWeight());
        if(x ==0){
            if (y == 0){
                return((Integer)this.getAge()).compareTo(o.getAge());
            }
            else{
                return y;
            }
        }
        else{
            return x;
        }
    }
}
