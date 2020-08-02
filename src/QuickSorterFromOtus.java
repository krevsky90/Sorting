/**
 * https://otus.ru/nest/post/788/
 */
public class QuickSorterFromOtus extends Sorter {
    @Override
    public int[] sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);

        return arr;
    }

    public static void quickSort(int[] array, int low, int high) {
        System.out.println("merge func: left = " + low + ", right = " + high);
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];
        System.out.println("pivot_value = " + opora);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}
