class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.replace(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Integer> q = new PriorityQueue( (n1, n2) -> map.get(n1) - map.get(n2));
        
        for (int i = 0; i < nums.length; i++) {
            if (q.contains(nums[i])) {
                continue;
            }
            q.add(nums[i]);
            if (q.size() > k) {
                q.poll();
            }
        }
        int [] arr = new int[k];
        for (int i = k - 1; i >= 0; i--) { //build array backwards by adding least freq to mostfreq
            arr[i] = q.poll();
        
            
        }
        return arr;
        
        
        
    }
}