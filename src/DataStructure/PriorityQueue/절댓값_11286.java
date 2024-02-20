package src.DataStructure.PriorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 절댓값_11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // [절댓값, 원래값], 비교자: 1순위 절댓값, 2순위 원래값
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
                    // 큐가 Null 이면 0 출력
                    sb.append(0).append('\n');
                } else {
                    // 큐에서 가장 작은 값 출력
                    int[] popped = priorityQueue.poll();
                    sb.append(popped[1]).append('\n');
                }

            } else {
                // [절댓값, 원래값]으로 Queue 에 넣음
                priorityQueue.add(new int[] {Math.abs(command), command});
            }

        }

        System.out.println(sb);
    }
}
