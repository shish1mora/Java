import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sortedArray = generateSortedArray(10000);
        int[] randomArray = generateRandomArray(10000);
        int[] partiallyRandomArray = generatePartiallyRandomArray(10000, 0.1);

        measureSortTime(sortedArray, "Отсортированный массив");
        measureSortTime(randomArray, "Рандомный массив");
        measureSortTime(partiallyRandomArray, "Отсортированный массив с первыми 10% случайными элементами");
    }

    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static int[] generatePartiallyRandomArray(int size, double randomPercentage) {
        int[] array = new int[size];
        Random random = new Random();
        int randomSize = (int) (size * randomPercentage);
        for (int i = 0; i < size; i++) {
            if (i < randomSize) {
                array[i] = random.nextInt();
            } else {
                array[i] = i;
            }
        }
        return array;
    }

    public static void measureSortTime(int[] array, String arrayType) {
        long startTime, endTime, duration;

        // Сортировка пузырьком
        int[] bubbleSortArray = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        bubbleSort(bubbleSortArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Сортировка пузырьком для " + arrayType + ": " + duration / 1_000_000 + " миллисекунд");

        // Сортировка вставками
        int[] insertionSortArray = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        insertionSort(insertionSortArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Сортировка вставками для " + arrayType + ": " + duration / 1_000_000 + " миллисекунд");

        // Сортировка выбором
        int[] selectionSortArray = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        selectionSort(selectionSortArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Сортировка выбором для " + arrayType + ": " + duration / 1_000_000 + " миллисекунд");

        // Сортировка слиянием
        int[] mergeSortArray = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Сортировка слиянием для " + arrayType + ": " + duration / 1_000_000 + " миллисекунд");

        // Быстрая сортировка
        int[] quickSortArray = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        quickSort(quickSortArray, 0, quickSortArray.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Быстрая сортировка для " + arrayType + ": " + duration  / 1_000_000+ " миллисекунд");

        System.out.println();
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}