package Search;

import java.util.Arrays;
import java.util.Random;

public class NumberSearch {

    public static void main(String[] args) {



    }



    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static int ternarySearch(int l, int r, int key, int ar[])
    {
        if (r >= l) {

            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;


            if (ar[mid1] == key) {
                return mid1;
            }
            if (ar[mid2] == key) {
                return mid2;
            }

            if (key < ar[mid1]) {
                return ternarySearch(l, mid1 - 1, key, ar);
            }
            else if (key > ar[mid2]) {
                return ternarySearch(mid2 + 1, r, key, ar);
            }
            else {
                return ternarySearch(mid1 + 1, mid2 - 1, key, ar);
            }
        }
        return -1;
    }
    public static int sentinelLinearSearch(int arr[], int n, int key)
    {
        int last = arr[n - 1];

        arr[n - 1] = key;
        int i = 0;

        while (arr[i] != key)
            i++;

        arr[n - 1] = last;

        if ((i < n - 1) || (arr[n - 1] == key))
            return i;
        else
           return -1;
    }

    public static int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partion(nums, start, end);
            if (pivot < index) start = pivot + 1;
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }

    private static int partion(int[] nums, int start, int end) {
        int pivot = start, temp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }

    public static int interpolationSearch(int ar[],int lo, int hi, int x){
        if(lo <= hi && ar[lo] <= x && ar[hi] >= x){
            int pos = lo + ((hi-lo)/(ar[hi]-ar[lo]) * (x-ar[lo]) );

            if(ar[pos] == x){
                return pos;
            }
            if(ar[pos] < x){
                return interpolationSearch(ar,pos+1,hi,x);
            }
            if(ar[pos] > x){
                return interpolationSearch(ar,lo,pos-1,x);
            }

        }
        return -1;
    }




}
