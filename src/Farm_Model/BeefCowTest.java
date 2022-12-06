package Farm_Model;

import static org.junit.jupiter.api.Assertions.*;

class BeefCowTest {

    @org.junit.jupiter.api.Test
    void setPedigree() {
        System.out.println("Test to see if the exception i did to catch when a user puts in a pedigree thats not part on the enums");
        BeefCow b1 = new BeefCow("Beef1", "Pedigree", 93,4);
        BeefCow b2 = new BeefCow("Beef1", "ANGUS", 93,4);
        int expResult = b1.compareTo(b2);

        // output is 0 because it shows that all specified fields on both beefcows are the same becase as default
        //if the pedigree of a cow is not valid it sets to ANGUS
        int actualResult = 0;
        assertEquals(expResult,actualResult);
    }
}