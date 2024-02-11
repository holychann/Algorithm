package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합_1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];


        // Main

        int answer = dp[0];

        for(int i = 1; i < N; i++){
            if(dp[i - 1] < 0){
                dp[i] = arr[i];
                answer = Math.max(dp[i], answer);
                continue;
            }
            dp[i] = dp[i - 1] + arr[i];
            answer = Math.max(dp[i], answer);

        }

        System.out.println(answer);

    }
}
