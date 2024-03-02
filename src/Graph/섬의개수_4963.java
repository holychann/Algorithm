package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬의개수_4963 {

    static int[][] graph;
    static boolean[][] isVisited;

    static int[] dx = new int[] {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = new int[] {1, -1, 0, 0, -1, 1, -1, 1};

    static int w, h;

    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while(1 == 1){
            StringTokenizer st = new StringTokenizer(br.readLine());

            result = 0;

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            graph = new int[h][w];
            isVisited = new boolean[h][w];

            for(int i = 0; i < h; i++){
                StringTokenizer nums = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    graph[i][j] = Integer.parseInt(nums.nextToken());
                }
            }

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(graph[i][j] == 0 || isVisited[i][j]) continue;

                    dfs(i, j);

                    result++;
                }
            }

            sb.append(result).append('\n');


        }

        System.out.println(sb);
    }

    static void dfs(int y, int x){
        isVisited[y][x] = true;

        for(int i = 0; i < 8; i++){
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newX >= 0 && newY >= 0 && newX < w && newY < h){
                if(graph[newY][newX] == 1 && !isVisited[newY][newX]){
                    dfs(newY, newX);
                }
            }
        }
    }
}
