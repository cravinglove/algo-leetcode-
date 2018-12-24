package sort;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        String[] s_num = new String[nums.length];
        // Convert num array to string array
        for(int i = 0; i < nums.length; i++)
            s_num[i] = String.valueOf(nums[i]);
        Comparator<String> cm = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(s_num);
        // Extreme case when the nums is all zero
        if(s_num[0].charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : s_num)
            sb.append(s);
        return sb.toString();
    }
}
