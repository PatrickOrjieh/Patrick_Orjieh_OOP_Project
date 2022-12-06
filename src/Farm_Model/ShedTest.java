package Farm_Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShedTest {

    @Test
    void addToShed() {
        System.out.println("Creating a shed that has a goat already and try adding a Diarycow should no be allowed");
        Shed s = new Shed();
        Goat g1 = new Goat();
        s.addAnimal(g1);

        //now the shed has a goat i will try to add a diarycow and it should display that the diarycow can't be added
        DiaryCow d = new DiaryCow();
        s.addAnimal(d);
        String expResult = "Can't be added --- Already A Goat In The Shed!!!";
    }
}