package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 피보나치함수_1003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] testCase = new int[N];

        // Input
        for(int i = 0; i < N; i++){
            testCase[i] = Integer.parseInt(br.readLine());
        }


        // Main

        // dp = [[0의 개수, 1의 개수]]
        int[][] dp = new int[41][2];

        dp[0][0] = 1;
        dp[1][1] = 1;


        for(int el : testCase){
            for(int i = 2; i <= el; i++){
                if(dp[i][0] == 0){
                    dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
                    dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
                }

            }

            sb.append(dp[el][0]).append(" ").append(dp[el][1]).append('\n');

        }

        System.out.println(sb);



    }
}
