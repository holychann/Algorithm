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
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // N이 1인 경우에는 결과를 0으로 출력하고 종료
        if (n < 2) {
            System.out.println(0);
            return;
        }

        // 정렬
        Arrays.sort(nums);

        int left = 0;
        int right = 1;
        long result = Long.MAX_VALUE;

        // 투 포인터 알고리즘
        while (right < n) {
            int diff = nums[right] - nums[left];  // 두 수의 차이 계산

            if (diff >= m) {
                result = Math.min(result, diff);  // 차이가 m 이상일 때 최솟값 갱신
                left++;  // left 포인터 이동

                // left가 right와 같아지면 right도 증가시킴
                if (left == right) {
                    right++;
                }
            } else {
                right++;  // 차이가 m 미만일 때 right 포인터 이동
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
