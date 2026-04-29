import java.util.*;

public class PR4 {
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

    public static void merge(int arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
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
            mergeSort(arr, 0, num - 1);
            long endTime = System.nanoTime();
            System.out.print("Sorted Array :- ");
            Array(arr, num);
        }
        long startTime = System.nanoTime();
        mergeSort(arr, 0, num - 1);
        long endTime = System.nanoTime();

        long executionTimeNS = endTime - startTime;
        double executionTimeMS = executionTimeNS / 1_000_000.0;

        System.out.println("\nTotal Number of Elements :- " + num);
        System.out.println("Execution Time :- ");
        System.out.println("Nanoseconds :- " + executionTimeNS + " ns");
        System.out.println("Milliseconds :- " + executionTimeMS + " ms");
    }
}
