class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList();
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < p.length(); i++) {
            if (map.containsKey(p.charAt(i))) {
                map.replace(p.charAt(i), map.get(p.charAt(i)) + 1);
            }
            else {
                map.put(p.charAt(i), 1);
            }
        }
        int len = p.length();
        HashMap<Character, Integer> tempMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (tempMap.containsKey(curr)) {
                tempMap.replace(curr, tempMap.get(curr) + 1);
            }
            else {
                tempMap.put(curr, 1);
            }
            if (i >= len) {
                char rem = s.charAt(i - len);
                if (tempMap.get(rem) == 1) {
                    tempMap.remove(rem);
                }
                else {
                    tempMap.replace(rem, tempMap.get(rem) - 1);
                }
                
            }
            if (tempMap.equals(map)) {
                list.add(i - len + 1);
            }
        }
        return list;
       
        
    }
}