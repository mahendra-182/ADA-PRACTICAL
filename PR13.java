import java.util.Scanner;

public class PR13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = scanner.nextLine();

        System.out.print("Enter second string: ");
        String s2 = scanner.nextLine();

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println("Length of SCS: " + dp[m][n]);

        StringBuilder sb = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                sb.append(s1.charAt(i - 1));
                i--;
            } else {
                sb.append(s2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            sb.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(s2.charAt(j - 1));
            j--;
        }

        System.out.println("SCS: " + sb.reverse().toString());

        scanner.close();
    }
}
