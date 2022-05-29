class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int localMax = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) { //kadanes algo we check to see if the local max is either nums[i] or if it is nums[i] + local max of nums[i - 1] making our algo O(n) since we're going thru the array only once finding our max everytime not needing to go back and check constantly
            localMax = Math.max(nums[i], nums[i] + localMax);
            if (localMax > max) {
                max = localMax;
            }
        }
        return max;
    }
}