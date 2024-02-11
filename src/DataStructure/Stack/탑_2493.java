package src.DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ------Input------ //

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] towers = new int[N];

        for(int i = 0; i < N; i++){
            towers[i] = Integer.parseInt(st.nextToken());
        }

        // ------Solution------ //


        Stack<Integer> stack = new Stack<>();

        stack.add(0);

        int[] result = new int[N];

        for(int i = 1; i < N; i++){

            while(1 == 1){
                if(!stack.isEmpty()){
                    if(towers[stack.peek()] <= towers[i]){
                        stack.pop();
                    } else {
                        result[i] = stack.peek() + 1;
                        break;
                    }
                } else {
                    break;
                }
            }

            stack.add(i);
        }

        StringBuilder sb = new StringBuilder();

        for(int el : result){
            sb.append(el).append(" ");
        }

        sb.delete(sb.length() - 1, sb.length());

        System.out.println(sb);

    }
}
