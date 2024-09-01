package src.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        long[] nums = new long[n];
        long[] answer = new long[3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        long result = Long.MAX_VALUE;

        // Solution
        for(int i = 0; i < n; i++){

            boolean isEnd = false;

            if(isEnd){
                break;
            }

            int left = 0;
            int right = n - 1;

            while(left < right && !isEnd){
                if(right == i) right--;
                if(left == i) left++;
                if(left == right) break;
                long sum = nums[i] + nums[left] + nums[right];

                if(Math.abs(sum) < Math.abs(result)){
                    result = sum;

                    answer[0] = nums[i];
                    answer[1] = nums[right];
                    answer[2] = nums[left];
                }

                // 합이 0 보다 클 경우 right 포인터를 움직여 합을 줄인다.
                if(sum > 0){
                    right--;
                } else if(sum < 0){
                    left++;
                } else if(sum == 0){
                    answer[0] = nums[i];
                    answer[1] = nums[right];
                    answer[2] = nums[left];

                    isEnd = true;
                }
            }

        }

        Arrays.sort(answer);

        sb.append(answer[0]).append(' ').append(answer[1]).append(' ').append(answer[2]);

        System.out.println(sb);






    }
}
