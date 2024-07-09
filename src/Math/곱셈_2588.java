package src.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱셈_2588 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 두 수 입력 받기
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        // B의 각 자릿수
        int B1 = B % 10;
        int B2 = (B / 10) % 10;
        int B3 = B / 100;

        // 각 자릿수 곱셈 결과 출력
        System.out.println(A * B1);
        System.out.println(A * B2);
        System.out.println(A * B3);

        // 최종 곱셈 결과 출력
        System.out.println(A * B);
    }
}
