package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 적록색약_10026 {
    static char[][] graph;
    static boolean[][] isVisited;
    static Queue<int[]> queue;
    static int block = 0;
    static int[][] blockArr;
    static int[] x = {0, 0, -1, 1};
    static int[] y = {-1, 1, 0, 0};
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];

        isVisited = new boolean[N][N];

        blockArr = new int[N][N];

        queue = new LinkedList<>();

        // graph 초기화 - 일반
        for(int i = 0; i < N; i++){
            String colors = br.readLine();
            for(int j = 0; j < N; j++){
                graph[i][j] = colors.charAt(j);
            }
        }

        // for normal
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(isVisited[i][j]) continue;

                bfs(i, j);

            }
        }

        // graph 초기화 - 색약
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(graph[i][j] == 'G') {
                    graph[i][j] = 'R';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(block).append(" ");

        // 변수 초기화
        isVisited = new boolean[N][N];
        blockArr = new int[N][N];
        queue.clear();
        block = 0;

        // for green
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(isVisited[i][j]) continue;

                bfs(i, j);

            }
        }

        sb.append(block);

        System.out.println(sb);




    }

    static void bfs(int i, int j){

        char compare = graph[i][j];

        isVisited[i][j] = true;

        queue.add(new int[] {i, j});

        block++;

        while(!queue.isEmpty()){

            int[] place = queue.remove();

            char c = graph[place[0]][place[1]];

            blockArr[place[0]][place[1]] = block;

            for(int k = 0; k <4; k++){
                int dx = place[1] + x[k];
                int dy = place[0] + y[k];

                if(dx >= 0 && dy >= 0 && dx < N && dy < N && !isVisited[dy][dx] && graph[dy][dx] == compare){
                    isVisited[dy][dx] = true;
                    queue.add(new int[] {dy, dx});
                }
            }


        }

    }

}
