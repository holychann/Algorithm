package src.Graph.Dijkstra;

import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용구하기_1916 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        boolean[] isVisited = new boolean[N + 1];
        int[] distance = new int[N + 1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i <= N; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        // Input
        for(int i = 1; i <= M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new int[] { to, weight });
        }

        StringTokenizer destinationSt = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(destinationSt.nextToken());
        int end = Integer.parseInt(destinationSt.nextToken());


        // Solution
        // int[]: {목적지, 현재까지 누적비용}
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });


        // Queue 초기값 설정
//        for(int i = 1; i <= graph[start].size() ; i++){
//            int to =  graph[i].get(0)[0];
//            int w = graph[i].get(0)[1];
//            priorityQueue.add(new int[] {to, w});
//        }
        priorityQueue.add(new int[] {start, 0});

        distance[start] = 0;


        // Main
        while(!priorityQueue.isEmpty()){

            int[] node = priorityQueue.remove();

            int present = node[0];
            int weight = node[1];

            if(isVisited[present]) continue;

            isVisited[present] = true;

            if(present == end){
                // 여기서 결과 반환? or 예외처리에서 반환? -> 확인요청
                System.out.println(weight);
                break;
            }

            for(int[] el : graph[present]){
                if(!isVisited[el[0]]){
                    int w = el[1];
                    int newWeight = w + weight;
                    if(newWeight < distance[el[0]]) {
                        distance[el[0]] = newWeight;
                        priorityQueue.add(new int[] {el[0], weight + el[1]});
                    }

                }
            }

        }


    }


}
