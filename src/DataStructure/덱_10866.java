package src.DataStructure;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 덱_10866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if(command.equals("push_front")){
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }
            if(command.equals("push_back")){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            if(command.equals("pop_front")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                } else{
                    sb.append(deque.removeFirst()).append("\n");
                }
            }
            if(command.equals("pop_back")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.removeLast()).append("\n");
                }
            }
            if(command.equals("size")){
                sb.append(deque.size()).append("\n");
            }
            if(command.equals("empty")){
                if(deque.isEmpty()){
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
            if(command.equals("front")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.getFirst()).append("\n");
                }
            }
            if(command.equals("back")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.getLast()).append("\n");
                }
            }

        }

        System.out.println(sb);
    }
}
