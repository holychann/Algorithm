package src.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이분그래프_1707 {

    // 1차: 해당 정점, 2차: 연결된 정점
    static List<Integer>[] graph;

    /**
     * 0: 방문 안 함
     * -1: 빨강
     * 1 : 파랑
     */
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 초기화
            graph = new List[V + 1];
            color = new int[V + 1];

            for(int i = 0; i <= V; i++){
                graph[i] = new ArrayList<>();
                color[i] = 0;
            }

            for(int i = 0; i < E; i++){
                StringTokenizer edges = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(edges.nextToken());
                int b = Integer.parseInt(edges.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            // main Solution
            int result = 1;
            for(int i = 1; i <= V; i++){
                int ans = 0;
                if(color[i] == 0){
                    result = isBipartite(i);
                    if(result == -1){
                        break;
                    }
                }
            }

            if(result == 1){
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }



        // while 문 끝
        }

        System.out.println(sb);


    }


    // s: 시작 정점, 반환: -1: false, 1: true
    static int isBipartite(int s){

        // 1: true, 2: false
        int check = 1;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);

        color[s] = 1;

        while(!queue.isEmpty()){

            int pop = queue.poll();

            for(int i = 0; i < graph[pop].size(); i++){
                if(color[graph[pop].get(i)] == 0){
                    color[graph[pop].get(i)] = color[pop] == 1 ? -1 : 1;
                    queue.add(graph[pop].get(i));
                } else if(color[pop] + color[graph[pop].get(i)] != 0){
                    check = -1;
                    break;
                }
            }

            if(check == -1){
                break;
            }
        }

        return check;
    }


}
