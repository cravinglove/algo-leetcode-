package sort;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 2) return;
        for(int i = 1; i < nums.length; i++) {
            if((i & 1) == 1 && nums[i] < nums[i - 1] || (i & 1) == 0 && nums[i] > nums[i - 1]) {
                int t = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = t;
            }
        }
    }
}
