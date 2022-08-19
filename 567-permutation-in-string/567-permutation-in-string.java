class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap();
         int size = s1.length();
        for (int i = 0; i < size; i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.replace(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            }
            else {
                map.put(s1.charAt(i), 1);
            }
        }
        HashMap<Character, Integer> checkMatch = new HashMap();
        for (int i = 0; i < s2.length(); i++) {
            if (checkMatch.containsKey(s2.charAt(i))) {
                checkMatch.replace(s2.charAt(i), checkMatch.get(s2.charAt(i)) + 1);
            }
            else {
                checkMatch.put(s2.charAt(i), 1);
            }
            if (i >= size) {
                char rem = s2.charAt(i - size);
                if (checkMatch.get(rem) == 1) {
                    checkMatch.remove(rem);
                }
                else {
                    checkMatch.replace(rem, checkMatch.get(rem) - 1);
                }
                
            }
            if (checkMatch.equals(map)) {
                return true;
            }
        }
        return false;
        
    }
}