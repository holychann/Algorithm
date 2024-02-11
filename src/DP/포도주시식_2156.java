package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 포도주시식_2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int n = Integer.parseInt(br.readLine());

        int[] alcohol = new int[n + 1];

        for(int i = 1; i <= n; i++){
            alcohol[i] = Integer.parseInt(br.readLine());
        }

        //Solution

        int[] dp = new int[n + 1];

        int max = 0;

        dp[1] = alcohol[1];

        if(n > 1){
            dp[2] = alcohol[1] + alcohol[2];
        }


        for(int i = 3; i <= n; i++){


            dp[i] = Math.max(dp[i - 3] + alcohol[i - 1] + alcohol[i], dp[i - 2] + alcohol[i]);
            dp[i] = Math.max(dp[i - 1], dp[i]);
            max = Math.max(max, dp[i]);

        }


        if(n == 1 || n == 2){
            System.out.println(dp[n]);
        } else {
            System.out.println(max);
        }


    }
}
