class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int ansLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int lPtr = i;
            int rPtr = i;
            while (lPtr >= 0 && rPtr < s.length() && (s.charAt(lPtr) == (s.charAt(rPtr)))) {
                if ((rPtr - lPtr + 1) > ansLength) {
                    ansLength = rPtr - lPtr + 1;
                    ans = s.substring(lPtr, rPtr + 1);
                }
                --lPtr;
                ++rPtr;
            }
            lPtr = i;
            rPtr = i + 1;
            while (lPtr >= 0 && rPtr < s.length() && (s.charAt(lPtr) == (s.charAt(rPtr)))) {
                if ((rPtr - lPtr + 1) > ansLength) {
                    ansLength = rPtr - lPtr + 1;
                    ans = s.substring(lPtr, rPtr + 1);
                }
                --lPtr;
                ++rPtr;
            }
        }
        return ans;
        
    }
}