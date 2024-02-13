package src.DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 괄호_9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){

            boolean result = true;

            stack.clear();

            String test = br.readLine();

            for(int j = 0; j < test.length(); j++){

                char g = test.charAt(j);

                if(g == '('){
                    stack.add('(');
                } else {
                    if(stack.isEmpty()) {
                        result = false;
                        break;
                    } else {
                        stack.pop();
                    }

                }
            }

            if(!stack.isEmpty()){
                result = false;
            }

            if(result){
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }

        }
        System.out.println(sb);
    }
}