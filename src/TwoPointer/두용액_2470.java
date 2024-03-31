package src.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액_2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        int value_l = 0;
        int value_r = 0;

        int result = Integer.MAX_VALUE;

        while(left < right){

            int sum = arr[left] + arr[right];

            if(Math.abs(result) > Math.abs(sum)){
                result = sum;
                value_l = arr[left];
                value_r = arr[right];
            }

            if(sum > 0){
                right --;
            } else {
                left ++;
            }

        }

        StringBuilder sb = new StringBuilder();

        if(value_l >= value_r){
            sb.append(value_r).append(" ").append(value_l);
        } else {
            sb.append(value_l).append(" ").append(value_r);
        }

        System.out.println(sb);


    }
}
