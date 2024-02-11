package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭_12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 처리
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        for(int i = 1; i <= n; i++){
            StringTokenizer item = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(item.nextToken());
            v[i] = Integer.parseInt(item.nextToken());
        }


        int[][] dp = new int[n + 1][k + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){

                if(j - w[i] < 0) {

                    dp[i][j] = dp[i - 1][j];

                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);

            }
        }

        System.out.println(dp[n][k]);

    }

}
