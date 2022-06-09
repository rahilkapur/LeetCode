class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int suffix = nums[0];
        int numAppears = 1;
        for (int i = 1; i < nums.length; i++) {
            if (numAppears == 0) {
                suffix = nums[i];
                numAppears = 1;
                continue;
            }
            if (nums[i] == suffix) {
                ++numAppears;
            }
            else {
                --numAppears;
            }
        }
        return suffix;
        
    }
}