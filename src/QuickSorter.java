public class QuickSorter extends Sorter {
    @Override
    public int[] sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        merge(arr, left, right);

        return arr;
    }

    protected void merge(int[] arr, int left, int right) {
        System.out.println("-------- merge func: left = " + left + ", right = " + right + " --------");
        if (arr.length == 0) {
            return;
        }

        if (right <= left) {
//            System.out.println("right = " + right + " <= left " + left);
            //return 1 element
            return;
        }

        printSubArray(arr, left, right);

        int i = left;
        int j = right;
        int pivot_index = (right + left) / 2;
        int pivot_value = arr[pivot_index];
        System.out.println("pivot_value = " + pivot_value);

        while (i < j) {
            while (arr[i] < pivot_value) {
                i++;
            }

            while (arr[j] > pivot_value) {
                j--;
            }

            if (i <= j) {
                //event if i=j and swap doesn't change the order of array, this block also changes i/j counters preventing from infinite loop in case like the following:
                //call merge(arr, 0, 1) where left = 0, right = 1:
                //pivot = 0 -> i = 0, j = 1 -> i = 0; j = 0 -> recursive calls: merge(arr, 0, 0) and !!! merge(arr, 0, 1) !!!
                System.out.println("swap arr[" + i + "]=" + arr[i] + " and arr[" + j + "]=" + arr[j]);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            System.out.println("after swapping: i = " + i + ", j = " + j);
            printArray(arr);
        }

        merge(arr, left, j);
        merge(arr, i, right);
    }

    private void printSubArray(int[] arr, int left, int right) {
        String subArrayStr = "{ ";
        for(int k = left; k <= right; k++) {
            subArrayStr += arr[k] + " ";
        }
        subArrayStr += "}";
        System.out.println("temp sub-array to be sorted is " + subArrayStr);
    }
}