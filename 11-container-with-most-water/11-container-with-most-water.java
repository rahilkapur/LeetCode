class Solution {
    public int maxArea(int[] height) {
        int area = Integer.MIN_VALUE;
        int lPtr = 0;
        int rPtr = height.length - 1;
        while (lPtr < rPtr) {
            int tempArea = (rPtr - lPtr) * Math.min(height[lPtr], height[rPtr]);
            if (tempArea > area) {
                area = tempArea;
            }
            if (height[lPtr] > height[rPtr]) {
                --rPtr;
            }
            else {
                ++lPtr;
            }
        }
        return area;
        
    }
}