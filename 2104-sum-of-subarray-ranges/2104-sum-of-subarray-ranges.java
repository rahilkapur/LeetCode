class Solution {
    public long subArrayRanges(int[] nums) {
        //[1, 2, 3]
        // 1, 2, 3
        int min = Integer.MAX_VALUE;
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > max) {
                max = nums[j];
            }
            if (nums[j] < min) {
                min = nums[j];
            }
                sum += max - min;
            }
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
        return sum;
        
    }
}