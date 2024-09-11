package src.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기_2230 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer setting = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(setting.nextToken());
        int m = Integer.parseInt(setting.nextToken());

        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(nums);

        int left = 0;
        int right = 1;

        long result = Long.MAX_VALUE;

        while(right < n && left < right){
            long diff = nums[right] - nums[left];
            if(diff >= m){
                result = Math.min(result, diff);
                left++;
            } else {
                right++;
            }
        }

        if(n < 2){
            System.out.println(0);
        } else {
            System.out.println(result);
        }



    }
}
