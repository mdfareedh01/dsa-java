package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public Character findFirstNonRepeatedCharacter(String input) {
        Map<Character, Integer> map =  new HashMap<Character, Integer>();
        
        char[] charArray = input.toCharArray();

        for(Character ch: charArray){
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count+1);
        }

        for(Character ch: charArray) {
            if(map.get(ch) == 1) {
                return ch;
            }
        }
        
        return Character.MIN_VALUE;
    }

    public Character findFirstRepeatedCharacter(String input) {
        
        Set<Character> set = new HashSet();
        
        for(Character ch: input.toCharArray()) {
            if(set.contains(ch))
                return ch;

            set.add(ch);
        }
        
        return Character.MIN_VALUE;
    }
}
