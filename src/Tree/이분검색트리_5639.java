package src.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이분검색트리_5639 {

    static ArrayList<Integer> arr;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new ArrayList<>();

        while(true){
            String num = br.readLine();
            if(num == null || num.equals("")) break;

            arr.add(Integer.parseInt(num));
        }




        result = new ArrayList<>();

        getPostorder(0, arr.size() - 1);

        StringBuilder sb = new StringBuilder();

        for(int el : result){
            sb.append(el).append('\n');
        }

        System.out.println(sb);

    }

    // start: dv = 0; end: dv = arr.length - 1
    static void getPostorder(int start, int end){
        if(start > end) return;

        if(start == end) {
            result.add(arr.get(start));
            return;
        }

        int pointIdx = end + 1;
        int loot = arr.get(start);

        for(int i = start + 1; i <= end; i++){
            if(loot < arr.get(i)) {
                pointIdx = i;
                break;
            }
        }

        getPostorder(start + 1, pointIdx - 1);
        if(pointIdx != end + 1){
            getPostorder(pointIdx, end);
        }


        result.add(arr.get(start));


    }


}
