import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class blind75 {
    // If nums = [1, 5, 3, 7] and target = 8
    
    public static void main(String[] args) {

        // twoSumUsingBruteForce();
        // twoSumUsingHasMap();
        // System.out.println(isAnagram("fareedh", "hdreraf"));
        // groupAnagram(new String[] {"eat","tea","tan","ate","nat","bat"});
        // System.out.println(hasDuplicate(new int[] {1,2,3,4}));
        System.out.println(hasDuplicateUsingHashSet(new int[] {1,2,3,4}));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] count = new int[26];

        for(int i = 0; i< s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int c : count) {
            if(c != 0) return false;
        }

        return true;
    }

    public static void twoSumUsingBruteForce() {
        int[] nums = new int[] {1,5,3,7};
        int target = 8;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    System.out.println(Arrays.toString(new int[] { i, j }));
                    break;
                }
            }
        }        
    }

    public static void twoSumUsingHasMap() {
        int[] nums = new int[] {1,5,3,7};
        int target = 8;

        Map<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(seen.containsKey(complement)) {
                System.out.println(Arrays.toString(new int[] {seen.get(complement),i}));
                break;
            }

            seen.put(nums[i], i);
        } 
    }  
    
    public static void groupAnagram(String[] strs){
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            var count = new int[26];
            
            for(char c: s.toCharArray())
                count[c - 'a']++;
            
            var keyBuilder = new StringBuilder();

            for(int num: count)
                keyBuilder.append(num).append("#");

            var key = keyBuilder.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        System.out.println(new ArrayList<>(map.values()));
    }

    public static boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else {
                map.put(nums[i], map.get(nums[i])+1);
                return true;
            }
        }

        return false;
    } 

    public static boolean hasDuplicateUsingHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i: nums){
            if(set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }

    
}
