package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 거짓말_1043 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer whoKnowTruth = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(whoKnowTruth.nextToken());

        ArrayList<Integer> knowTruth = new ArrayList<>();
        boolean[] isVisited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        if(n > 0){
            for(int i = 0; i < n; i++){
                int t = Integer.parseInt(whoKnowTruth.nextToken());
                isVisited[t] = true;
                knowTruth.add(t);
                queue.add(t);
            }
        }

        int[][] graph = new int[M][N];

        int[] arr = new int[0];

        for(int i = 0; i < M; i++){
            StringTokenizer parties = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(parties.nextToken());
            for(int j = 0; j < k; j++){
                graph[i][j] = Integer.parseInt(parties.nextToken());
            }
        }

        boolean[] isVisited_G = new boolean[M];

        int result = M;

        while(!queue.isEmpty()){

            int t = queue.remove();

            for(int i = 0; i < M; i++){

                if(isVisited_G[i]){
                    continue;
                }

                boolean isContains = false;
                for(int el : graph[i]){
                    if(el == 0) break;
                    if(el == t){
                        isContains = true;
                    }
                }

                if(isContains){
                    for(int el : graph[i]){
                        if(!isVisited[el] && el != 0){
                            isVisited[el] = true;
                            queue.add(el);
                        }
                    }
                    isVisited_G[i] = true;
                    result--;
                }
            }


        }

        System.out.println(result);


    }
}
