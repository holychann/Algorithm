package src.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티_1238 {
    static PriorityQueue<int[]> priorityQueue;
    // 그래프 배열
    static ArrayList<int[]>[] graph;
    // 방문 배열
    static boolean[] isVisited;
    // 각 노드의 최소 거리
    static int[] distance;
    // 결과값 배열
    static int[] result;

    static int N, M, X;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        isVisited = new boolean[N + 1];

        distance = new int[N + 1];

        result = new int[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            StringTokenizer n = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(n.nextToken());
            int to = Integer.parseInt(n.nextToken());
            int weight = Integer.parseInt(n.nextToken());

            graph[from].add(new int[] {to, weight});
        }


        priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });


        reset();

        // 목표 노드로의 계산
        for(int i = 1; i <= N; i++){
            int w = dijkstra(i, X);
            result[i] += w;
            int x = dijkstra(X, i);
            result[i] += x;
        }

        int max = Integer.MIN_VALUE;

        for(int el : result){
            max = Math.max(el, max);
        }

        System.out.println(max);

    }

    static void reset(){
        for(int i = 0; i <= N; i++){
            distance[i] = Integer.MAX_VALUE;
            isVisited[i] = false;
        }
        priorityQueue.clear();
    }

    // dijkstra(S: 시작 노드, T: 도착 노드)
    static int dijkstra(int S, int T){

        int w = 0;

        reset();

        priorityQueue.add(new int[] {S, 0});

        while(!priorityQueue.isEmpty()){

            // pop
            int[] node = priorityQueue.remove();

            int present = node[0];
            int weight = node[1];

            if(isVisited[present]) continue;

            isVisited[present] = true;

            if(present == T){
                w = weight;
                break;
            }

            for(int[] el : graph[present]){

                if(!isVisited[el[0]]){
                    int new_weight = el[1] + weight;
                    if(new_weight < distance[el[0]]){
                        distance[el[0]] = new_weight;
                        priorityQueue.add(new int[] {el[0], new_weight});
                    }
                }

            }



        }

        return w;
    }

}
