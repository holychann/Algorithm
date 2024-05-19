package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리_1149 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 현재 층
        int f = 1;

        while(f <= n){
            for(int i = 0; i < 3; i++){
                long min = Integer.MAX_VALUE;
                for(int j = 0; j < 3; j++){
                    if(i == j) continue;
                    min = arr[f - 1][j] < min ? arr[f - 1][j] : min;
                }
                arr[f][i] += min;
            }

            f++;
        }

        long result = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            result = arr[n][i] < result ? arr[n][i] : result;
        }

        System.out.println(result);

    }
}
