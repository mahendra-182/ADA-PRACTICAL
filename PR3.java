import java.util.*;

public class PR3 {

    public static void insertElements(int arr[], int num) {
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            arr[i] = rand.nextInt();
        }
    }

    public static void Array(int arr[], int num) {
        if (num <= 20) {
            for (int i = 0; i < num; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void insertionSort(int arr[], int num) {

        for (int i = 1; i < num; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Total Number of Elements :- ");
        int num = sc.nextInt();
        int arr[] = new int[num];
        insertElements(arr, num);

        if (num <= 20) {
            System.out.print("UnSorted Array :- ");
            Array(arr, num);
            long startTime = System.nanoTime();
            insertionSort(arr, num);
            long endTime = System.nanoTime();
            System.out.print("Sorted Array :- ");
            Array(arr, num);
        }
        long startTime = System.nanoTime();
        insertionSort(arr, num);
        long endTime = System.nanoTime();

        long executionTimeNS = endTime - startTime;
        double executionTimeMS = executionTimeNS / 1_000_000.0;

        System.out.println("Execution Time :- ");
        System.out.println("Nanoseconds :- " + executionTimeNS + " ns");
        System.out.println("Milliseconds :- " + executionTimeMS + " ms");
    }
}
