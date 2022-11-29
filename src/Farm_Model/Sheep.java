package Farm_Model;

import java.util.UUID;

public  class Sheep extends Animal {
    //    code for validation of enums was gotten from  = https://stackoverflow.com/questions/8389150/java-enum-elements-with-spaces
    public enum sheepPedigree{

        BELCLARE("Belclare"),
        BELTEX("Beltex"),
        BLACKFACE_MOUNTAIN("Blackface Mountain"),
        BLEU_DU_MAINE("Bleu du Maine"),
        BLUE_TEXEL("Blue Texel"),
        BLUEFACED_LEICESTER("Bluefaced Leicester"),
        BORDER_LEICESTER("Border Leicester"),
        CHAROLLAIS("Charollais"),
        CHEVIOT("Cheviot"),
        EASY_CARE("Easy Care"),
        GALWAY("Galway"),
        HAMPSHIRE_DOWN("Hampshire Down"),
        ILE_DE_FRANCE("Ile De France"),
        LLEYN("Lleyn"),
        MAYO_CONNEMARA("Mayo Cannemara"),
        ROUGE_DE_LOUEST("Rouge de L'Ouest"),
        SHROPSHIRE("Shropshire"),
        SUFFOLK("Suffolk"),
        TEXEL("Texel"),
        VENDEEN("Vendeen"),
        ZWARTBLE("Zwartble");

        private final String pedigreeType;

        sheepPedigree(String pedigreeType) {
            this.pedigreeType = pedigreeType;
        }

        @Override
        public String toString() {
            return pedigreeType;
        }

        public static sheepPedigree valueOfOrDefault(String myValue) {
            for(sheepPedigree type : sheepPedigree.class.getEnumConstants()) {
                if(type.toString().equalsIgnoreCase(myValue)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Sheep Pedigree " + myValue +  " not Valid");
        }
    }
    private sheepPedigree pedigree;
    private double weight;
    private int age;
    int desiredLength = 5;
    String random = UUID.randomUUID().toString().substring(0, desiredLength);

    public Sheep() {
        this.setName(random);
    }

    public Sheep(String name, String pedigree, double weight, int age) {
        super(name);
        this.pedigree = sheepPedigree.valueOfOrDefault(pedigree);
        this.weight = weight;
        this.age = age;
    }

    public sheepPedigree getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = sheepPedigree.valueOfOrDefault(pedigree);
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
        return "Sheep{" +
                "id= " + this.getUniqueId() +
                ", name= " + this.getName() +
                ", pedigree=" + pedigree +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}
