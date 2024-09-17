package src.Graph;
import java.util.*;

public class 숨바꼭질3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 수빈이의 위치
        int K = sc.nextInt();  // 동생의 위치

        // 방문한 위치와 그 위치까지의 최소 시간을 저장할 배열
        int[] time = new int[100001];
        Arrays.fill(time, Integer.MAX_VALUE); // 최댓값으로 초기화하여 방문하지 않았음을 표시

        // 덱을 이용한 BFS 구현 (0-1 BFS)
        Deque<Integer> deque = new LinkedList<>();
        deque.add(N);  // 시작점 추가
        time[N] = 0;   // 시작점의 시간은 0

        while (!deque.isEmpty()) {
            int current = deque.poll();

            // 만약 현재 위치가 동생의 위치라면 최소 시간 출력 후 종료
            if (current == K) {
                System.out.println(time[current]);
                return;
            }

            // 순간이동 (0초)
            if (current * 2 <= 100000 && time[current * 2] > time[current]) {
                time[current * 2] = time[current];  // 시간 변화 없음
                deque.addFirst(current * 2);  // 우선적으로 처리하기 위해 덱의 앞에 추가
            }

            // 앞으로 한 칸 이동 (1초)
            if (current + 1 <= 100000 && time[current + 1] > time[current] + 1) {
                time[current + 1] = time[current] + 1;
                deque.addLast(current + 1);
            }

            // 뒤로 한 칸 이동 (1초)
            if (current - 1 >= 0 && time[current - 1] > time[current] + 1) {
                time[current - 1] = time[current] + 1;
                deque.addLast(current - 1);
            }
        }
    }
}
