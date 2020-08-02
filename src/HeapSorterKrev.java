public class HeapSorterKrev extends Sorter {
    @Override
    public int[] sort(int[] arr) {
        heapSort(arr, arr.length - 1);
        return arr;
    }

    protected void heapSort(int[] arr, int right) {
        if (right <= 0) {
            return;
        }

        for (int i = right; i > 0; i--) {
            int parent_index = (i-1)/2;
            if (arr[parent_index] <= arr[i]) {
                int temp = arr[i];
                arr[i] = arr[parent_index];
                arr[parent_index] = temp;
            }
        }

        System.out.print("temp array: ");
        printArray(arr);

        int tempHead = arr[0];
        arr[0] = arr[right];
        arr[right] = tempHead;

        heapSort(arr, right-1);
    }
}
