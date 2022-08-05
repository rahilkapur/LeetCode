class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int lPtr = 0;
        int rPtr = nums.length - 1;
        int sum = -1;
        while (lPtr < rPtr) {
            int temp = nums[lPtr] + nums[rPtr];
            if (temp < k) {
                sum = Math.max(sum, temp);
                ++lPtr;
            }
            else {
                --rPtr;
            }
        }
        return sum;
        
        
    }
}