/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 0;
        int end = n; //we will utilize a binary search to find our first bad call
        int mid = start + ((end - start) / 2);
        while (start <= end) {
            if (!(isBadVersion(mid)) && isBadVersion(mid + 1)) {
                return mid + 1;
            }
            else if ((isBadVersion(mid)) && isBadVersion(mid + 1)) {
                end = mid - 1;
                mid = start + ((end - start) / 2);
            }
            else {
                start = mid + 1;
                mid = start + ((end - start) / 2);
            }
        }
        return -1;
    }
}