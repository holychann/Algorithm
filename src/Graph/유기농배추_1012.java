package src.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추_1012 {

    static boolean[][] graph;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int m, n, k;

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            StringTokenizer setter = new StringTokenizer(br.readLine());

            // m: 가로길이, n: 세로길이, k: 배추의 위치 개수
            m = Integer.parseInt(setter.nextToken());
            n = Integer.parseInt(setter.nextToken());
            k = Integer.parseInt(setter.nextToken());

            graph = new boolean[n][m];

            for(int i = 0; i < k; i++){
                StringTokenizer position = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(position.nextToken());
                int y = Integer.parseInt(position.nextToken());

                graph[y][x] = true;
            }

            // Solution

            int count = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(graph[i][j] == true){
                        count++;
                        solution_dfs(j, i);
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }

    static void solution_dfs(int x, int y){

        graph[y][x] = false;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < m && ny >= 0 && ny < n && graph[ny][nx]){
                solution_dfs(x + dx[i], y + dy[i]);
            }
        }

    }


    static void solution_bfs(int x, int y){

        queue.clear();

        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            int node_x = node[0];
            int node_y = node[1];

            graph[node_y][node_x] = false;

            // 상하좌우 확인
            for(int i = 0; i < 4; i++){
                int new_x = node_x + dx[i];
                int new_y = node_y + dy[i];

                if(new_x >= 0 && new_x < m && new_y >= 0 && new_y < n){
                    if(graph[new_y][new_x] == true){
                        queue.add(new int[]{new_x, new_y});
                    }
                }
            }

        }

    }
}
