package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 일로만들기2최적화_12852 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 3];
        int[] graph = new int[n + 3];


        // Solution
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 0;

        // 최솟값 구하기
        for(int i = 2; i <= n; i++){


            dp[i] = dp[i - 1] + 1;
            graph[i] = i - 1;

            if(i % 3 == 0){
                if(dp[i / 3] + 1 < dp[i]) graph[i] = i / 3;
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
            if(i % 2 == 0){
                if(dp[i / 2] + 1 < dp[i]) graph[i] = i / 2;
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }




        }

        graph[2] = 1;

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append('\n');

        int point = n;

        while(point != 0){
            sb.append(point).append(" ");

            point = graph[point];
        }


        System.out.println(sb);

    }

}
