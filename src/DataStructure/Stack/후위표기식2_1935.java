package src.DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식2_1935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String operator = br.readLine();

        Stack<Double> stack = new Stack<>();

        int[] nums = new int[27];

        for(int i = 1; i <= N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < operator.length(); i++){
            if(!Character.isLetter(operator.charAt(i))){
                double a = stack.pop();
                double b = stack.pop();
                switch (operator.charAt(i)){
                    case '+':
                        stack.add(b + a);
                        break;
                    case '-':
                        stack.add(b - a);
                        break;
                    case '*':
                        stack.add(b * a);
                        break;
                    case '/':
                        stack.add(b / a);
                        break;
                }
            } else {
                stack.add((double) nums[operator.charAt(i) - 'A' + 1]);
            }
        }

        System.out.println(String.format("%.2f", stack.pop()));

    }
}
