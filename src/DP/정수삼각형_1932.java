package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형_1932 {




    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[502][502];
        int[][] dp = new int[502][502];


        for(int i = 1; i <= n; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        int maxVelue = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){

                if(j == i && j != 1) break;

                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + arr[i][j]);
                dp[i][j + 1] = dp[i - 1][j] + arr[i][j + 1];

                int compare1 = dp[i][j];
                int compare2 = dp[i][j + 1];

                if(compare1 > maxVelue || compare2 > maxVelue){
                    maxVelue = Math.max(compare1, compare2);
                }



            }
        }

        System.out.println(maxVelue);



    }

}
