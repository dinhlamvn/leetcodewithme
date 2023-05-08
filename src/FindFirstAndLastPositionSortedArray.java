/**
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * ---
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * ---
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * */
public class FindFirstAndLastPositionSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int l = 0;
        int r = nums.length - 1;
        int pos = -1;

        while (l <= r) {
            final int mid = (l + r) / 2;
            int v = nums[mid];
            if (v == target) {
                pos = mid;
                break;
            } else if (v > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (pos == -1) {
            return new int[] {-1, -1};
        }

        int start = pos, end = pos;
        while (start >= 0 && nums[start] == target) start--;
        while (end < nums.length && nums[end] == target) end++;

        return new int[] {start + 1, end - 1};
    }
}
