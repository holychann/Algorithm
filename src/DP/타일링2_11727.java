package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 타일링2_11727 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 3];

        dp[1] = 1;
        dp[2] = 3;


        for(int i = 3; i <= N; i++){
            dp[i] = ((dp[i - 2] * 2) + dp[i - 1]) % 10007;
        }

        System.out.println(dp[N]);


    }
}
