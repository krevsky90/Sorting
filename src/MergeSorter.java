/**
 * This solution is not optimized since each time we create 2 subarays that requires additional memory
 */
public class MergeSorter extends Sorter {
    @Override
    public int[] sort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int separator = arr.length / 2;
        int[] part1 = new int[separator];
        System.arraycopy(arr, 0, part1, 0, separator);
        int[] part2 = new int[arr.length - separator];
        System.arraycopy(arr, separator, part2, 0, arr.length - separator);

        part1 = sort(part1);
        part2 = sort(part2);
        return merge(part1, part2);
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        int[] result = new int[len];
        int i1 = 0;
        int i2 = 0;
        while (i1 < arr1.length && i2 < arr2.length) {
            if (arr1[i1] < arr2[i2]) {
                result[i1 + i2] = arr1[i1];
                i1++;
            } else {
                result[i1 + i2] = arr2[i2];
                i2++;
            }
        }

        if (i1 == arr1.length) {
            for (int i22 = i2; i22 < arr2.length; i22++) {
                result[i1 + i22] = arr2[i22];
            }
        }

        if (i2 == arr2.length) {
            for (int i11 = i1; i11 < arr1.length; i11++) {
                result[i11 + i2] = arr1[i11];
            }
        }

        return result;
    }
}
