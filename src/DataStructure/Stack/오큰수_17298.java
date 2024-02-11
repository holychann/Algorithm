package src.DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_17298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ------Input------ //

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        // 오큰수 배열
        int[] oks = new int[N];

        // 배열 초기화
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            oks[i] = -1;
        }


        // ------Solution------ //

        int n = 0;

        Stack<Integer> stack = new Stack<>();

        stack.add(0);

        for(int j = 1; j < N; j++){
            while(!stack.isEmpty()){
                if(arr[stack.peek()] < arr[j]){
                    oks[stack.pop()] = arr[j];
                } else {
                    break;
                }
            }

            stack.add(j);
        }

        StringBuilder sb = new StringBuilder();

        for(int el : oks){
            sb.append(el).append(" ");
        }

        sb.delete(sb.length() - 1, sb.length());

        System.out.println(sb);

    }
}
