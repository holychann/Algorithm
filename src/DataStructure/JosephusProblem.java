package src.DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JosephusProblem {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        // Array Initializing
        for(int i = 1; i <= N; i++){
            arr[i - 1] = i;
        }

        sb.append("<");


        Queue<Integer> queue = new LinkedList<>();

        for(int el : arr){
            queue.add(el);
        }

        int count = 0;

        while(!queue.isEmpty()){
            int data = queue.remove();
            count++;

            if(count == K){
                sb.append(data).append(", ");
                count = 0;
            } else {
                queue.add(data);
            }


        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append(">");

        System.out.println(sb);


    }
}
