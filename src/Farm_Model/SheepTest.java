package Farm_Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SheepTest {


    @org.junit.jupiter.api.Test
    void setPedigree() {
        System.out.println("Test to see if the exception i did to catch when a user puts in a pedigree thats not part on the enums");
        Sheep s1 = new Sheep("Sheep1", "Nothing", 45,3);
        Sheep s2 = new Sheep("Sheep1", "BELCLARE", 45,3);
        int expResult = s1.compareTo(s2);

        // output is 0 because it shows that all specified fields on both beefcows are the same becase as default
        //if the pedigree of a cow is not valid it sets to ANGUS
        int actualResult = 0;
        assertEquals(expResult,actualResult);
    }
}