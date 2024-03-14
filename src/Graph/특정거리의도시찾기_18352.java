package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기_18352 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Integer>[] map = new List[n + 1];

        // **Input**
        for(int i = 0; i <= n; i++){ map[i] = new ArrayList<>(); }

        for(int i = 0; i < m; i++){
            StringTokenizer street = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(street.nextToken());
            int b = Integer.parseInt(street.nextToken());

            map[a].add(b);
        }

        int[] map_w = new int[n + 1];

        Arrays.fill(map_w, Integer.MAX_VALUE);

        boolean[] isVisited = new boolean[n + 1];

        map_w[x] = 0;
        isVisited[x] = true;

        // **Solution**
        // [도착 도시 번호, 갈 경우의 가중치] 가중치를 기준으로
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });


        for(int i = 0; i < map[x].size(); i++){
            priorityQueue.add(new int[] {map[x].get(i), 1});
        }

        while(!priorityQueue.isEmpty()){

            int[] present = priorityQueue.poll();

            map_w[present[0]] = Math.min(map_w[present[0]], present[1]);

            isVisited[present[0]] = true;

            if(present[1] >= k){
                continue;
            }

            for(int i = 0; i < map[present[0]].size(); i++){

                if(isVisited[map[present[0]].get(i)]) continue;
                // 큐에 다음요소 추가
                priorityQueue.add(new int[] {
                        map[present[0]].get(i),
                        present[1] + 1
                });
            }



        }

        StringBuilder sb = new StringBuilder();

        boolean isCant = false;

        for(int i = 0; i < n + 1; i++){
            if(map_w[i] == k){
                if(!isCant) isCant = true;
                sb.append(i).append('\n');
            }
        }

        if(!isCant){
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }



    }
}
