package Farm_Model;

import java.util.Comparator;

public class CompBeefWeight implements Comparator<BeefCow> {

    //compare beefcoes on descending weight and if the same then with Age
    @Override
    public int compare(BeefCow o1, BeefCow o2) {
        int x = ((Double)o2.getWeight()).compareTo(o1.getWeight());
        if(x == 0){
            return ((Integer)o1.getAge()).compareTo(o2.getAge());
        }
        else{
            return x;
        }
    }
}
