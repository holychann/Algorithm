package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 이친수_2193 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 2];

        dp[1] = 1;
        dp[2] = 1;

        if(n >= 3){
            for(int i = 3; i <= n; i++){

                dp[i] = dp[i - 1] + dp[i - 2];
            }

        }

        System.out.println(dp[n]);

    }
}

