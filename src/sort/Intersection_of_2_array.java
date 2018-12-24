package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection_of_2_array {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        // Construct map, key is integer, value is count
        for(int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer> aux_list = new ArrayList<>();
        for(int num : nums2) {
            if(map.containsKey(num)) {
                aux_list.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        // Convert aux_list to array
        int[] result = new int[aux_list.size()];
        for(int i = 0; i < aux_list.size(); i++) {
            result[i] = aux_list.get(i);
        }
        return result;
    }
}
