import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 3, 4, 1, 2, 3, 2, 1, 1, 2, 3, 4, 5, 6, 6, 7, 7, 8, 9, };
        System.out.println("Изначальный массив: " + Arrays.toString(arr));
        heapsort(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }

    private static void heapsort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int i, int n) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;

        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (i != largest) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, largest, n);
        }

    }
}