import java.util.Arrays;

public class MergeSort {

    private void merge(int[] arr, int l, int m, int r) {
        int s1 = m - l + 1;
        int s2 = r - m;

        int[] left = new int[s1];
        int[] right = new int[s2];

        System.arraycopy(arr, l, left, 0, s1);

        System.arraycopy(arr, m + 1, right, 0, s2);

        int i, j, k;
        for (i = 0, j = 0, k = l; i < s1 && j < s2; ++k) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                ++i;
            } else {
                arr[k] = right[j];
                ++j;
            }
        }

        while (i < s1) {
            arr[k] = left[i];
            ++i;
            ++k;
        }

        while (j < s2) {
            arr[k] = right[j];
            ++j;
            ++k;
        }
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }

    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }
}
