package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰증가하는부분수열_11055 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        // 배열 arr에 입력값을 저장
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i]; // dp 배열을 arr 배열의 값으로 초기화
        }

        int max = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                // arr[j]가 arr[i]보다 작은 경우에만 dp[i] 업데이트
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            // 최대값 갱신
            max = Math.max(dp[i], max);
        }

        // 최대값 출력
        System.out.println(max);
    }
}
