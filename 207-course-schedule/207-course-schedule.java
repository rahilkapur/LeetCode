class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int[] arr: prerequisites) {
            if (map.containsKey(arr[1])) {
                map.get(arr[1]).add(arr[0]);
            }
            else {
                ArrayList<Integer> li = new ArrayList();
                li.add(arr[0]);
                map.put(arr[1], li);
            }
        }
        boolean[] arr = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];
        for (int i = 0; i < arr.length; i++) {
            if (isCycle(i, map, arr, checked)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isCycle(int course, HashMap<Integer, List<Integer>> map, boolean[] arr, boolean[] checked) {
        if (arr[course] == true) {
            return true;
        }
        if (checked[course] == true) {
            return false;
        }
        if (!(map.containsKey(course))) { //cannot backtrack thus skip
            return false;
        }
        arr[course] = true;
        boolean ret = false;
        for (Integer cour: map.get(course)) {
            ret = isCycle(cour, map, arr, checked);
            if (ret) {
                break;
            }
        }
        arr[course] = false;
        checked[course] = true; //means that if we come across this node again, it will not have any cycles
        return ret;
    }
}