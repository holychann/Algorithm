package src.DataStructure.PriorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 절댓값_11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // [절댓값, 원래값]
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        while(N-- > 0){

            int command = Integer.parseInt(br.readLine());

            if(command == 0){
                if(priorityQueue.isEmpty()){
                    sb.append(0).append('\n');
                } else {
                    int[] poped = priorityQueue.poll();
                    sb.append(poped[1]).append('\n');
                }

            } else {
                priorityQueue.add(new int[] {Math.abs(command), command});
            }

        }

        System.out.println(sb);
    }
}
