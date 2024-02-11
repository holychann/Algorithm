package src.DataStructure.SegementTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최솟값_10868 {

    static int N, M;

    static int width;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        tree = new int[N * 4];

        width = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));

        Arrays.fill(tree, Integer.MAX_VALUE);

        for(int i = 0; i < N; i++){
            tree[width + i] = Integer.parseInt(br.readLine());
        }

        // 트리 초기화
        initTree();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= M; i++){
            StringTokenizer test = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(test.nextToken());
            int b = Integer.parseInt(test.nextToken());
            int result = getMin(1, 1, width, a, b);
            sb.append(result).append("\n");
        }


        System.out.println(sb);



    }

    static public void initTree(){

        for(int i = width - 1; i > 0; i--){
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }

    }

    /**
     *
     * @param node 노드(Default == 루트노드)
     * @param start 시작구간(Default == 1)
     * @param end 끝나는 구간(Default == N)
     * @param left 구해야 하는 구간의 시작 값
     * @param right 구해야 하는 구간의 끝 값
     */
    static public int getMin(int node,int start, int end ,int left, int right){

        if(start == left && end == right) return tree[node];

        int half = (int) Math.floor((start + end) / 2);

        // 백퍼 문제있음. leftNum: right 값이, rightNum: left 값이 문제 있을 것임.
        int leftNum = end > left ? getMin(node * 2, start, half, left, Math.min(right, half)) : Integer.MAX_VALUE;
        int rightNum = start < right ? getMin(node * 2 + 1, half + 1, end, Math.max(left, half+1), right): Integer.MAX_VALUE;

        return Math.min(leftNum, rightNum);

    }
}
