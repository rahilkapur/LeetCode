class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        int counter = 0;
        while (counter < (k - 1)) {
            heap.poll();
            counter++;
        }
        return heap.poll();
        
        
    }
}