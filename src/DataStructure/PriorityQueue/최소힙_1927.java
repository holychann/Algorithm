package src.DataStructure.PriorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙_1927 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            int test = Integer.parseInt(br.readLine());
            if(test == 0){
                int result = 0;
                if(!priorityQueue.isEmpty()){
                    result = priorityQueue.poll();
                }
                sb.append(result).append("\n");
            } else {
                priorityQueue.add(test);
            }
        }

        System.out.println(sb);


    }
}
