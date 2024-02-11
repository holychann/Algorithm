package src.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로_1504 {

    // 우선순위 큐: {d:목적지, w:가중치}
    static PriorityQueue<int[]> priorityQueue;

    static int[] distance;

    static ArrayList<int[]>[] graph;

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int E = Integer.parseInt(st.nextToken());

        priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        distance = new int[N + 1];

        graph = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }


        for(int i = 1; i <= E; i++){
            StringTokenizer edge = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(edge.nextToken());
            int to = Integer.parseInt(edge.nextToken());
            int weight = Integer.parseInt(edge.nextToken());

            graph[from].add(new int[] {to, weight});
            graph[to].add(new int[] {from, weight});
        }

        StringTokenizer foodhold = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(foodhold.nextToken());
        int v2 = Integer.parseInt(foodhold.nextToken());

        int result = 0;

        int result1_1 = dijkstra(1, v1);
        int result1_2 = dijkstra(v1, v2);
        int result1_3 = dijkstra(v2, N);
        if(result1_1 == -1 || result1_2 == -1 || result1_3 == -1) result = -1;

        int result2_1 = dijkstra(1, v2);
        int result2_2 = dijkstra(v2, v1);
        int result2_3 = dijkstra(v1, N);
        if(result2_1 == -1 || result2_2 == -1 || result2_3 == -1) result = -1;

        if(result != -1){
            result = Math.min(result1_1 + result1_2 + result1_3, result2_1 + result2_2 + result2_3);
        }


        if(result < 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }



    }

    public static void setDistance(){

        for(int i = 1; i < distance.length; i++){
            distance[i] = Integer.MAX_VALUE;
        }

    }

    // 다익스트라(S: 출발지, D: 목적지)
    public static int dijkstra(int S, int D){

        setDistance();

        if(S <= 0 || S > N || D <= 0 || D > N) {
            // 유효하지 않은 정점 번호
            return -1;
        }

        priorityQueue.clear();

        int present = S;
        int weight = 0;

        distance[S] = 0;

        priorityQueue.add(new int[] {present, weight});

        // Main
        while(!priorityQueue.isEmpty()){

            int[] node = priorityQueue.remove();

            present = node[0];
            weight = node[1];

            // 목적지 도착
            if(present == D){
                break;
            }

            for(int[] el : graph[present]){

                int newWeight = weight + el[1];

                if(newWeight < distance[el[0]]){
                    distance[el[0]] = newWeight;
                    priorityQueue.add(new int[] {el[0], newWeight});
                }

            }

        }

        if(!(distance[D] < Integer.MAX_VALUE)){
            return -1;
        } else {
            return weight;
        }

    }
}
