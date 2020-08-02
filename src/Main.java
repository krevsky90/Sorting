/**
 * https://proglib.io/p/java-sorting-algorithms
 */
public class Main {
//    public static int[] arr = {4, 6, 1, 2, 8, 0, 9, 3};
//    public static int[] arr = {};
//    public static int[] arr = {8, 0, 4, 2, 3, 7, 10, 12, -3};
    public static int[] arr = {8, 0, 4, 2, 7, 10, 12};

    public static void main(String[] args) {
        Sorter sorter = new HeapSorterEvileg();

        System.out.println("Before sorting:");
        sorter.printArray(arr);
        int[] res = sorter.sort(arr);

        System.out.println("After sorting:");
        sorter.printArray(res);
    }
}


