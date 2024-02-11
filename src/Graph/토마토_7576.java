package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // M: 가로칸 수, N: 세로칸 수
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 그래프 배열
        int[][] graph = new int[N][M];

        // BFS
        Queue<int[]> queue = new LinkedList<>();

        // 그래프: 입력
        for(int i = 0; i < N; i++){
            StringTokenizer nodes = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(nodes.nextToken());
                if(graph[i][j] == 1){
                    int[] node = {j, i, 0};
                    queue.add(node);
                }
            }
        }


        int day = 0;

        // Solution

        while(!queue.isEmpty()){

            // queue POP()
            int[] node = queue.remove();

            int x = node[0];
            int y = node[1];
            int d = node[2];

            day = Math.max(day, d);

            // queue 등록
            // 상
            if(y - 1 >= 0){
                if(graph[y - 1][x] == 0){
                    graph[y - 1][x] = 1;
                    int[] next = {x, y - 1, d + 1};
                    queue.add(next);
                }
            }
            // 하
            if(y + 1 < graph.length){
                if(graph[y + 1][x] == 0){
                    graph[y + 1][x] = 1;
                    int[] next = {x, y + 1, d + 1};
                    queue.add(next);
                }

            }
            // 좌
            if(x - 1 >= 0){
                if(graph[y][x-1] == 0){
                    graph[y][x - 1] = 1;
                    int[] next = {x - 1, y, d + 1};
                    queue.add(next);
                }

            }
            // 우
            if(x + 1 < graph[y].length){
                if(graph[y][x + 1] == 0){
                    graph[y][x + 1] = 1;
                    int[] next = {x + 1, y, d + 1};
                    queue.add(next);
                }

            }

        }

        // true: 정상, false: 비정상
        boolean result = true;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(graph[i][j] == 0){
                    result = false;
                    break;
                }
            }
        }

        if(result){
            System.out.println(day);
        } else {
            System.out.println(-1);
        }



    }
}
