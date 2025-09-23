import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        // System.out.println(hasDuplicateUsingHashSet(new int[] {1,2,3,4}));
        // System.out.println(hasDuplicateUsingHashSet(new int[] {1,2,3,4}));
        // System.out.println(topKFrequent(new int[] {1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 4, 4, 4, 4}, 3).toString());
        // var str = encode(new ArrayList<>(List.of("Apple", "Ball", "Cat")));
        // System.out.println(str);
        // var result = decode(str);
        // System.out.println(result.toString());
        // System.out.println(Arrays.toString(prefixSum(new int[] {1,2,4,6})));
        // System.out.println(Arrays.toString(prefixMul(new int[] {1,2,4,6})));
        // System.out.println(productMulBetween(new int[] {1,2,3,4,5,6}, 2,4));
        System.out.println(scoreOfString("neetcode"));
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

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> arr = new ArrayList<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }

        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        
        return res;
    }

    public static String encode(List<String> strs) {
        
        StringBuilder encodedBuilder = new StringBuilder();

        for(int i = 0; i < strs.size(); i++){
            var count = strs.get(i).toCharArray().length;
            encodedBuilder.append(count + "#" + strs.get(i));
        }

        return encodedBuilder.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        var i = 0;

        while(i < str.length()){
            int j =i;
            while(j < str.length() && Character.isDigit(str.charAt(j))){
                j++;
            }

            int length = Integer.parseInt(str.substring(i,j));

            j++; //for #

            String s = str.substring(j, j+length);
            result.add(s);

            i = j+length;
        }
        
        return result;
    }

    public static int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];

        for(int i = 0; i < nums.length; i++)
        {
            var mul = 1;
            for(int j=0; j< nums.length; j++) {
                if(i != j){
                    mul *= nums[j];
                }
            }
            result[i] = mul;
        }

        return result;
    }

    public static int[] prefixSum(int[] nums) {
        var prefix = new int[nums.length];
        var postfix = new int[nums.length];

        prefix[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        postfix[nums.length - 1] = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] + nums[i];
        }

        System.out.println("prefixSum Array   : " + Arrays.toString(nums));
        System.out.println("prefixSum Prefix  : " + Arrays.toString(prefix));
        System.out.println("prefixSum Postfix : " + Arrays.toString(postfix));

        return prefix;
    }

    public static int[] prefixMul(int[] nums) {
        var prefix = new int[nums.length];
        var postfix = new int[nums.length];

        prefix[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i];
        }

        postfix[nums.length - 1] = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }

        System.out.println("prefixMul Array   : " + Arrays.toString(nums));
        System.out.println("prefixMul Prefix  : " + Arrays.toString(prefix));
        System.out.println("prefixMul Postfix : " + Arrays.toString(postfix));

        return prefix;
    }

    public static int productMulBetween(int[] nums, int start, int end) {
        var prefix = new int[nums.length];
        var postfix = new int[nums.length];

        prefix[0] = nums[0];
        
        var mul = 1;
        for(int i = start; i <= end; i++) {
            mul = mul * nums[i];
        }

        postfix[nums.length - 1] = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }

        // System.out.println("prefixMul Array   : " + Arrays.toString(nums));
        // System.out.println("prefixMul Prefix  : " + Arrays.toString(prefix));
        // System.out.println("prefixMul Postfix : " + Arrays.toString(postfix));

        return mul;
    }

    public static int scoreOfString(String s) {
        var sumOfDifference = 0;
        for(int i = 0; i < s.length() - 1; i++){
            sumOfDifference += Math.abs(s.charAt(i) - s.charAt(i+1));
        }
        return sumOfDifference;
    }

    // public static int[] concatenationOfArray(int[] nums) {
    //     var resArr = new int[nums.length * 2];

    //     for(int i = 0; i < nums.length; i++) {

    //     }

    //     return resArr
    // }
}
