package sort;

public class SortColors {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 1) return;
        int lt = 0;
        int gt = nums.length - 1;
        int i = 0;
        while(i <= gt) {
            if(nums[i] > 1) swap(nums, i, gt--);
            else if(nums[i] < 1) swap(nums, i++, lt++);
            else i++;
        }
    }
    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
