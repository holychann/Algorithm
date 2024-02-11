package src.DataStructure.SegementTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구간곱구하기_11505 {
    static int N, M, K;
    static int width;
    static long[] tree;

    static int mod = 1000000007;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tree = new long[N * 4];

        Arrays.fill(tree, 1);

        width = 1 << (int) Math.ceil(Math.log(N)/Math.log(2));

        for(int i = 0; i < N; i++){
            tree[width + i] = Integer.parseInt(br.readLine());
        }

        initTree();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M + K; i++){
            StringTokenizer test = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(test.nextToken());

            if(command == 2){
                int b = Integer.parseInt(test.nextToken());
                int c = Integer.parseInt(test.nextToken());

                long result = getMultiply(1, 1, width, b, c);
                sb.append(result).append("\n");
            }

            if(command == 1){
                int b = Integer.parseInt(test.nextToken());
                int c = Integer.parseInt(test.nextToken());

                update(b, c);
            }

        }

        System.out.println(sb);



    }

    static public void initTree(){
        for(int i = width - 1; i > 0; i--){
            tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % mod;
        }
    }

    /**
     *
     * @param node 현재 노드, Default == 1(루트노드)
     * @param start 현재 노드가 담당하고 있는 구간의 시작점
     * @param end 현재 노드가 담당하고 있는 구간의 끝점
     * @param left 구해야 하는 구간의 시작점
     * @param right 구해야 하는 구간의 끝점
     * @return
     */
    static public long getMultiply(int node, int start, int end, int left, int right){
        // Base Part
        if(start == left && end == right) return tree[node];

        int half = (start + end) / 2;

        // Recursive Part
        long leftMul = end > left && left <= right ? getMultiply(node * 2, start, half, left, Math.min(half, right)) : 1;
        long rightMul = start < right && left <= right ? getMultiply(node * 2 + 1, half + 1, end, Math.max(half + 1, left), right) : 1;

        return (leftMul * rightMul) % mod;

    }

    static public void update(int i, int c){
        tree[width + i - 1] = c;

        int parent = (int) Math.floor((width + i - 1) / 2);

        while(parent >= 1){
            tree[parent] = tree[parent * 2] * tree[parent * 2 + 1] % mod;

            parent /= 2;
        }
    }
}
