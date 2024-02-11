package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴감소하는부분수열_11722 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        // 배열 arr에 입력값을 저장
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = 0;

        for(int i = arr.length - 1; i >= 0; i--){
            for(int j = arr.length - 1; j >= i; j--){

                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }


            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);


    }
}
