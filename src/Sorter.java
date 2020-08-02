public abstract class Sorter {
    public abstract int[] sort(int[] arr);

    public void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
