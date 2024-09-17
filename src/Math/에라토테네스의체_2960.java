package src.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 에라토테네스의체_2960 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * 첫째 줄에 N과 K가 주어진다. (1 ≤ K < N, max(1, K) < N ≤ 1000)
         */
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        for(int i = 1; i <= n; i++){
            arr[i] = i;
        }

        boolean isDone = false;

        for(int i = 2; i <= n; i++){
            if(arr[i] == 0) continue;
            for(int j = i; j <= n; j ++){
                if(arr[j] == 0) continue;
                if(arr[j] % i == 0){
                    k--;
                    if(k == 0){
                        System.out.println(arr[j]);
                        isDone = true;
                        break;
                    }
                    arr[j] = 0;
                }
            }
            if(isDone) break;
        }


    }
}
