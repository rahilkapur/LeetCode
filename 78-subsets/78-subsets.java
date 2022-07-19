class Solution {
    List<List<Integer>> subs = new ArrayList<>();
    int k; //size of current combination
    int n;
    
    
    public void backtrack(int start, ArrayList<Integer> temp, int[] nums) {
        if (temp.size() == k) {
            subs.add(new ArrayList(temp));
            return;
        }
        for (int i = start; i < n; i++) {
            temp.add(nums[i]);
            backtrack(i + 1, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; k++) {
            backtrack(0, new <Integer>ArrayList(), nums);
        }
        return subs;
        
    }
}