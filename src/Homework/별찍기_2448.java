package src.Homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 별찍기_2448 {
    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new char[n][2 * n - 1];

        // 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                arr[i][j] = ' ';
            }
        }

        // 메서드 실행
        solution(0, n - 1, n);

        StringBuilder sb = new StringBuilder();

        //
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }


    // 별 찍기 재귀 함수
    static void solution(int x, int y, int n) {

        // 탈출부분(Base case)
        if (n == 3) {
            arr[x][y] = '*';
            arr[x + 1][y - 1] = '*';
            arr[x + 1][y + 1] = '*';
            arr[x + 2][y - 2] = '*';
            arr[x + 2][y - 1] = '*';
            arr[x + 2][y] = '*';
            arr[x + 2][y + 1] = '*';
            arr[x + 2][y + 2] = '*';
            return;
        }

        int ns = n / 2;

        // 재귀부분(Recursive Case)
        // 상단 삼각형
        solution(x, y, ns);

        // 왼쪽 하단 삼각형
        solution(x + ns, y - ns, ns);

        // 오른쪽 하단 삼각형
        solution(x + ns, y + ns, ns);
    }
}
