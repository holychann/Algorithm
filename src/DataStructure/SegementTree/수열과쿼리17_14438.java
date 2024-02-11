package src.DataStructure.SegementTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수열과쿼리17_14438 {

    static int N, M;

    static int maxValue = 2147000000;

    static int[] tree;

    static int width;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new int[N * 4];

        Arrays.fill(tree, maxValue);

        width = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            tree[width + i] = Integer.parseInt(st.nextToken());
        }

        initTree();

        M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            StringTokenizer test = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(test.nextToken());
            int b = Integer.parseInt(test.nextToken());
            int c = Integer.parseInt(test.nextToken());

            if(a == 1){
                update(b, c);
            } else {
                sb.append(getMin(1, 1, width, b, c)).append("\n");
            }
        }

        System.out.println(sb);



    }

    static void initTree(){
        for(int i = width - 1; i > 0; i--){
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    static int getMin(int node, int start, int end, int left, int right){
        if(start == left && end == right) return tree[node];

        int half = (start + end) / 2;

        int leftMin = end > left && left <= right ? getMin(node * 2, start, half, left, Math.min(half, right)) : maxValue;
        int rightMin = start < right && left <= right ? getMin(node * 2 + 1, half + 1, end, Math.max(half + 1,left), right) : maxValue;

        return Math.min(leftMin, rightMin);
    }

    static void update(int i, int k){
        tree[width + i - 1] = k;

        int parent = (width + i - 1) / 2;

        while(parent > 0){
            tree[parent] = Math.min(tree[parent * 2], tree[parent * 2 + 1]);

            parent /= 2;
        }
    }
}
