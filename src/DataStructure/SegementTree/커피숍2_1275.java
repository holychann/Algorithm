package src.DataStructure.SegementTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 커피숍2_1275 {

    static int N, Q;

    static long[] tree;

    static int width;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        width = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));

        tree = new long[N * 4];

        StringTokenizer nums = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            tree[width + i] = Integer.parseInt(nums.nextToken());
        }

        initTree();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < Q; i++){
            StringTokenizer test = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(test.nextToken());
            int y = Integer.parseInt(test.nextToken());
            int a = Integer.parseInt(test.nextToken());
            int b = Integer.parseInt(test.nextToken());

            long result;

            if(x > y){
                result = getPlus(1, 1, width, y, x);
            } else {
                result = getPlus(1, 1, width, x, y);
            }

            update(a, b);

            sb.append(result).append("\n");


        }

        System.out.println(sb);


    }

    static void initTree() {
        for(int i = width - 1; i > 0; i--){
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static long getPlus(int node, int start, int end, int left, int right){

        if(start == left && end == right) return tree[node];

        int half = (start + end) / 2;

        if(end < left || right < left) return 0;

        return getPlus(node * 2 + 1, half + 1, end, Math.max(left, half + 1), right) + getPlus(node * 2, start, half, left, Math.min(right, half));

    }

    static void update(int i, int n){
        tree[width + i - 1] = n;

        int parent = (width + i - 1) / 2;

        while (parent > 0) {
            tree[parent] = tree[parent * 2] + tree[parent * 2 + 1];
            parent /= 2;
        }
    }


}
