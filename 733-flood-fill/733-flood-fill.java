class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (newColor != oldColor) {
            search(image, sr, sc, oldColor, newColor);
        }
        return image;
    }
    public void search(int[][] image, int l, int r, int oldColor, int newColor) {
        if (image[l][r] == oldColor) {
            image[l][r] = newColor;
            if (l >= 1) {
                search(image, l - 1, r, oldColor, newColor);
            }
            if (r >= 1) {
                search(image, l, r - 1, oldColor, newColor);
            }
            if (l + 1 < image.length) {
                search(image, l + 1, r, oldColor, newColor);
            }
            if (r + 1 < image[0].length) {
                search(image, l, r + 1, oldColor, newColor);
            }
        } 
    }
}