package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 설탕배달_2839 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        for(int i = 3; i <= n; i++){
            if(i == 3 || i == 5) {
                dp[i] = 1;
                continue;
            } else if(i == 4 || i == 7){
                dp[i] = -1;
                continue;
            }
            if(dp[i - 5] > 0){
                dp[i] = dp[i - 5] + 1;
            } else if(dp[i - 3] > 0){
                dp[i] = dp[i - 3] + 1;
            }

        }

        System.out.println(dp[n]);

    }
}
