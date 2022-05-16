/**
 * Info: https://www.javatpoint.com/radix-sort
 */
public class RadixSorter extends Sorter {
    @Override
    public int[] sort(int[] arr) {
        // get maximum element from array
        int max = getMax(arr);

        // Apply counting sort to sort elements based on place value
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(arr, place);
        }
        return arr;
    }

    protected void countingSort(int a[], int place) {// function to implement counting
        int n = a.length;
        int[] output = new int[n + 1];
        int[] count = new int[10];

        // Calculate count of elements
        for (int i = 0; i < n; i++) {
            count[(a[i] / place) % 10]++;
        }

        // Calculate cumulative frequency
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Place the elements in sorted order
        for (int i = n - 1; i >= 0; i--) {
            output[count[(a[i] / place) % 10] - 1] = a[i];
            count[(a[i] / place) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            a[i] = output[i];
        }
    }

    private int getMax(int a[]) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max; //maximum element from the array
    }
}