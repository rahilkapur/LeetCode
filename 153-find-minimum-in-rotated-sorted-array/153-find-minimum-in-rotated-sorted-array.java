class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int lPtr = 0;
        int rPtr = nums.length;
        if (nums[rPtr - 1] > nums[0]) { //array is sorted then nums[0] is smallest
            return nums[0];
        }
        while (lPtr <= rPtr) {
            int middle = lPtr + ((rPtr - lPtr) / 2);
            if (nums[middle - 1] > nums[middle]) {
                return nums[middle];
            }
             if (nums[middle + 1] < nums[middle]) {
                return nums[middle + 1];
            }
            if (nums[0] > nums[middle]) {
                --rPtr;
            }
            else {
                ++lPtr;
            }
            
        }
        return 0;
        
    }
}