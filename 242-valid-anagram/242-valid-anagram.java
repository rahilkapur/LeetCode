class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> sMap = new HashMap();
        HashMap<Character, Integer> tMap = new HashMap();
        char sarr[] = s.toCharArray();
        char tarr[] = t.toCharArray();
        for (char c: sarr) {
            if (sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) + 1);
            }
            else {
                sMap.put(c, 1);
            }
        }
        for (char c: tarr) {
            if (tMap.containsKey(c)) {
                tMap.put(c, tMap.get(c) + 1);
            }
            else {
                tMap.put(c, 1);
            }
        }
            for (char c: sarr) {
                int sCount = sMap.get(c);
                if (!(tMap.containsKey(c))) {
                    return false;
                }
                if (sCount != tMap.get(c)) {
                     return false;
                    }
                }
            return true;
            }
    }