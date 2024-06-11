package src.DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐_10845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.contains("push")){
                queue.add(Integer.parseInt(st.nextToken()));
            }
            if(command.contains("pop")){
                if(queue.isEmpty()){
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            if(command.contains("size")){
                sb.append(queue.size()).append("\n");
            }
            if(command.contains("empty")){
                if(queue.isEmpty()){
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
            if(command.contains("front")){
                if(queue.isEmpty()){
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                }
            }
            if(command.contains("back")){
                if(queue.isEmpty()){
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.getLast()).append("\n");
                }
            }
        }

        System.out.println(sb);

    }
}
