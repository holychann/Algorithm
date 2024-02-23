package src.DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 단어뒤집기2_17413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();

        int index = 0;
        boolean isTag = false;

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        while(index < string.length()){
            String result = "";
            if(string.charAt(index) == ' '){
                sb.append(" ");
                index++;
                continue;
            }
            if(string.charAt(index) == '<'){
                while(string.charAt(index) != '>'){
                    result += string.charAt(index);
                    index++;
                }
                result += '>';
                index++;
                sb.append(result);
            } else {
                while(index < string.length() && string.charAt(index) != ' ' && string.charAt(index) != '<'){
                    stack.add(string.charAt(index));
                    index++;
                }

                while(!stack.isEmpty()){
                    result += stack.pop();
                }

                sb.append(result);
            }
        }

        System.out.println(sb);

    }
}
