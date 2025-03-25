package src.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 효율적인해킹_1325 {
    static List<Integer>[] graph;
    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer testCase = new StringTokenizer(br.readLine());

        n = Integer.parseInt(testCase.nextToken());  // 컴퓨터들의 번호 1~N 번까지 존재
        m = Integer.parseInt(testCase.nextToken());  // 신뢰관계의 수

        graph = new ArrayList[n + 1];

        // 초기화
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        // 초기화
        for(int i = 0; i < m; i++){
            StringTokenizer input = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(input.nextToken());
            int b = Integer.parseInt(input.nextToken());

            graph[b].add(a);
        }

        int[] result = new int[n + 1];

        int max = 0;

        for(int i = 1; i <= n; i++){
            int r = solution(i);
            max = r > max ? r : max;
            result[i] = r;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());









        int a = 1;



    }

    static int solution(int num){

        int count = 0;

        Queue<Integer> queue = new LinkedList<>();

        int[] isVisited = new int[n + 1];

        queue.add(num);
        isVisited[num] = 1;
        count++;

        while(!queue.isEmpty()){

            int node = queue.poll();

            for(int i = 0; i < graph[node].size(); i++){
                if(isVisited[graph[node].get(i)] == 1){
                    continue;
                }
                queue.add(graph[node].get(i));
                isVisited[graph[node].get(i)] = 1;
                count++;
            }

        }

        return count;

    }
}
