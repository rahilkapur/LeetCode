class Solution {
    public int maxArea(int[] height) {
        int area = Integer.MIN_VALUE;
        int n = height.length;
        int lP = 0; 
        int rP = n - 1;
        while (lP < rP) {
            int tempArea = Math.min(height[lP], height[rP]) * (rP - lP);
            area = Math.max(area, tempArea);
            if (height[lP] < height[rP]) {
                lP++;
            }
            else {
                rP--;
            }
        }
        return area;
        
    }
}