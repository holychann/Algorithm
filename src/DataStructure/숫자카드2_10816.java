package src.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자카드2_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer nums = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(nums.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++){
            int result = map.getOrDefault(Integer.parseInt(st.nextToken()), 0);
            sb.append(result).append(" ");

        }

        System.out.println(sb);




    }
}
