package src.DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분합_1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        StringTokenizer nums = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(nums.nextToken());
        }

        int left = 0;
        int right = 0;

        int answer = 100001;

        int sum = arr[0];

        while(left <= right){

            if(sum < S && right < N - 1) {
                sum += arr[++right];

            } else {
                if(sum >= S){
                    answer = Math.min(answer, right - left + 1);
                }
                sum -= arr[left++];
            }

        }

        if (answer == 100001){
            System.out.println(0);
        } else {
            System.out.println(answer);
        }




    }
}

