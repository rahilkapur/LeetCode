class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        LinkedList<int[]> out = new LinkedList();
        int len = intervals.length;
        int ind = 0;
        while  (ind < len && intervals[ind][0] < newStart) {
            out.add(intervals[ind++]);
        }
        int[] inter = new int[2];
        if (out.isEmpty() || out.getLast()[1] < newStart) {//no conflict, no need to merge
            out.add(newInterval);
        }
        else {
            inter = out.removeLast();
            inter[1] = Math.max(inter[1], newEnd);
            out.add(inter);
        }
        while (ind < len) {
            inter = intervals[ind++]; //check if next interval should be merged or not
            int start = inter[0];
            int end = inter[1];
            if (out.getLast()[1] < start) {
                out.add(inter);
            }
            else {
                inter = out.removeLast();
                inter[1] = Math.max(inter[1], end);
                out.add(inter);
            }
        }
        return out.toArray(new int[out.size()][2]);
    }
}