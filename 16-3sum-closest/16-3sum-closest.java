class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length && closest != 0; i++) {
            int temp = nums[i];
            int lPtr = i + 1;
            int rPtr = nums.length - 1;
            while (lPtr < rPtr) {
                int sum = temp + nums[lPtr] + nums[rPtr];
                if (Math.abs(target - sum) < Math.abs(closest)) {
                    closest = target - sum; 
                }
                if (sum < target) { //too small
                    //otherwise update left pointer
                    ++lPtr;
                }
                else { //too big
                    --rPtr;
                }
                 //otherwise update right pointer
            }
        }
        return target - closest;
        
    }
}