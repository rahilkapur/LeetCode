class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int localMax = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            localMax = Math.max(nums[i], nums[i] + localMax);
            if (localMax > max) {
                max = localMax;
            }
        }
        return max;
    }
}