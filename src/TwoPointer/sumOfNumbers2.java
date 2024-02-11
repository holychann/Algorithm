package src.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sumOfNumbers2 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        StringTokenizer numbers = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(numbers.nextToken());
        }


        int left = 0;
        int right = 1;

        int sum = 0;
        int count = 0;

        sum += arr[left] + arr[right];

        while(left <= right){


            if(right == N){

                if(sum == M) count++;

                sum -= arr[++left];


                if(right == left && right == N) break;

                continue;
            }

            if(sum == M) count++;

            if(sum <= M){
                sum += arr[++right];
            } else if(sum > M){
                sum -= arr[++left];
            }



        }

        System.out.println(count);


    }
}
