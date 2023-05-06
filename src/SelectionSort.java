public class SelectionSort {

    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int pMin = i;
            int j = i + 1;
            while (j < nums.length) {
                if (nums[j] < nums[pMin]) pMin = j;
                j++;
            }

            int t = nums[pMin];
            nums[pMin] = nums[i];
            nums[i] = t;
        }
    }
}
