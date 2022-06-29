class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int middle = l + ((r - l) / 2);
        while (l <= r) {
            middle = l + ((r - l) / 2);
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[l] <= nums[middle]) {
                if ((nums[middle] < target) || (nums[l] > target)) {
                    l = middle + 1;
                }
                else {
                    r = middle - 1;
                }
        }
        else {
            if ((target < nums[middle]) || (nums[r] < target)) {
                r = middle - 1;
            }
            else {
                l = middle + 1;
            }
        }
        
    }
        return -1;
}
}