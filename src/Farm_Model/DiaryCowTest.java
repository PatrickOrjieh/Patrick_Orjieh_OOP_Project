package Farm_Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class DiaryCowTest {

    @Test
    void compareTo() {
        System.out.println("To test for the collections sorting by milkyield");
        System.out.println("The result of this test should be the diarycows sorted in ascending order of milkyield");
        DiaryCow d1 = new DiaryCow();
        d1.produceMilk();
        DiaryCow d2 = new DiaryCow();
        d2.produceMilk();
        DiaryCow d3 = new DiaryCow();
        d3.produceMilk();
        DiaryCow d4 = new DiaryCow();
        d4.produceMilk();

        ArrayList<DiaryCow> list = new ArrayList<>();
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}