package src.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class 트리의부모찾기_11725 {

    static List<Integer>[] tree;
    static int[] result;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        isVisited = new boolean[N + 1];

        tree = new List[N + 1];

        for(int i = 0; i <= N; i++){
            tree[i] = new ArrayList();
        }

        // init tree
        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);

        }


        isVisited[0] = true;
        isVisited[1] = true;

        result = new int[N + 1];

        getParent(1);

        StringBuilder sb = new StringBuilder();

        for(int i = 2; i <= N; i++){
            sb.append(result[i]).append('\n');
        }

        System.out.println(sb);

    }

    // node: default value == 1;
    static void getParent(int node){

        List<Integer> children = tree[node];

        isVisited[node] = true;
        // 탈출조건
        if(children.isEmpty()) return;

        for(int el : children){
            if(isVisited[el] == true) continue;
            result[el] = node;
            getParent(el);
        }

    }


}
