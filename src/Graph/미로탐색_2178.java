package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로탐색_2178 {

    public static void main(String[] args) throws Exception {


        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 2][M + 2];

        // 입력 배열화
        for(int i = 1; i <= N; i++){
            String mazeTokens = br.readLine();

            for(int j = 0; j < M; j++){
                graph[i][j+1] = mazeTokens.charAt(j) - '0';

            }
        }

        int[] first = {1, 1, 1};


        // Main
        // Queue 자료구조 - for BFS
        Queue queue = new Queue(100);


        queue.enqueue(first);
        while(!queue.isEmpty()){

            int[] data = queue.dequeue();
            int x = data[1];
            int y = data[0];
            int w = data[2];

            if(x == M && y == N) {
                System.out.println(w);
                break;
            }

            graph[y][x] = 0;

            // 상
            if(graph[y - 1][x] != 0){
                int[] point = {y - 1,x , w + 1};
                graph[y - 1][x] = 0;
                queue.enqueue(point);
            }
            // 하
            if(graph[y + 1][x] != 0){
                int[] point = {y + 1,x , w + 1};
                graph[y + 1][x] = 0;
                queue.enqueue(point);
            }
            // 우
            if(graph[y][x + 1] != 0){
                int[] point = {y, x + 1 , w + 1};
                graph[y][x + 1] = 0;
                queue.enqueue(point);
            }
            // 좌
            if(graph[y][x - 1] != 0){
                int[] point = {y,x - 1, w + 1};
                graph[y][x - 1] = 0;
                queue.enqueue(point);
            }


            }


        }
    public static class Queue {
        private int[][] queue;
        private int front;
        private int end;
        private int capacity;

        public Queue(int size){
            queue = new int[size][3];
            front = 0;
            end = 0;
            capacity = size;
        }

        public void enqueue(int[] el){
            // 추가사항: 용량이 꽉 차면 에러 발생

            queue[end] = el;

            end++;

            if(end == capacity) end = 0;
        }

        public int[] dequeue(){
            // 추가사항: 비어있다면 에러 발생
            int[] data = queue[front];
            front++;
            if(front == capacity) front = 0;

            return data;
        }

        public boolean isEmpty(){
            return front == end;
        }

        public boolean isFull(){
            if(((end + 1 == capacity) && front == 0) || (end + 1 == front)) {
                return true;
            } else {
                return false;
            }
        }

    }


    }

