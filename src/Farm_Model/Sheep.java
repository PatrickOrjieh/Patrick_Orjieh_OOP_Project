package Farm_Model;

import java.util.UUID;

public  class Sheep extends Animal implements Comparable<Sheep>{
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

    public Sheep() {
        this.setName(new Utility().randomName());
    }

    public Sheep(String name, String pedigree, double weight, int age) {
        super(name);
        try {
            this.pedigree = Sheep.sheepPedigree.valueOfOrDefault(pedigree);
        }
        catch(IllegalArgumentException e){
            this.pedigree = Sheep.sheepPedigree.valueOf("BELCLARE");
        }
        this.weight = weight;
        this.age = age;
    }

    public sheepPedigree getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {try {
        this.pedigree = Sheep.sheepPedigree.valueOfOrDefault(pedigree);
    }
    catch(IllegalArgumentException e){
        this.pedigree = Sheep.sheepPedigree.valueOf("BELCLARE");
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
        return "$$$$Sheep{" +
                "   id= " + this.getUniqueId() +
                ", name= " + this.getName() +
                ", pedigree=" + pedigree +
                ", weight=" + weight +
                ", age=" + age + "\n" +
                '}';
    }
    @Override
    public int compareTo(Sheep o) {
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
