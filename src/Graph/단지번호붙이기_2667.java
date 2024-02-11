package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 단지번호붙이기_2667 {

    static ArrayList<Integer> blocks;

    static int[][] graph;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        blocks = new ArrayList<>();

        graph = new int[N + 2][N + 2];

        // Input Initializing
        for(int i = 1; i <= N; i++){
            String graphTokens = br.readLine();
            for(int j = 0; j < N; j++){
                graph[i][j + 1] = graphTokens.charAt(j) - '0';
            }
        }

        // Main
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){

                if(graph[i][j] == 1){
                    blocks.add(0);
                    dfs(i, j);
                }


            }
        }

        blocks.sort(null);

        sb.append(blocks.size()).append('\n');

        for(int el : blocks){
            sb.append(el).append('\n');
        }

        System.out.println(sb);


    }

    static void dfs(int i, int j){
        if(graph[i][j] == 0) return;

        graph[i][j] = 0;

        int count = blocks.get(blocks.size() - 1);
        blocks.set(blocks.size() - 1, count + 1);


        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);

    }
}
