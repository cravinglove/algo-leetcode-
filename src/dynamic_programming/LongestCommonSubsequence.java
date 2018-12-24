package dynamic_programming;

public class LongestCommonSubsequence {
    /*public static int LengthOfLCS(char[] X, char[] Y, int m, int n, int[][] seen) {
        if(m == 0 || n == 0) return 0;
        if(seen[m][n] != 0) return seen[m][n];
        if(X[m - 1] == Y[n - 1])
            seen[m][n] = LengthOfLCS(X, Y, m - 1, n - 1, seen) + 1;
        else seen[m][n] = Math.max(LengthOfLCS(X, Y, m - 1, n, seen), LengthOfLCS(X, Y, m, n - 1, seen));
        return seen[m][n];
    }
*/


    public static int lengthOfLCS(char[] X, char[] Y, int m, int n) {
        if(m == 0 || n == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
                else if(X[i - 1] == Y[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "GTAB";
        String s2 = "GTAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lengthOfLCS( X, Y, m, n ) );
    }
}
