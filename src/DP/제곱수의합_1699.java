package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 제곱수의합_1699 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 3];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[2] = 2;
        dp[3] = 3;

        // 초기값 설정
        for(int i = 1; i * i <= n; i++){
            dp[i * i] = 1;
        }


        // Solution
        for(int i = 2; i * i <= n; i++){
            for(int j = i * i; j <= n; j++){
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }

        System.out.println(dp[n]);


    }
}
