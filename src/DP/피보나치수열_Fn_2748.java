package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.StringTokenizer;

public class 피보나치수열_Fn_2748 {

    public static long[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        dp = new long[n + 1];

        dp[0] = 0l;
        dp[1] = 1l;

        long data = getFibonacci(n);

        System.out.println(data);


    }

    public static long getFibonacci(int n) {
        if(n == 1) return 1l;
        if(n == 0) return 0l;
        if(dp[n] > 0) {
            return dp[n];
        }

        dp[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        return dp[n];
    };


}
