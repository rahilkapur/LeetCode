class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);
            if (map.containsKey(temp)) {
                map.replace(temp, map.get(temp) + 1);
            }
            else {
                map.put(temp, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
        
    }
}