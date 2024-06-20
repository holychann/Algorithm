package src.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 인사성밝은곰곰이_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Boolean> map = new HashMap<>();

        int count = 0;

        while(n-- > 0){
            String string = br.readLine();

            if(string.contains("ENTER")) {
                map.clear();
                continue;
            }

            if(!map.containsKey(string)){
                map.put(string, true);
                count++;
            }

        }

        System.out.println(count);

    }
}
