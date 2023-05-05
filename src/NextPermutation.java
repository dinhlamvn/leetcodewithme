import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[i] >= nums[j]) j--;

            if (j >= 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        int start = i + 1;
        int mid = (n + start) / 2;
        int k = 0;
        for (i = start; i < mid; ++i, ++k) {
            int t = nums[i];
            nums[i] = nums[n - k - 1];
            nums[n - k - 1] = t;
        }
    }
}
