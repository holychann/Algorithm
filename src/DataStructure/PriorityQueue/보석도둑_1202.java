package src.DataStructure.PriorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 보석도둑_1202 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        int[][] gems = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer gem = new StringTokenizer(br.readLine());

            gems[i][0] = Integer.parseInt(gem.nextToken());
            gems[i][1] = Integer.parseInt(gem.nextToken());
        }

        int[] bags = new int[K];

        for(int i = 0; i < K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
        Arrays.sort(gems, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });


        int[] values = new int[K];

        int updated = 0;

        int j_before = 0;

        for(int i = 0; i < K; i++){

            for(int j = j_before; j < N; j += 1){

                if(gems[j][0] <= bags[i] && gems[j][0] != -1){
                    priorityQueue.add(new int[] {gems[j][0], gems[j][1], j});
                } else {
                    j_before = j;
                    break;
                }
            }

            updated = 0;

            while(!priorityQueue.isEmpty()){

                int[] popped = priorityQueue.poll();

                if(popped[1] > values[i]){
                    values[i] = popped[1];
                    updated = popped[2];
                } else {
                    priorityQueue.add(popped);
                    break;
                }

            }

            gems[updated][0] = -1;

        }

        long answer = 0;

        for(long el : values){
            answer += el;
        }


        System.out.println(answer);
    }
}
