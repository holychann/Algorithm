package src.DataStructure.PriorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기_1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ------Input------ //

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }

        // ------Solution------ //

        int sum = 0;

        while(priorityQueue.size() > 1){

            int[] popped = new int[] {priorityQueue.poll(), priorityQueue.poll()};

            sum += popped[0] + popped[1];

            priorityQueue.add(popped[0] + popped[1]);
        }

        System.out.println(sum);
    }

}
