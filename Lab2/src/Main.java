public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 5;
        int[] lastNElements = getLast(array, n);
        for (int num : lastNElements) {
            System.out.print(num + " ");
        }
    }
    public static int[] getLast(int[] array, int n) {
        if (n > array.length) {
            n = array.length;
        }
        int[] resultArray = new int[n];
        int startIndex = array.length - n;
        for (int i = 0; i < n; i++) {
            resultArray[i] = array[startIndex + i];
        }
        return resultArray;
    }
}