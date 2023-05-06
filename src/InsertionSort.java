public class InsertionSort {
    public void sort(int[] nums) {

        for (int i = 1; i < nums.length; ++i) {
            int j = i;
            int v = nums[i];

            while (j > 0 && nums[j - 1] > v) {
                nums[j] = nums[j - 1];
                j--;
            }

            nums[j] = v;
        }
    }
}
