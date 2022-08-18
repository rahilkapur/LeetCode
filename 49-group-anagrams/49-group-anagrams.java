class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        HashMap<String, List> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            if (map.containsKey(String.valueOf(arr))) {
                map.get(String.valueOf(arr)).add(strs[i]);
            }
            else {
                map.put(String.valueOf(arr), new ArrayList());
                map.get(String.valueOf(arr)).add(strs[i]);
            }
        }
        return new ArrayList (map.values());
        
    }
}