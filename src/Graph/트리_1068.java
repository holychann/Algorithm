package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리_1068 {

    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> child = new ArrayList<>();

        tree = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        int D = Integer.parseInt(br.readLine());

        dfs_delete(D);

        boolean[] isParent = new boolean[N];

        for(int j = 0; j < N; j++){
            if(tree[j] <= -1) continue;
            isParent[tree[j]] = true;
        }

        int result = 0;

        for(int i = 0; i < N; i++){
            if(tree[i] != -2 && !isParent[i]){
                result++;
            }
        }

        System.out.println(result);

    }

    static void dfs_delete(int D){

        tree[D] = -2;

        for(int i = 0; i < tree.length; i++){
            if(tree[i] == D){
                dfs_delete(i);
            }
        }

    }
}
