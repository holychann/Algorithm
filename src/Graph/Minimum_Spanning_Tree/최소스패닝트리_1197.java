package src.Graph.Minimum_Spanning_Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리_1197 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점의 개수
        int V = Integer.parseInt(st.nextToken());
        // 간선의 개수
        int E = Integer.parseInt(st.nextToken());

        // 우선순위 큐: {from, to, weight(비교기준)}
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        int[] relationship = new int[V + 1];
        // 초기 부모를 자기 자신으로 설정
        for(int i = 1; i <= V; i++){
            relationship[i] = i;
        }

        // 간선 등록
        for(int i = 1; i <= E; i++){
            StringTokenizer edges = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(edges.nextToken());
            int to = Integer.parseInt(edges.nextToken());
            int weight = Integer.parseInt(edges.nextToken());

            priorityQueue.add(new int[] {from, to, weight});
        }

        int result = 0;

        while(!priorityQueue.isEmpty()){

            int[] edge = priorityQueue.remove();

            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            if(relationship[from] == relationship[to]) continue;


            // 노드 흡수
            int parent = relationship[from];
            int toChange = relationship[to];

            for(int i = 1; i <= V; i++){
                if(relationship[i] == toChange){
                    relationship[i] = parent;
                }
            }

            result += weight;

        }

        System.out.println(result);


    }
}
