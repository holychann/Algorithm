package src.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        // 입력
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // sorting
        Arrays.sort(arr);

        int count = 0;

        // Solution
        for(int i = 0; i < n; i++){
            int p1 = 0;
            int p2 = n - 1;

            while(p1 < p2){
                if(p1 == i) p1++;
                if(p2 == i) p2--;

                int sum = arr[p1] + arr[p2];

                if(sum == arr[i]) {
                    count++;
                    break;
                }

                if(sum > arr[i]){
                    p2--;
                    if(p2 == i) p2--;
                } else if(sum < arr[i]){
                    p1++;
                    if(p1 == i) p1++;
                }
            }
        }

        System.out.println(count);


    }

}
