package nowcoder.Codes;

import java.util.Scanner;

/**
 * Created by lijingwei on 2017/8/24.
 */
public class NumSum {

    static int num = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }

        System.out.println(dpSolve(A, sum));
//        System.out.println(solve(A, sum));
    }

    //回溯
    private static int solve(int[] a, int sum) {
        backtrack(a, 0, sum);
        return num;
    }

    private static void backtrack(int[] a, int start, int remain) {
        if (remain < 0) return;
        if (remain == 0) {
            num++;
            return;
        }
        for (int i = start; i < a.length; i++) {
            backtrack(a, i + 1, remain - a[i]);
        }
    }

    //DP
    private static long dpSolve(int[] a, int sum) {
        long[][] dp = new long[a.length + 1][1001];
        if (a[0] <= 1000) dp[1][a[0]]++;
        for (int i = 2; i <= a.length; i++) {
            for (int j = 1; j <= 1000; j++) {
                dp[i][j]=dp[i-1][j];
            }
            for (int j = 1; j <= 1000; j++) {
                if (dp[i - 1][j] != 0 && j + a[i - 1] <= 1000) {
                    dp[i][j + a[i - 1]] += dp[i - 1][j];
                }
            }
            if (a[i - 1] <= 1000) dp[i][a[i - 1]]++;
        }
        return dp[a.length][sum];
    }

}
