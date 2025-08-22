package hashmap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CharFinder finder = new CharFinder();
        var ch = finder.findFirstNonRepeatedCharacter("hello");
        System.out.println(ch);
    }
}
