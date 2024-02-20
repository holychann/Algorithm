package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막길_1520 {

    static int[][] graph;
    static int n, m;
    static int[] x_move = new int[] {0, 0, 1, -1};
    static int[] y_move = new int[] {-1, 1, 0, 0};
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로: n, 세로: m
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[m][n];

        dp = new int[m][n];


        for(int i = 0; i < m; i++){
            StringTokenizer node = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
                graph[i][j] = Integer.parseInt(node.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(dp[0][0]);


    }

    static int dfs(int y, int x){
        if(x == n - 1 && y == m - 1) {
            return 1;
        }

        if(dp[y][x] != -1){
            return dp[y][x];
        } else{
            dp[y][x] = 0;

            for(int i = 0; i < 4; i++){
                int nx = x + x_move[i];
                int ny = y + y_move[i];

                if(nx >= 0 && ny >= 0 && nx < graph[0].length && ny < graph.length && graph[ny][nx] < graph[y][x]){
                    dp[y][x] += dfs(ny, nx);
                }

            }
        }

        return dp[y][x];

    }
}
