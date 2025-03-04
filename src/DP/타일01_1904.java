package src.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일01_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        arr[0] = 1;
        if(n > 1){
            arr[1] = 2;

            for(int i = 2; i < n; i++){
                arr[i] = (arr[i-1] + arr[i-2])  % 15746;
            }
        }

        System.out.println(arr[n-1]);
    }
}
