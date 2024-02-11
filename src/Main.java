package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = br.readLine();

        int[] arr = new int[n.length()];

        Character[] chars = new Character[n.length()];

        for(int i = 0; i < n.length(); i++){
            chars[i] = n.charAt(i);
        }

        Arrays.sort(chars);

        for(int i = chars.length - 1; i >= 0; i--){
            sb.append(chars[i]);
        }

        System.out.println(sb);

    }
}
