class Solution {
    protected void backtrack(List<List<Integer>> results, LinkedList<Integer> comb, int[] candidates, int remain, int start) {
        if (remain == 0) {
            results.add(new ArrayList<Integer>(comb));
        }
        else if (remain < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            comb.add(candidates[i]);
            this.backtrack(results, comb, candidates, remain - candidates[i], i);
            comb.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList();
        LinkedList<Integer> comb = new LinkedList();
        this.backtrack(results, comb, candidates, target, 0);
        return results;
    }
}