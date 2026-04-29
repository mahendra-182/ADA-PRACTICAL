import java.util.*;

public class PR5 {

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

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
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
            quickSort(arr, 0, num - 1);
            long endTime = System.nanoTime();
            System.out.print("Sorted Array :- ");
            Array(arr, num);
        }
        long startTime = System.nanoTime();
        quickSort(arr, 0, num - 1);
        long endTime = System.nanoTime();


        long executionTimeNS = endTime - startTime;
        double executionTimeMS = executionTimeNS / 1_000_000.0;

        System.out.println("\nTotal Number of Elements :- " + num);
        System.out.println("Execution Time :- ");
        System.out.println("Nanoseconds :- " + executionTimeNS + " ns");
        System.out.println("Milliseconds :- " + executionTimeMS + " ms");
    }
}
