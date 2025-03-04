package src.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ox퀴즈_8958 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            String input = br.readLine();

            int score_all = 0;
            int score_cur = 0;

            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == 'O'){
                    score_all += ++score_cur;
                } else {
                    score_cur = 0;
                }
            }

            sb.append(score_all).append("\n");

        }

        System.out.println(sb);

    }
}
