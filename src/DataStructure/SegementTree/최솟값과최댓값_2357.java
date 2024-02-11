package src.DataStructure.SegementTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최솟값과최댓값_2357 {

    static int N, M;

    static int[][] tree;

    static int width;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N * 4][2];

        width = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));

        for(int i = 0; i < tree.length; i++){
            tree[i][0] = Integer.MAX_VALUE;
        }

        // 루트노드
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            tree[width + i][0] = num;
            tree[width + i][1] = num;
        }

        initTree();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= M; i++){
            StringTokenizer test = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(test.nextToken());
            int b = Integer.parseInt(test.nextToken());
            int[] answer = getMinMax(1, 1, width, a, b);
            sb.append(answer[0]).append(" ").append(answer[1]).append('\n');
        }



        System.out.println(sb);


    }

    static public void initTree(){

        for(int i = width - 1; i > 0; i--){
            tree[i][0] = Math.min(tree[i * 2][0], tree[i * 2 + 1][0]);
            tree[i][1] = Math.max(tree[i * 2][1], tree[i * 2 + 1][1]);
        }
    }

    /**
     *
     * @param node 현재 노드(Default == 1)
     * @param start 시작 노드
     * @param end 끝 노드
     * @param left 구해야하는 구간의 시작 노드
     * @param right 구해야하는 구간의 끝 노드
     * @return
     */
    static public int[] getMinMax(int node, int start, int end, int left, int right){

        if(start == left && end == right) return tree[node];

        int half = (int) Math.floor((start + end) / 2);

        int[] left_node = end > left && left <= right ? getMinMax(node * 2, start, half, left, Math.min(right, half)) : new int[] {Integer.MAX_VALUE, 0};
        int[] right_node = start < right && left <= right ? getMinMax(node * 2 + 1, half + 1, end, Math.max(left, half + 1), right) : new int[] {Integer.MAX_VALUE, 0};

        int[] result = new int[2];
        result[0] = Math.min(left_node[0], right_node[0]);
        result[1] = Math.max(left_node[1], right_node[1]);

        return result;
    }


}
