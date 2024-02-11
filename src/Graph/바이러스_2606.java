package src.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스_2606 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List[] computers = new List[n+2];

        for(int i = 0; i <= n; i++){
            computers[i] = new ArrayList<>();
        }


        boolean[] isVisited = new boolean[n+2];


        // 입력 && 분류
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[a].add(b);
            computers[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);

        while(!queue.isEmpty()){

            int computer = queue.remove();

            isVisited[computer] = true;

            for(Object com : computers[computer]){
                int curCom = (int) com;

                if(isVisited[curCom]) continue;

                queue.add(curCom);

                isVisited[curCom] = true;

            }

        }

        int answer = 0;

        for(boolean el : isVisited){
            if(el == true) {
                answer = answer + 1;
            }

        }

        System.out.println(answer - 1);


    }

}
