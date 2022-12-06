package Farm_Model;

import java.util.UUID;

public class Utility {
    public String randomName(){
        int desiredLength = 5;
        String random = UUID.randomUUID().toString().substring(0, desiredLength);
        return random;
    }
}
