class Solution {
    public String addBinary(String a, String b) {
        StringBuilder temp = new StringBuilder();
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int carry = 0;
        while (aLen >= 0 || bLen >= 0) {
            int su = carry;
            if (aLen >= 0) {
                su += a.charAt(aLen--) - '0';
            }
            if (bLen >= 0) {
                su += b.charAt(bLen--) - '0';
            }
            if (su > 1) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            temp.append(su % 2);
    }
        if (carry != 0) {
            temp.append(1);
        }
        return temp.reverse().toString();
    }
}