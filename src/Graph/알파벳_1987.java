package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987 {

    static char[][] graph;
    static boolean[] isVisited;

    static int maxCount;

    static int R;
    static int C;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // R 세로, C 가로
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];

        isVisited = new boolean[26];

        maxCount = 0;

        // Input Initializing
        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                graph[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 0);

        System.out.println(maxCount);






    }

    public static void dfs(int i, int j, int count){

        // exit
        if(i < 0 || j < 0 || i >= R || j >= C || isVisited[graph[i][j] - 'A']){
            maxCount = Math.max(maxCount, count);
            return;
        }

        isVisited[graph[i][j] - 'A'] = true;

        // behavior

            // 상
            dfs(i - 1, j, count + 1);
            // 하
            dfs(i + 1, j, count + 1);
            // 좌
            dfs(i, j - 1, count + 1);
            // 우
            dfs(i, j + 1, count + 1);

        isVisited[graph[i][j] - 'A'] = false;


    }
}
