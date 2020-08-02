public class BubbleSorter extends Sorter {
    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int change = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    change = 1;
                }
            }

            if (change == 0) {
                break;
            }
            //debug printing
            printArray(arr);
        }
        return arr;
    }
}
