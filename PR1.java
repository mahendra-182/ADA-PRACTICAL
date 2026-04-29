import java.util.*;

public class PR1 {
    public static void InsertElements(int arr[], int num) {
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

    public static void SelectionSort(int arr[], int num) {
        int minIndex, temp;
        for (int i = 0; i < num - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < num; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
     Scanner SC = new Scanner (System.in);
        System.out.print("Total Number of Elements :- ");
        int num = SC.nextInt();
        int arr[] = new int[num];
        InsertElements(arr, num);

        if (num <= 20) {
            System.out.print("UnSorted Array :- ");
            Array(arr, num);
            long startTime = System.nanoTime();
            SelectionSort(arr, num);
            long endTime = System.nanoTime();
            System.out.print("Sorted Array :- ");
            Array(arr, num);
        }
        long startTime = System.nanoTime();
        SelectionSort(arr, num);
        long endTime = System.nanoTime();
        
        long executionTimeNS = endTime - startTime;
        double executionTimeMS = executionTimeNS / 1_000_000.0;

        System.out.println("Execution Time :- ");
        System.out.println("Nanoseconds :- " + executionTimeNS + " ns");
        System.out.println("Milliseconds :- " + executionTimeMS + " ms");
    }
}
