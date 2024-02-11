package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산_2573 {
    static boolean[][] isVisited;
    static Queue<int[]> queue;
    static Queue<int[]> mainQueue;
    static int[] x = {0, 0, -1, 1};
    static int[] y = {-1, 1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];
        int[][] test = new int[N][M];

        int block = 0;

        ArrayList<int[]> zero = new ArrayList<>();

        mainQueue = new LinkedList<>();

        // Input
        for(int i = 0; i < N; i++){
            StringTokenizer ice = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int present = Integer.parseInt(ice.nextToken());
                grid[i][j] = present;
                if(present == 0) zero.add(new int[] {i, j});
            }
        }

        int answer = 0;

        while(block < 2){
            for(int i = 1; i < N - 1; i++){
                for(int j = 1; j < M - 1; j++){

                    if(grid[i][j] == 0) continue;

                    for(int k = 0; k < 4; k++){
                        int dx = j + x[k];
                        int dy = i + y[k];

                        if(grid[dy][dx] == 0 && grid[i][j] >= 1){
                            mainQueue.add(new int[] {i, j});
                        }
                    }

                }
            }

            while(!mainQueue.isEmpty()){
                int[] position = mainQueue.remove();

                if(grid[position[0]][position[1]] >= 1) grid[position[0]][position[1]] -= 1;
            }

            answer++;
            block = check(grid);

            if(block <= 0) break;
        }

        if(block == 0){
            System.out.println(0);
        } else {
            System.out.println(answer);
        }





    }

    static int check(int[][] grid){

        isVisited = new boolean[grid.length][grid[0].length];

        int result = 0;

        queue = new LinkedList<>();



        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                // 확인파트
                if(isVisited[i][j] || grid[i][j] == 0) continue;

                queue.add(new int[] {i, j});

                isVisited[i][j] = true;

                while(!queue.isEmpty()){

                    int[] node = queue.remove();

                    // i = a, j = b
                    int a = node[0];
                    int b = node[1];

                    for(int k = 0; k < 4; k++){
                        int dx = b + x[k];
                        int dy = a + y[k];

                        if(dx > 0 && dy > 0 && dx < grid[0].length - 1&& dy < grid.length - 1 && !isVisited[dy][dx] && grid[dy][dx] != 0){
                            isVisited[dy][dx] = true;
                            queue.add(new int[] {dy, dx});
                        }
                    }
                }

                // 연산 파트

                for(int k = 0; k < 4; k++){
                    int dx = i + x[k];
                    int dy = j + y[k];
                }

                result += 1;
            }
        }

        return result;
    }
}
