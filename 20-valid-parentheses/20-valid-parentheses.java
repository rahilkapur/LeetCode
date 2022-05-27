class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        for (char a: s.toCharArray()) {
            if (a == '(') {
                st.push(')');
            }
            else if (a == '[') {
                st.push(']');
            }
            else if (a == '{') {
                st.push('}');
            }
            else if (st.isEmpty() || st.pop() != a) {
                return false;
            }
        }
        return st.isEmpty();
        
    }
}