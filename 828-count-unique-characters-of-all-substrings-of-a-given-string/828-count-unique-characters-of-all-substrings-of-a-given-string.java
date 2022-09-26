class Solution {
    public int uniqueLetterString(String s) {
        //need to calculate left and right characters between each character in string to get number of substrings where that character is unique thus
        HashMap<Character, List<Integer>> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            map.computeIfAbsent(s.charAt(i), key -> new ArrayList<Integer>() ).add(i);
        }
        int sum = 0;
        for (List<Integer> indxes: map.values()) { //looping through all indices for all characters in string
            for (int i = 0; i < indxes.size(); i++) { //for every index for every character, need to calculate number of substrings where THIS specfic index for this character is unique
                // X X L 
                int left = i == 0 ? indxes.get(i) + 1 : indxes.get(i) - indxes.get(i - 1);
                // L X X L X X
                int right = i == indxes.size() - 1 ? s.length() - indxes.get(i) : indxes.get(i + 1) - indxes.get(i);
                sum += left * right;
                
            }
            
        }
        return sum;
        
    }
}