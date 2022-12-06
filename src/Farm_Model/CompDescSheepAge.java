package Farm_Model;

import java.util.Comparator;

public class CompDescSheepAge implements Comparator<Sheep> {

    //compare in ascending order of age
    @Override
    public int compare(Sheep o1, Sheep o2) {
        return ((Integer)o1.getAge()).compareTo(o2.getAge());
    }
}
