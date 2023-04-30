/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element
 * appears only once. The relative order of the elements
 * should be kept the same. Then return the number of unique elements in nums.
 * ---
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * */
public class RemoveDuplicateInSortedArray {
    public int removeDuplicates(int[] nums) {
        int k = 0;

        for (int num : nums) {
            if (k == 0 || num != nums[k - 1]) {
                nums[k] = num;
                ++k;
            }
        }

        return k;
    }
}
