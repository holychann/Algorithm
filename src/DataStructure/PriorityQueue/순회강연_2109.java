package src.DataStructure.PriorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 순회강연_2109 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        for(int i = 0; i < N; i++){
            priorityQueue.add(arr[i][0]);

            if(priorityQueue.size() > arr[i][1]){
                priorityQueue.poll();
            }
        }

        int result = 0;

        while(!priorityQueue.isEmpty()){
            result += priorityQueue.poll();
        }

        System.out.println(result);


    }
}
