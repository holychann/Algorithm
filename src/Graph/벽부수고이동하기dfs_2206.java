package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기dfs_2206 {

    static int result;
    static int[][] graph;

    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: y, M: x
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        // graph 입력
        for (int i = 0; i < N; i++) {
            String node = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = node.charAt(j) - '0';
            }
        }


        result = 2147483647;

        dfs(0, 0, 1, 0);


        if(result == 2147483647){
            System.out.println(-1);
        } else {
            System.out.println(result);
        }


    }


    static void dfs(int x, int y, int w, int isBreak){




        if(x == M - 1&& y == N - 1){
            result = Math.min(result, w);
        }

        // dfs: behavior
        // 상
        if(y > 0){
            if(graph[y - 1][x] == 0){
                graph[y - 1][x] = 2;
                dfs(x, y - 1, w + 1, isBreak);
                graph[y - 1][x] = 0;
            } else if(graph[y - 1][x] == 1 && isBreak == 0){
                graph[y - 1][x] = 2;
                dfs(x, y - 1, w + 1, 1);
                graph[y - 1][x] = 1;
            }
        }
        // 하
        if(y < graph.length - 1){
            if(graph[y + 1][x] == 0){
                graph[y + 1][x] = 2;
                dfs(x, y + 1, w + 1, isBreak);
                graph[y + 1][x] = 0;
            } else if(graph[y + 1][x] == 1 && isBreak == 0){
                graph[y + 1][x] = 2;
                dfs(x, y + 1, w + 1, 1);
                graph[y + 1][x] = 1;
            }
        }
        // 좌
        if(x > 0){
            if(graph[y][x - 1] == 0){
                graph[y][x - 1] = 2;
                dfs(x - 1, y, w + 1, isBreak);
                graph[y][x - 1] = 0;
            } else if(graph[y][x - 1] == 1 && isBreak == 0){
                graph[y][x - 1] = 2;
                dfs(x - 1, y, w + 1, 1);
                graph[y][x - 1] = 1;
            }
        }
        // 우
        if(x < graph[y].length - 1){
            if(graph[y][x + 1] == 0){
                graph[y][x + 1] = 2;
                dfs(x + 1, y, w + 1, isBreak);
                graph[y][x + 1] = 0;
            } else if(graph[y][x + 1] == 1 && isBreak == 0){
                graph[y][x + 1] = 2;
                dfs(x + 1, y, w + 1, 1);
                graph[y][x + 1] = 1;
            }
        }


    }

}
