package src.DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 키로거_5397 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T > 0){

            LinkedList<Character> linkedList = new LinkedList<>();

            String input = br.readLine();

            int n = input.length();

            int pointer = linkedList.size();

            if(linkedList.size() == 0) pointer = 0;

            for(int i = 0; i < n; i++){
                char c = input.charAt(i);

                if(c == '<'){
                    if(linkedList.size() > 0 && pointer > 0) pointer--;
                } else if(c == '>'){
                    if(linkedList.size() > pointer) pointer++;
                } else if(c == '-'){
                    if(linkedList.size() > 0 && pointer > 0) {
                        linkedList.remove(pointer - 1);
                        pointer--;
                    }
                } else {
                    if(linkedList.size() == 0) {
                        linkedList.add(c);
                        pointer++;
                    } else {
                        linkedList.add(pointer, c);
                        pointer++;
                    }

                }
            }

            for(char el : linkedList){
                sb.append(el);
            }
            sb.append("\n");

            T--;

        }

        System.out.println(sb);
    }
}
