/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated
 * at an unknown pivot index k (1 <= k < nums.length) such that the resulting
 * array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of
 * target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int k = -1;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                k = i;
                break;
            }
        }

        int v;
        int left = 0;
        int right = k - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            v = nums[mid];
            if (v == target) {
                return mid;
            } else if (v < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = Math.max(k, 0);
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            v = nums[mid];
            if (v == target) {
                return mid;
            } else if (v < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
