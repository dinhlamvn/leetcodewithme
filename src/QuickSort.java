public class QuickSort {

    private int partition(int[] arr, int l, int r) {
        int mid = (l + r) / 2;
        int pi = arr[mid];
        int i = l, j = r;

        while (i <= j) {
            while (arr[i] < pi) i++;
            while (arr[j] > pi) j--;

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return i;
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pi = partition(arr, l, r);

            quickSort(arr, l, pi - 1);
            quickSort(arr, pi + 1, r);
        }
    }

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
}
