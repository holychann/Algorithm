package src.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 가장가까운공통조상_3584 {

    static int[] parent; // 부모 노드 정보
    static int[] depth; // 노드의 깊이
    static ArrayList<Integer>[] tree; // 트리
    static int N; // 노드의 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            depth = new int[N + 1];
            tree = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree[a].add(b);
                parent[b] = a; // b의 부모는 a
            }

            // 루트 노드 찾기
            int root = 1;
            for (int i = 1; i <= N; i++) {
                if (parent[i] == 0) {
                    root = i;
                    break;
                }
            }

            // 깊이 계산
            dfs(root, 0);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            sb.append(lca(node1, node2)).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int node, int d) {
        depth[node] = d;
        for (int next : tree[node]) {
            if (depth[next] == 0) {
                dfs(next, d + 1);
            }
        }
    }

    static int lca(int a, int b) {
        // 깊이 맞추기
        while (depth[a] != depth[b]) {
            if (depth[a] > depth[b]) {
                a = parent[a];
            } else {
                b = parent[b];
            }
        }

        // 공통 조상 찾기
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

}
