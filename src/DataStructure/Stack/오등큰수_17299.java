package src.DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오등큰수_17299 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] count = new int[1000001];
        int[] NGF = new int[n + 1];

        // [원본 배열에 해당하는 숫자, 인덱스]
        Stack<int[]> stack = new Stack<>();


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            count[num] += 1;
        }

        stack.add(new int[] {arr[1], 1});

        if(n == 1){
            System.out.println(-1);
        } else {
            for(int i = 2; i <= n; i++){

                if(!stack.isEmpty()){

                    while(count[arr[i]] > count[stack.peek()[0]]){
                        int[] popped = stack.pop();

                        NGF[popped[1]] = arr[i];

                        if(stack.isEmpty()) break;
                    }
                }


                stack.add(new int[] {arr[i], i});

            }

            while(!stack.isEmpty()){
                int[] popped = stack.pop();

                NGF[popped[1]] = -1;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= n; i++){
                sb.append(NGF[i]).append('\n');
            }

            System.out.println(sb);
        }


    }
}
