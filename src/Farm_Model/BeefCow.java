package Farm_Model;

import java.util.UUID;

public  class BeefCow extends Animal {
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
    int desiredLength = 5;
    String random = UUID.randomUUID().toString().substring(0, desiredLength);

    public BeefCow() {
        this.setName(random);
    }

    public BeefCow(String name, String pedigree, double weight, int age) {
        super(name);
        this.pedigree = beefCowPedigree.valueOfOrDefault(pedigree);
        this.weight = weight;
        this.age = age;
    }

    public beefCowPedigree getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = beefCowPedigree.valueOfOrDefault(pedigree);
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
        return "BeefCow{" +
                "id= " + this.getUniqueId() +
                ", name= " + this.getName() +
                ", pedigree=" + pedigree +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}
