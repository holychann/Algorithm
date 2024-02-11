package src.Figures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 통계학_2108 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 숫자 개수
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        int sum_all = 0;
        int[] location = new int[8002];
        int max = -4001;
        int min = 2147483647;

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            // 수 할당
            arr[i] = num;
            // 모든 수의 합
            sum_all += num;
            // 최빈수를 위한 배열 설정
            int loc_index = num + 4000;
            location[loc_index] += 1;
            // 범위를 위한 최댓값
            max = Math.max(max, num);
            // 범위를 위한 최솟값
            min = Math.min(min, num);
        }



        sb.append(Math.round((double) sum_all / n)).append('\n');

        Arrays.sort(arr);

        sb.append(arr[(int) Math.floor(n / 2)]).append('\n');

        int location_max = 0;
        int index = 0;

        for(int i = 0; i < location.length; i++){
            if(location[i] > location_max){
                index = i;
            }
            location_max = Math.max(location_max, location[i]);


        }


        ArrayList<Integer> location_out = new ArrayList<>();

        for(int i = index; i < location.length; i++){
            if(location[i] == location_max){
                location_out.add(i);
            }
        }

        if(location_out.size() >= 2){
            sb.append(location_out.get(1) - 4000).append('\n');
        } else {
            sb.append(index - 4000).append('\n');
        }

        sb.append(max - min);


        System.out.println(sb);

    }
}
