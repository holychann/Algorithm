package src.DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 뱀_3190 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // ------Input------ //

        int N = Integer.parseInt(br.readLine());

        int K = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];

        // Set Apples
        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int Y = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            graph[Y - 1][X - 1] = 1;
        }

        int L = Integer.parseInt(br.readLine());

        // control = [[초, 방향], ..., ...]
        ArrayList<int[]> control = new ArrayList<>();

        // Direction Initializing
        for(int i = 0; i < L; i++){
            StringTokenizer cr = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(cr.nextToken());
            char w = cr.nextToken().charAt(0);
            // 0: left, 1: right
            int rw = 0;

            if(w == 'D') {
                rw = 1;
            }

            control.add(new int[] {t, rw});
        }

        control.add(new int[] {0 ,0});


        // ------Solution------ //

        int result = 0;

        Deque<int[]> deque = new ArrayDeque<>();

        deque.offerFirst(new int[]{0, 0});

        graph[0][0] = -1;

        char currentDirection = 'D';

        while(1 == 1){

            int[] original = deque.peekLast();
            int[] head = new int[2];

            head[0] = original[0];
            head[1] = original[1];

            // 방향 컨트롤
            if(result == control.get(0)[0]){
                if(control.get(0)[1] == 1){
                    if(currentDirection == 'D'){ head[0] += 1; currentDirection = 'S';}
                    else if(currentDirection == 'A'){ head[0] -= 1; currentDirection = 'W';}
                    else if(currentDirection == 'W'){ head[1] += 1; currentDirection = 'D';}
                    else if(currentDirection == 'S'){ head[1] -= 1; currentDirection = 'A';}
                } else {
                    if(currentDirection == 'D'){ head[0] -= 1; currentDirection = 'W';}
                    else if(currentDirection == 'A'){ head[0] += 1; currentDirection = 'S';}
                    else if(currentDirection == 'W'){ head[1] -= 1; currentDirection = 'A';}
                    else if(currentDirection == 'S'){ head[1] += 1; currentDirection = 'D';}
                }
                control.remove(0);
            } else {
                if(currentDirection == 'D') head[1] += 1;
                if(currentDirection == 'W') head[0] -= 1;
                if(currentDirection == 'A') head[1] -= 1;
                if(currentDirection == 'S') head[0] += 1;
            }

            // 종료조건
            if(head[1] < 0 || head[0] < 0 || head[0] >= graph.length || head[1] >= graph[1].length){
                break;
            } else if(graph[head[0]][head[1]] == -1) break;

            // 만약 사과가 없으면
            if(graph[head[0]][head[1]] == 0){
                int[] popped = deque.pollFirst();
                graph[popped[0]][popped[1]] = 0;
            }

            // 종료조건 통과 후 변경된 헤드 추가
            deque.offerLast(head);
            graph[head[0]][head[1]] = -1;


            result++;
        }

        System.out.println(result + 1);


    }
}
