import java.util.*;
class PR6 {
    public static int linearSearch(int[] arr, int tar, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == tar) return i;
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int tar, int n) {
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == tar) {
                return m;
            }
            if (arr[m] < tar) {
                l = m + 1;
            } else {
                r = m - 1; 
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        System.out.print("Enter Total Number of Elements :- ");
        int n = SC.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + " :- ");
            arr[i] = SC.nextInt(); 
        }
        System.out.print("\nArray :-  ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\nEnter the Target :- ");
        int tar = SC.nextInt();
        System.out.println("\n1 - LinearSearch\n2 - BinarySearch\n ");
        System.out.print("\nSelect the Searching Method (1 / 2) :- ");
        int search = SC.nextInt();
        if(search == 1) {
            int result = linearSearch(arr, tar, n);
            if (result != -1)
                System.out.println("Target found at index: " + result);
            else
                System.out.println("Target not found!");
        }
        else if(search == 2){
            int result = binarySearch(arr, tar, n);
            if (result != -1)
                System.out.println("Target found at index: " + result);
            else
                System.out.println("Target not found!");
        }
        else {
            System.out.println("Select 1 OR 2 ONLY !!!");
        }
    }
}
