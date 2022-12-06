package Farm_Model;

public class test {
    public static void main(String[] args) {
        DiaryCow kk = new DiaryCow();
        DiaryCow pa = new DiaryCow("pato");
        System.out.println(kk);
        System.out.println(pa);

        Goat kid = new Goat();
        System.out.println(kid);

        BeefCow b = new BeefCow("pato", "SUI", 78, 6);
        System.out.println(b);

    }
}
