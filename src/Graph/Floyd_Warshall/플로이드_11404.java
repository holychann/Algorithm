package src.Graph.Floyd_Warshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드_11404 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] dist = new int[N + 1][N + 1];

        // 모든 값 2^31 - 1 로 설정
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                dist[i][j] = 1000000000;
                if(i == j) dist[i][j] = 0;
            }
        }

        // 초기값 설정
        for(int i = 1; i <= M; i++){
            StringTokenizer bus = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(bus.nextToken());
            int to = Integer.parseInt(bus.nextToken());
            int weight = Integer.parseInt(bus.nextToken());

            dist[from][to] = Math.min(weight, dist[from][to]);
        }

        for(int i = 1; i <= N; i++){  // 중간노드
            for(int j = 1; j <= N; j++){  //
                for(int k = 1; k <= N; k++){

                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);

                }
            }
        }

        StringBuilder sb = new StringBuilder();


        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){

                if(dist[i][j] < 1000000000) {
                    sb.append(dist[i][j]).append(" ");
                } else {
                    sb.append(0).append(" ");
                }


            }
            sb.append('\n');
        }

        System.out.println(sb);



    }
}
