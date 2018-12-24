package dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /*
    public static int lengthOfLIS(int[] nums) {
        int N = nums.length;
        if(N == 0) return 1;
        int[] seen = new int[N];
        int res = 0;
        for(int i = 0; i < N; i++)
            res = Math.max(res, lis(seen, nums, i));
        return res;
    }

    private static int lis(int[] seen, int[] nums, int i) {
        if(i == 0) return 1;
        if(seen[i] > 0) return seen[i];
        int res = 1;
        for(int j = 0; j < i; j++)
            if(nums[j] < nums[i])
                res = Math.max(res, lis(seen, nums, j) + 1);
        seen[i] = res;
        return seen[i];
    }

    public static void main(String[] args) {
        int[] a = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(a));
    }*/
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int N = nums.length;
        int[] seen = new int[N];
        Arrays.fill(seen, 1);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    seen[i] = Math.max(seen[i], seen[j] + 1);
                }
            }
        }
        Arrays.sort(seen);
        return seen[N-1];
    }
}
