/**
 * http://www.javenue.info/post/45
 * главная идея - менять cur, если swap-ится опорный элемент
 */
public class QuickSorterFromJavenue extends Sorter {
    @Override
    public int[] sort(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        doSort(arr, startIndex, endIndex);

        return arr;
    }

    private void doSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start, j = end;
        int cur = (i + j) / 2;
        while (i < j) {
            while (i < cur && (arr[i] <= arr[cur])) {
                i++;
            }
            while (j > cur && (arr[cur] <= arr[j])) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(arr, start, cur);
        doSort(arr, cur + 1, end);
    }
}
