package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질2_12851 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;
        int min = Integer.MAX_VALUE;

        // [현재 위치, 지난 시간]
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        pq.add(new int[]{N, 0});

        while(!pq.isEmpty()){

            int[] pop = pq.poll();

            // 목표 조건
            if(pop[0] == K){
                if(pop[1] <= min){
                    count++;
                    min = pop[1];
                }
            }

            // 행동
            // 뒤로 걷기
            if(pop[0] - 1 > 0){
                pq.add(new int[]{pop[0] - 1, pop[1] + 1});
            }
            // 앞으로 걷기
            if(pop[0] + 1 <= N){
                pq.add(new int[]{pop[0] + 1, pop[1] + 1});
            }
            // 순간이동
            if(pop[0] * 2 < K * 2){
                pq.add(new int[]{pop[0] * 2, pop[1] + 1});
            }


        }

        System.out.println(min);
        System.out.println(count);

    }
}
