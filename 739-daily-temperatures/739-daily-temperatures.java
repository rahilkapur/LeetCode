class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int ptr = i + 1;
            while (ptr < temperatures.length) {
                if (temperatures[i] < temperatures[ptr]) {
                    answer[i] = ptr - i;
                    break;
                }
                ptr++;
            }
        }
        return answer;
        
    }
}