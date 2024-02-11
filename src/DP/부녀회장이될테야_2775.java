package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 부녀회장이될테야_2775 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] input = new int[n][2];

        for(int i = 0; i < n; i++){
            input[i][0] = Integer.parseInt(br.readLine());
            input[i][1] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[15][15];

        // dp 기본값
        for(int i = 1; i <= 14; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i <= 14; i++){

            for(int j = 1; j <= 14; j++){
                if(j == 1){
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

        }

        for(int el[] : input){
            int k = el[0];
            int i = el[1];

            int data = dp[k][i];

            sb.append(data).append('\n');

        }

        System.out.println(sb);


    }
}
