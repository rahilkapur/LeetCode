class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magMap = new HashMap(); //maps every char in magazine to however many times it appears
        HashMap<Character, Integer> ranMap = new HashMap(); //same thing but for ransom
        for (int i = 0; i < magazine.length(); i++) {
            if (magMap.containsKey(magazine.charAt(i))) {
                magMap.put(magazine.charAt(i), magMap.get(magazine.charAt(i)) + 1);
            }
            else {
                magMap.put(magazine.charAt(i), 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (ranMap.containsKey(ransomNote.charAt(i))) {
                ranMap.put(ransomNote.charAt(i), ranMap.get(ransomNote.charAt(i)) + 1);
            }
            else {
                ranMap.put(ransomNote.charAt(i), 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (magMap.get(ransomNote.charAt(i)) == null) {
                return false;
            }
            else if (ranMap.get(ransomNote.charAt(i)) > magMap.get(ransomNote.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}