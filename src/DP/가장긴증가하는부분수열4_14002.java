package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열4_14002 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        int[] graph = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){

                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    if(dp[j] + 1 == dp[i]){
                        graph[i] = j;
                    }
                }

            }

            max = Math.max(max, dp[i]);
        }

        sb.append(max).append('\n');

        int max_index = 0;

        for(int i = 1; i <= n; i++){
            if(dp[i] == max){
                max_index = i;
            }
        }

        ArrayList<Integer> graph_result = new ArrayList<>();



        while(max_index != 0){
            graph_result.add(0, arr[max_index]);
            max_index = graph[max_index];
        }

        while(!graph_result.isEmpty()){
            sb.append(graph_result.remove(0)).append(" ");
        }

        System.out.println(sb);

    }
}
