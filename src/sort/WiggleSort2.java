package sort;

import java.util.Arrays;

public class WiggleSort2 {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 2) return;

        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);

        int j = (nums.length + 1) / 2;
        int k = nums.length - 1;

        for(int a = 0; a < nums.length; a++) {
            nums[a] = (a & 1) == 1 ? tmp[k--] : tmp[j--];
        }
    }
}
