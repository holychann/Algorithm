package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        int[][] stikers;
        int[][] dp;


        // TestCase
        for(int i = 1; i <= t; i++){

            // ------Input------
            int n = Integer.parseInt(br.readLine());

            stikers = new int[n + 1][2];
            dp = new int[n + 1][2];


            // 첫째 줄 Input
            StringTokenizer st_firstLine = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                stikers[j][0] = Integer.parseInt(st_firstLine.nextToken());
            }
            // 둘째 줄 Input
            StringTokenizer st_secondeLine = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                stikers[j][1] = Integer.parseInt(st_secondeLine.nextToken());
            }


            // ------Solution------

            // dp 초기값 설정
            dp[1][0] = stikers[1][0];
            dp[1][1] = stikers[1][1];


            for(int j = 2; j <= n; j++){
                dp[j][0] = stikers[j][0] +  Math.max(dp[j - 1][1], dp[j - 2][1]);
                dp[j][1] = stikers[j][1] +  Math.max(dp[j - 1][0], dp[j - 2][0]);
            }

            sb.append(Math.max(dp[n][0], dp[n][1])).append('\n');

        }

        System.out.println(sb);

    }
}
