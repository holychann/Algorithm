package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쉬운계단수_10844 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // dp[자리수][으로 끝나는 수] = 개수
        int[][] dp = new int[n + 1][10];

        // 한 자리 수에 대한 로직
        for(int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }

        // 마지막 숫자가 0인 경우 이전 숫자가 무조건 1이어야 함.
        // 마지막 숫자가 9인 경우 이전 숫자가 무조건 8이어야함.

        // 두 자리 수 이상에 대한 로직
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < 10; j++){
                if(j == 0) {
                    dp[i][j] = dp[i - 1][1] % 1000000000;
                } else if(j == 9) {
                    dp[i][j] = dp[i - 1][8] % 1000000000;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }

        // 큰 수의 el 들의 값들을 더하면 (2^31 - 1)을 넘어갈 수 있으므로 long 타입으로 선언
        long result = 0;
        for(int el : dp[n]){
            result += el;
        }

        System.out.println(result % 1000000000);

    }
}
