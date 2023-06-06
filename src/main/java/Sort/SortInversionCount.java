package Sort;

import java.util.Arrays;

public class SortInversionCount {

    public static int SortInversionCountX2(int tab[]) {  //times complexity N^2
        int counter = 0;
        int i, j;

        for (i = 0; i < tab.length - 1; i++) {
            for (j = 0; j < tab.length - i - 1; j++) {
                if (tab[j] > tab[j + 1]) {
                    counter++;
                }
            }
        }

        return counter;
    }

    private static int mergeAndCount(int[] arr, int l, int m, int r) {

        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }

    public static int mergeSortAndCount(int[] arr, int l, int r) { // n LOGn

        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;


            count += mergeSortAndCount(arr, l, m);


            count += mergeSortAndCount(arr, m + 1, r);


            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

}
