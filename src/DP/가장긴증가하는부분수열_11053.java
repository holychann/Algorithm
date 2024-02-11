package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열_11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // INPUT
        int n = Integer.parseInt(br.readLine());

        // 원본 배열
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        // SOLUTION
        int[] dp = new int[n];

        // 모든 dp의 인덱스를 1로 초기화
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }

        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){

                if(arr[i] < arr[j]){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }

                max = Math.max(max, dp[j]);
            }
        }

        System.out.println(max);



    }

}
