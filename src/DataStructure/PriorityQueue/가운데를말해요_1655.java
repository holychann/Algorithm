package src.DataStructure.PriorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 가운데를말해요_1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        maxHeap.add(Integer.parseInt(br.readLine()));
        sb.append(maxHeap.peek()).append("\n");

        /**
         * process
         * 1. validation: maxHeap 의 첫 요소를 기준으로 크면 minHeap 에 추가, 작거나 같다면 maxHeap 에 추가함.
         * 2. check size: maxHeap 을 minHeap 보다 같거나 하나가 큰 사이즈를 유지함.
         * 3.  -> if(maxHeap == minHeap + 2): 만약 maxHeap 이 minHeap 보다 요소가 2개 이상 많다면 maxHeap 에서 가장 큰 값을 minHeap 으로 옮김
         * 4.  -> if(minHeap > maxHeap): minHeap 은 maxHeap 보다 사이즈가 커지면 안되므로, 추가했을 때 사이즈가 커졌다면 가장 작은 값을 옮김.
         * 5. output: 위 과정을 거치므로 중간값은 항상 maxHeap 의 가장 큰 값이므로, maxHeap 의 첫 번째 요소를 출력함.
         */

        int mid = maxHeap.peek();

        for(int i = 1; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            if(mid < num){
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }

            if(maxHeap.size() == minHeap.size() + 2){
                minHeap.add(maxHeap.poll());
            } else if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }

            mid = maxHeap.peek();

            sb.append(mid).append('\n');

        }

        System.out.println(sb);
    }
}
