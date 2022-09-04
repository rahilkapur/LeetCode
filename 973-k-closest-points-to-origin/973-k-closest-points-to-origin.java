class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int distance = (x * x) + (y * y);
            int[] temp = new int[2];
            temp[0] = distance;
            temp[1] = i;
            if (heap.size() == k) {
                if (heap.peek()[0] > distance) {
                    heap.poll();
                    heap.add(temp);
                }
            }
            else {
                heap.add(temp);
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < ans.length; i++) {
            int ind = heap.poll()[1]; //index of coordinate to add
            ans[i] = points[ind];
        }
        return ans;
        
    }
}