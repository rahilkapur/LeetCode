class Solution {
    public int largestVariance(String s) {
        int[] freq = new int[26];
        int maxVariance = 0;
        boolean isValid = false;
        for (int i = 0; i < s.length(); i++) {
            if (++freq[s.charAt(i) - 'a'] > 1) {
                isValid = true;
            }
        }
        if (isValid == false) { //no valid substring
            return 0;
        }
        //we want to get two diff letters in string and find max substring variance
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) { //char does not exist in string
                continue;
            }
            for (int j = 0; j < 26; j++) {
                if (i == j || freq[j] == 0) { //same letter or not in string
                    continue;
                }
                int first = 0;
                int second = 0;
                int firstFreq = freq[i];
                int secondFreq = freq[j];
                for (char c: s.toCharArray()) {
                    int curr = c - 'a';
                    if (curr == i) {
                        ++first;
                        --firstFreq;
                    }
                    else if (curr == j) {
                        ++second;
                        --secondFreq;
                    }
                    else {
                        continue;
                    }
                    if (first < second && firstFreq > 0 && secondFreq > 0) {
                        first = 0;
                        second = 0;
                    }
                    else if (second > 0 && first > second) {
                        maxVariance = Math.max(maxVariance, first - second);
                    }
                    else if (firstFreq + secondFreq == 0) {
                        break;
                    }
                }
            }
        }
        return maxVariance;
        
    }
}