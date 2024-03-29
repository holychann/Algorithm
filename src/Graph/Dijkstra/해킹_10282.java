package src.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 해킹_10282 {

    static List<int[]>[] graph;
    static boolean[] isVisited;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        // test

        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph = new List[n + 1];
            isVisited = new boolean[n + 1];

            pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[1], o2[1]);
                }
            });

            for(int i = 1; i <= n; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 1; i <= d; i++){
                StringTokenizer computer = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(computer.nextToken());
                int b = Integer.parseInt(computer.nextToken());
                int s = Integer.parseInt(computer.nextToken());

                graph[b].add(new int[] {a, s});
            }

            int max = 0;
            int result_c = 1;

            // pq = {도착 노드, 가중치}
            for(int[] el : graph[c]){
                max = Math.max(max, el[1]);
                pq.add(new int[] {el[0], el[1]});
            }

            isVisited[c] = true;


            int result_w = max;


            while(!pq.isEmpty()){
                int[] popped = pq.poll();

                int arrived = popped[0];
                int w = popped[1];

                if(isVisited[arrived]) continue;

                result_c += 1;

                isVisited[arrived] = true;


                for(int i = 0; i < graph[arrived].size(); i++){
                    if(isVisited[graph[arrived].get(i)[0]]) continue;

                    max = Math.max(max, graph[arrived].get(i)[1]);
                    pq.add(new int[] {graph[arrived].get(i)[0], graph[arrived].get(i)[1]});
                }

                result_w += max;

                max = 0;

            }

            sb.append(result_c).append(" ").append(result_w).append('\n');
        }


        System.out.println(sb);


    }
}
