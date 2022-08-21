class Solution {
    private List<String> li = new ArrayList<>();
    public void backtrack(int openCount, int closedCount, String temp, int n) {
        //check if openCount == closedCount and openCount == n means that current combination is full
        if (openCount == closedCount && openCount == n) {
            li.add(temp);
            return; //current comb done
        }
        //check if we can add an open
        if (openCount < n) {
            temp += '(';
            backtrack(openCount+1, closedCount, temp, n);
            temp = temp.substring(0, temp.length() - 1); //current iteration after backtrack so we pop
        }
        if (closedCount < openCount) {
            temp += ')';
            backtrack(openCount, closedCount + 1, temp, n);
             temp = temp.substring(0, temp.length() - 1); //current iteration after backtrack so we pop
        }
        
    }
    public List<String> generateParenthesis(int n) {
        String temp = "";
        backtrack(0, 0, temp, n);
        return li;
        
        
    }
}