package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class 일로만들기2_12852 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 3];
        List<Integer>[] graph = new List[n + 3];


        for(int i = 1; i <= n + 2; i++){
            graph[i] = new ArrayList<>();
        }

        // Solution
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 0;

        // 최솟값 구하기
        for(int i = 2; i <= n; i++){


            dp[i] = dp[i - 1] + 1;
            graph[i].add(i);
            graph[i].add(0, i - 1);

            if(i % 3 == 0){
                if(dp[i / 3] + 1 < dp[i]) graph[i].set(0, i / 3);
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
            if(i % 2 == 0){
                if(dp[i / 2] + 1 < dp[i]) graph[i].set(0, i / 2);
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }




        }

        if(n < 2){
            graph[2].add(2);
            graph[2].add(0, 1);
        }
        graph[2].set(0, 1);

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append('\n');
        sb.append(n).append(" ");

        int pointer;

        for(int i = n; i >= 2;){

            pointer = graph[i].get(0);

            sb.append(pointer).append(" ");

            i = pointer;
        }


        System.out.println(sb);

    }

}
