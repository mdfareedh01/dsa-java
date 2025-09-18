import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twosum {
    // If nums = [1, 5, 3, 7] and target = 8
    
    public static void main(String[] args) {
        int[] nums = new int[] {1,5,3,7};
        int target = 8;

        // for(int i = 0; i < nums.length; i++) {
        //     for(int j = 0; j < nums.length; j++) {
        //         if(nums[i] + nums[j] == target) {
        //             System.out.println(Arrays.toString(new int[] { i, j }));
        //             break;
        //         }
        //     }
        // }

        // Map<Integer, Integer> seen = new HashMap<>();
        // for(int i = 0; i < nums.length; i++) {
        //     int complement = target - nums[i];
        //     if(seen.containsKey(complement)) {
        //         System.out.println(Arrays.toString(new int[] {seen.get(complement),i}));
        //         break;
        //     }

        //     seen.put(nums[i], i);
        // }  
        
        System.out.println(isAnagram("fareedh", "hdreraf"));
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
}
