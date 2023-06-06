package Sort;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.chrono.MinguoEra;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;
import java.util.stream.IntStream;

public class Sort {

    public static void main(String[] args) {
        int length = 10000;
        Random random = new Random();
        int[] numbers = new int[length];
        int[] numbers2 = new int[length];
        int[] numbers3 = new int[length];
        int[] numbers4 = new int[length];

          long sumShell  = 0;
          long sumArray = 0;
          long sumMerge = 0;
          long sumTim = 0;



          for(int i = 0; i < 1000 ;i++){

              for (int j = 0; j < length; j++) {
                  int randomInt = random.nextInt()%2;
                  numbers[j] = randomInt;
                  numbers2[j] = randomInt;
                  numbers3[j] = randomInt;
                  numbers4[j] = randomInt;
              }


              long start = System.nanoTime();
              sortShell(numbers);
              long end = System.nanoTime();
              sumShell += end - start;

              start = System.nanoTime();
              Arrays.sort(numbers3);
              end = System.nanoTime();
              sumArray += end - start;

              start = System.nanoTime();
              MergeSort(numbers2,0,numbers2.length-1);
              end = System.nanoTime();
              sumMerge += end - start;

              start = System.nanoTime();
              timSort(numbers4,numbers4.length-1);
              end = System.nanoTime();
              sumTim += end - start;

          }

            System.out.println(sumArray/1000 + "\n" + sumShell/1000 + "\n" + sumMerge/1000 +"\n" + sumTim/1000);

        }

    public static int[] BubbleSort(int tab[]) {

        int i, j;
        int n = tab.length;

        for (i = 0; i < n - 1; i++) {
            for (j = 0; j < n - i - 1; j++) {
                if (tab[j] > tab[j + 1]) {

                    int temp = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = temp;

                }
            }
        }

        return tab;
    }

    public static int[] SelectionSort(int tab[]) {

        int i, j;
        int min_value;
        int temp;

        for (i = 0; i < tab.length - 1; i++) {

            min_value = i;
            for (j = i + 1; j < tab.length; j++) {

                if (tab[j] < tab[min_value]) {

                    min_value = j;

                }
            }

            temp = tab[i];
            tab[i] = tab[min_value];
            tab[min_value] = temp;

        }

        return tab;
    }

    private static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static int[] MergeSort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort.Sort first and second halves
            MergeSort(arr, l, m);
            MergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return arr;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static int[] InsertionSort(int tab[], int left, int right) {

         int key, j;
        for (int i = left+1; i <= right; i++) {

            key = tab[i];
            j = i - 1;
            while (j >= 0 && tab[j] > key) {
                tab[j + 1] = tab[j];
                j--;
            }

            tab[j + 1] = key;

        }
        return tab;
    }

    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }

    public static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    static int bingo;
    static int nextBingo;

    // Function for finding the maximum and minimum element
    // of
    // the Array
    static void maxMin(int[] vec, int n)
    {
        for (int i = 1; i < n; i++) {
            bingo = Math.min(bingo, vec[i]);
            nextBingo = Math.max(nextBingo, vec[i]);
        }
    }

    // Function to sort the array
    static void bingoSort(int[] vec, int n)
    {
        bingo = vec[0];
        nextBingo = vec[0];
        maxMin(vec, n);
        int largestEle = nextBingo;
        int nextElePos = 0;
        int startPos;
        int temp;
        while (bingo < nextBingo) {
            // Will keep the track of the element position
            // to
            // shifted to their correct position
            startPos = nextElePos;
            for (int i = startPos; i < n; i++) {
                if (vec[i] == bingo) {
                    temp = vec[i];
                    vec[i] = vec[nextElePos];
                    vec[nextElePos++] = temp;
                }
                else if (vec[i] < nextBingo)
                    nextBingo = vec[i];
            }
            bingo = nextBingo;
            nextBingo = largestEle;
        }
    }

    public static void sortShell(int arr[])
    {

        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > key) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = key;
            }
        }
    }

    static int MIN_MERGE = 64;

    public static int minRunLength(int n)
    {
        assert n >= 0;


        int r = 0;
        while (n >= MIN_MERGE)
        {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    public static void timSort(int[] arr, int n)
    {
        int minRun = minRunLength(MIN_MERGE);

        for (int i = 0; i < n; i += minRun)
        {
            InsertionSort(arr, i,
                    Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        for (int size = minRun; size < n; size = 2 * size)
        {


            for (int left = 0; left < n;
                 left += 2 * size)
            {


                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1),
                        (n - 1));


                if(mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }

}



