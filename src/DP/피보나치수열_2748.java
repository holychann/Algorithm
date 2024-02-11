package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.StringTokenizer;

public class 피보나치수열_2748 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[91];

        dp[0] = 0l;
        dp[1] = 1l;

        for(int i = 2; i <= 90; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        long data = dp[n];

        sb.append(data).append('\n');

        System.out.println(sb);



    }
}
