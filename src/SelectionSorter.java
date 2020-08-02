public class SelectionSorter extends Sorter {
    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_index = i;
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    min_index = j;
                }
            }
            //to swap or not to swap
            if (i != min_index) {
                System.out.println("SelectionSorter# swap " + arr[i] + " and " + min);
                int temp = arr[i];
                arr[i] = min;
                arr[min_index] = temp;
            } else {
                System.out.println("SelectionSorter# Don't swap");
            }
            System.out.println("SelectionSorter# debug result: i = " + i);
            printArray(arr);
        }

        return arr;
    }
}
