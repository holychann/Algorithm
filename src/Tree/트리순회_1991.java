package src.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 트리순회_1991 {

    static int N;
    static Map<Integer, Character> tree;
    static String preorder = "";
    static String inorder = "";
    static String postorder = "";
    static int lastIndex = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        tree = new HashMap<>();
        int[] alphabet = new int[27];
        alphabet[1] = 1;

        tree.put(1, 'A');


        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);


            if(Character.isLetter(b)){
                tree.put(alphabet[a - 'A' + 1] * 2, b);
                alphabet[b - 'A' + 1] = alphabet[a - 'A' + 1] * 2;
                lastIndex = Math.max(lastIndex, alphabet[a - 'A' + 1] * 2);
            }
            if(Character.isLetter(c)){
                tree.put(alphabet[a - 'A' + 1] * 2 + 1, c);
                alphabet[c - 'A' + 1] = alphabet[a - 'A' + 1] * 2 + 1;
                lastIndex = Math.max(lastIndex, alphabet[a - 'A' + 1] * 2 + 1);
            }


        }

        preorderTraversal(1);
        inorderTraversal(1);
        postorderTraversal(1);

        StringBuilder sb = new StringBuilder();

        sb.append(preorder).append('\n');
        sb.append(inorder).append('\n');
        sb.append(postorder).append('\n');

        System.out.println(sb);

    }

    // node: default value == 1;
    static void preorderTraversal(int node){

        if(node > lastIndex || !tree.containsKey(node)) return;

        if(Character.isLetter(tree.get(node))){
            preorder += tree.get(node);
            preorderTraversal(node * 2);
            preorderTraversal(node * 2 + 1);
        }

    }

    static void inorderTraversal(int node){
        if(node > lastIndex || !tree.containsKey(node)) return;
        inorderTraversal(node * 2);
        if(Character.isLetter(tree.get(node))){
            inorder += tree.get(node);
        }
        inorderTraversal(node * 2 + 1);
    }

    static void postorderTraversal(int node){
        if(node > lastIndex || !tree.containsKey(node)) return;

        postorderTraversal(node * 2);
        postorderTraversal(node * 2 + 1);
        if(Character.isLetter(tree.get(node))){
            postorder += tree.get(node);
        }
    }


}
