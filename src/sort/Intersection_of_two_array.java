package sort;

import java.util.HashSet;
import java.util.Set;

public class Intersection_of_two_array {
    public int[] intersection(int[] nums1, int[] nums2) {
        // init a set which contains all numbers in nums1
        Set<Integer> set = new HashSet<>();
        for(int num: nums1) {
            set.add(num);
        }

        // The set expression of the result
        Set<Integer> aux_set = new HashSet<>();
        for(int num : nums2) {
            if(set.contains(num)) {
                aux_set.add(num);
            }
        }

        // Convert the set to array
        int[] res = new int[aux_set.size()];
        int i = 0;
        for(int num : aux_set) {
            res[i++] = num;
        }
        return res;
    }
}
