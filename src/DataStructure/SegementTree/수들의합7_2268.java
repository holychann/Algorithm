package src.DataStructure.SegementTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수들의합7_2268 {

    static int N, M;

    static long[] tree;

    static int width;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        width = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));

        tree = new long[N * 4];

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= M; i ++){
            StringTokenizer test = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(test.nextToken());

            int a = Integer.parseInt(test.nextToken());
            int b = Integer.parseInt(test.nextToken());

            if(command == 0){
                if(a > b){
                    sb.append(getMin(1, 1, width, b, a)).append("\n");
                } else {
                    sb.append(getMin(1, 1, width, a, b)).append("\n");
                }
            } else {
                update(a, b);
            }
        }

        System.out.println(sb);


    }

    static void update(int i, int k){

        long diff = tree[width + i - 1] - k;

        int j = width + i - 1;

        while(j > 0){
            tree[j] -= diff;

            j /= 2;
        }
    }


    static long getMin(int node, int start, int end, int left, int right){
        if(left == start && end == right) return tree[node];

        int half = (start + end) / 2;

        if(end < left || start > right || right < left) return 0;

        return getMin(node * 2, start, half, left, Math.min(right, half)) + getMin(node * 2 + 1, half + 1, end, Math.max(half + 1, left), right);
    }
}
