package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class AC_5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TestCase = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        int t = 1;

        // 0: left, 1: right
        int pointer = 0;
        boolean breakPoint = false;

        while(t <= TestCase){

            breakPoint = false;
            pointer = 0;

            String command = br.readLine();

            char[] commandArr = new char[command.length()];

            // 명령 배열
            for(int i = 0; i < command.length(); i++){
                commandArr[i] = command.charAt(i);
            }

            int n = Integer.parseInt(br.readLine());

            String input = br.readLine();

            String[] charArr = input.split("\\D+");


            for(int i = 0; i < charArr.length - 1; i++){
                deque.add(Integer.parseInt(charArr[i + 1]));
            }

            for(int i = 0; i < commandArr.length; i++){

                if(commandArr[i] == 'R'){
                    pointer = pointer == 0 ? 1 : 0;
                }

                if(commandArr[i] == 'D'){
                    if(pointer == 0 && !deque.isEmpty()){
                        deque.remove();
                    } else if(pointer == 1 && !deque.isEmpty()){
                        deque.removeLast();
                    } else if(deque.isEmpty()){
                        breakPoint = true;
                        break;
                    }
                }


            }

            ArrayList<Integer> result = new ArrayList<>();

            while(!deque.isEmpty()){
                if(pointer == 0){
                    result.add(deque.remove());
                } else if(pointer == 1){
                    result.add(deque.removeLast());
                }
            }



            if(breakPoint){
                sb.append("error").append("\n");
            } else if(result.size() == 0){
                sb.append("[").append("]").append("\n");
            } else {
                sb.append("[");
                for(int i = 0; i < result.size(); i++){
                    sb.append(result.get(i)).append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append("]").append("\n");
            }

            t++;

        }



        System.out.println(sb);

    }
}
