package src.Graph.Minimum_Spanning_Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 네트워크연결_1922 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] relationship = new int[N + 1];

        // 우선순위 큐: { 출발지, 목적지, 가중치(비교대상) }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        for(int i = 1; i <= M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            priorityQueue.add(new int[] {from, to, weight});
        }

        // 모든 노드의 초기 부모를 자신으로 설정
        for(int i = 1; i <= N; i++){
            relationship[i] = i;
        }

        int result = 0;

        // Main
        while(!priorityQueue.isEmpty()){

            int[] node = priorityQueue.remove();

            int from = node[0];
            int to = node[1];
            int weight = node[2];

            // 부모가 같으면 넘기기
            if(relationship[from] == relationship[to]){
                continue;
            }

            int origin = relationship[to];
            int toChange = relationship[from];
            // 부모가 같지 않다면
            for(int i = 1; i <= N; i++){
                if(relationship[i] == origin) relationship[i] = toChange;
            }

            result += weight;
        }

        System.out.println(result);

    }
}
