package src.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연결요소의개수_11724 {

    static boolean[] isVisited;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer setter = new StringTokenizer(br.readLine());

        /**
         * n: 정점의 개수
         * m: 간선의 개수
         */
        int n = Integer.parseInt(setter.nextToken());
        int m = Integer.parseInt(setter.nextToken());

        graph = new List[n + 1];
        isVisited = new boolean[n + 1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        // 간선 초기화
        for(int i = 0; i < m; i++){
            StringTokenizer node = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(node.nextToken());
            int v = Integer.parseInt(node.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Integer> queue = new LinkedList<>();

        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(!isVisited[i]){
                answer++;
                solution(i, queue);
            }

        }

        System.out.println(answer);

    }

    static void solution(int start, Queue<Integer> queue){

        queue.add(start);
        isVisited[start] = true;

        while(!queue.isEmpty()){

            int node = queue.poll();

            isVisited[node] = true;

            for(int i = 0; i < graph[node].size(); i++){
                int next = graph[node].get(i);

                if(!isVisited[next]){
                    queue.add(next);
                    isVisited[next] = true;
                }
            }

        }
    }

}
