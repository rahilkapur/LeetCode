class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray()) {
            count[c]++;
        }
        int total = 0;
        for (int v: count) {
            total += v / 2 * 2; //calculates the number of letters present in longest palindrome with the amount of given letters in string s
            if ((total % 2 == 0) && (v % 2 == 1)) { //if the palindrome is of even length and the current letter as an odd number of letters in S, then we account for that by adding one to length of palindrome to include the odd letter in middle of string.
                total++;
            }
        }
        return total;
    }
}