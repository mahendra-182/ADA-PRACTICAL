import java.util.Scanner;

public class PR11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of matrices: ");
        int n = scanner.nextInt();

        int[] p = new int[n + 1];

        System.out.println("Enter the " + (n + 1) + " dimensions:");
        for (int i = 0; i <= n; i++) {
            p[i] = scanner.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int L = 2; L <= n; L++) {
            for (int i = 1; i <= n - L + 1; i++) {
                int j = i + L - 1;
                
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + (p[i - 1] * p[k] * p[j]);

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        System.out.println("\nMinimum number of multiplications is: " + dp[1][n]);
        
        scanner.close();
    }
}
