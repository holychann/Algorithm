package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안전영역_2468 {

    static int[][] graph;
    static boolean[][] isVisited;
    static int[] dx = new int[] {0, 0, 1, -1};
    static int[] dy = new int[] {1, -1, 0, 0};

    static int n, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        max = 0;

        graph = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
                max = Math.max(max, num);
            }
        }

        int answer = 0;

        for(int m = 0; m <= max; m++){
            int result = 0;
            isVisited = new boolean[n][n];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(graph[i][j] <= m || isVisited[i][j]) continue;

                    dfs(i, j, m);
                    result++;

                }
            }

            answer = Math.max(answer, result);
        }



        System.out.println(answer);


    }

    static void dfs(int y, int x, int m){
        isVisited[y][x] = true;

        for(int i = 0; i < 4; i++){
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newX >= 0 && newY >= 0 && newX < n && newY < n){
                if(graph[newY][newX] > m && !isVisited[newY][newX]) dfs(newY, newX, m);
            }
        }
    }


}
