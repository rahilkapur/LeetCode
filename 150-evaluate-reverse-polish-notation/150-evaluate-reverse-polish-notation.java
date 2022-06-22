class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack();
        for (String temp: tokens) {
            //System.out.println(temp);
            if (temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")) {
                System.out.println(temp);
                int first = Integer.parseInt(st.pop());
                int second = Integer.parseInt(st.pop());
                if (temp.equals("+")) {
                    int put = first + second;
                    System.out.println(put);
                    st.push(Integer.toString(put));
                    continue;
                }
                else if (temp.equals("-")) {
                    int put = second - first;
                    st.push(Integer.toString(put));
                    continue;
                }
                else if (temp.equals("*")) {
                    int put = first * second;
                    st.push(Integer.toString(put));
                    continue;
                }
                else {
                    int put = second / first;
                    st.push(Integer.toString(put));
                    continue;
                }
            }
            st.push(temp);
        }
        return Integer.parseInt(st.pop());
        
    }
}