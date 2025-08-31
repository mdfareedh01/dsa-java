package hashmap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var ht = new HashTable();

        ht.put(6, "hello");
        ht.put(8, "world");
        ht.put(11, "friends");
        System.out.println("Done");
    }
}
