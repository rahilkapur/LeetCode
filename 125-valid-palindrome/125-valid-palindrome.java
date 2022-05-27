class Solution {
    public boolean isPalindrome(String s) {
        int i = 0; 
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toUpperCase();
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}