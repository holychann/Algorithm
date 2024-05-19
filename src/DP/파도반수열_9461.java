package src.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.StringCharacterIterator;
import java.util.ArrayList;

public class 파도반수열_9461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        ArrayList<Long> triangle = new ArrayList();

        // 초기값
        triangle.add(0L);
        triangle.add(1L);
        triangle.add(1L);
        triangle.add(1L);

        int last = 3;

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            if(n < last){
                sb.append(triangle.get(n)).append("\n");
                continue;
            }

            if(n >= 4){
                for(int i = 4; i <= n; i++){
                    long sum = triangle.get(i - 3) + triangle.get(i - 2);
                    triangle.add(i, sum);
                    last = i;
                }
            }

            sb.append(triangle.get(n)).append("\n");


        }

        System.out.println(sb);


    }
}
