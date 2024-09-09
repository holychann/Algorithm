package src.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액_2467 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;

        int[] ans = new int[2];

        int result = Integer.MAX_VALUE;

        while(left < right){

            int sum = nums[left] + nums[right];

            if(Math.abs(sum) < result){
                result = Math.abs(sum);
                ans[0] = nums[left];
                ans[1] = nums[right];
            }

            if(sum < 0){
                left++;
            } else if (sum > 0){
                right--;
            } else {
                break;
            }

        }

        StringBuilder sb = new StringBuilder();

        sb.append(ans[0]).append(" ").append(ans[1]);
        System.out.println(sb);

    }
}
