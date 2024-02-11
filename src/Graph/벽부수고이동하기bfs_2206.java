package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기bfs_2206 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: y, M: x
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        boolean[][][] isVisited = new boolean[N][M][2];
        // graph 입력
        for (int i = 0; i < N; i++) {
            String node = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = node.charAt(j) - '0';
            }
        }


        int result = -1;

        int[] start_node = {0, 0, 1, 0};

        isVisited[0][0][0] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};


        Queue<int[]> queue = new LinkedList<>();

        queue.add(start_node);

        while(!queue.isEmpty()){

            // queue: pop
            int[] popped = queue.remove();
            int x = popped[0];
            int y = popped[1];
            int w = popped[2];
            int isBreak = popped[3];


            if(x == M - 1 && y == N - 1){
                result = w;
                break;
            }

            // queue: behavior
            for(int i = 0; i < 4; i++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                if( nx >= 0 && ny >= 0 && nx < M && ny < N){

                    if(graph[ny][nx] == 0 && !isVisited[ny][nx][isBreak]){

                        queue.add(new int[]{nx, ny, w + 1, isBreak});
                        isVisited[ny][nx][isBreak] = true;
                    } else if(graph[ny][nx] == 1 && !isVisited[ny][nx][1] && isBreak == 0){

                        queue.add(new int[]{nx, ny, w + 1, 1});
                        isVisited[ny][nx][1] = true;
                    }

                }
            }

        }

        System.out.println(result);


    }

}
