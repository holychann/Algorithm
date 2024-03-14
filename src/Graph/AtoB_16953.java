package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AtoB_16953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        Queue<long[]> queue = new LinkedList<>();

        queue.add(new long[] {a, 1});

        boolean isPossible = false;

        long result = 0;

        while(!queue.isEmpty()){

            long[] popped = queue.poll();

            if(popped[0] == b) {
                isPossible = true;
                result = popped[1];
                break;
            }

            if(popped[0] * 2 <= b){
                queue.add(new long[] {popped[0] * 2, popped[1] + 1});
            }
            if(popped[0] * 10 + 1 <= b){
                queue.add(new long[] {popped[0] * 10 + 1, popped[1] + 1});
            }


        }

        if(isPossible){
            System.out.println(result);
        } else {
            System.out.println(-1);
        }

    }
}
