package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이프의이동_7562 {

    static int[] dx = new int[] {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[][] graph;
        boolean[][] isVisited;

        StringBuilder sb = new StringBuilder();

        while(t-- > 0){

            int l = Integer.parseInt(br.readLine());

             graph = new int[l][l];
             isVisited = new boolean[l][l];

            StringTokenizer f_position = new StringTokenizer(br.readLine());
             int[] point = new int[] {Integer.parseInt(f_position.nextToken()), Integer.parseInt(f_position.nextToken())};

            StringTokenizer p_position = new StringTokenizer(br.readLine());
            int[] goal = new int[] {Integer.parseInt(p_position.nextToken()), Integer.parseInt(p_position.nextToken())};

            // {x, y}
            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[] {point[0], point[1], 0});

            while(!queue.isEmpty()){

                int[] popped = queue.poll();

                if(popped[1] == goal[1] && popped[0] == goal[0]){
                    sb.append(popped[2]).append('\n');
                    break;
                }

                for(int i = 0; i < 8; i++){
                    int nx = popped[0] + dx[i];
                    int ny = popped[1] + dy[i];

                    if(nx >= 0 && ny >= 0 && nx < l && ny < l){

                        if(!isVisited[ny][nx]){

                            isVisited[ny][nx] = true;
                            queue.add(new int[] {nx, ny, popped[2] + 1});

                        }

                    }
                }

            }

        }

        System.out.println(sb);

    }
}
