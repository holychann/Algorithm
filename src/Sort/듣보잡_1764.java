package src.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡_1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> arr = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();


        for(int i = 0; i < n; i++){
            arr.add(br.readLine());
        }

        for(int i = 0; i < m; i++){
            String s = br.readLine();

            boolean isSuc = arr.add(s);

            if(!isSuc){
                result.add(s);
            }
        }

        result.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();

        sb.append(result.size()).append('\n');

        for(String el : result){
            sb.append(el).append('\n');
        }

        System.out.println(sb);

    }
}
