class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int sum = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] + nums[j];
                if (temp < k && temp > sum) {
                    sum = temp;
                }
            }
        }
        return sum;
        
    }
}