package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 오르막수_11057 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][10];

        for(int i = 0; i < 10; i++){
             dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++){
            dp[i][9] = 1;
            for(int j = 8; j >= 0; j--){
                dp[i][j] = (dp[i][j + 1] + dp[i - 1][j]) % 10007;
            }
        }


        int count = 0;

        for(int el : dp[n]){
            count += el;
        }

        count %= 10007;


        System.out.println(count);


    }
}
