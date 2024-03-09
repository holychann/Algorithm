package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {

    static int[] dx = new int[] {0, 0, 1, -1};
    static int[] dy = new int[] {1, -1, 0, 0};
    static int[] dh = new int[] {1, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // *input*

        int m, n, h;

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int[][][] graph = new int[h][n][m];

        // node: {y, x, h}
        Queue<int[]> queue = new LinkedList<>();

        for(int k = 0; k < h; k++){
            for(int i = 0; i < n; i++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++){
                    int tomato = Integer.parseInt(line.nextToken());
                    if(tomato == 1){
                        queue.add(new int[] {i, j, k, 1});
                    }
                    graph[k][i][j] = tomato;
                }
            }
        }


        // *Solution*

        int day = 0;

        while(!queue.isEmpty()){

            // {y, x, h, d}
            int[] popped = queue.poll();

            day = Math.max(day, popped[3]);


            for(int i = 0; i < 4; i++){
                int nx = popped[1] + dx[i];
                int ny = popped[0] + dy[i];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if(graph[popped[2]][ny][nx] == 0){
                        graph[popped[2]][ny][nx] = 1;
                        queue.add(new int[] {ny, nx, popped[2], popped[3] + 1});
                    }
                }

            }

            for(int i = 0; i < 2; i++){
                int nh = popped[2] + dh[i];

                if(nh >= 0 && nh < h){
                    if(graph[nh][popped[0]][popped[1]] == 0){
                        graph[nh][popped[0]][popped[1]] = 1;
                        queue.add(new int[] {popped[0], popped[1],nh, popped[3] + 1});
                    }
                }
            }

        }

        boolean result = true;

        for(int k = 0; k < h; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if (graph[k][i][j] == 0){
                        result = false;
                    }
                }
            }
        }

        if(!result){
            System.out.println(-1);
        } else {
            System.out.println(day - 1);
        }



    }
}
