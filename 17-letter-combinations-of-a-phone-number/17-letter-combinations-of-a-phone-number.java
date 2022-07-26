class Solution {
    ArrayList<String> ans = new ArrayList();
    private Map<Character, String> map = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    public void backtrack(String digits, int len, StringBuilder temp, int start) {
        if (temp.length() == len) {
            ans.add(temp.toString());
            return;
        }
        String curr = map.get(digits.charAt(start));
        for (int i = 0; i < curr.length(); i++) {
            temp.append(curr.charAt(i));
            backtrack(digits, len, temp, start + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
        
    }
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        int n = digits.length();
        backtrack(digits, n, new StringBuilder(), 0);
        return ans;
        
        
    }
}