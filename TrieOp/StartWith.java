package TrieOp;

public class StartWith {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        public Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){ // O(L), L: length of the largest word
        Node curr = root;
        for(int level = 0; level < word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();  
            }
            curr=  curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean startWith(String word){
        Node curr = root;
        for(int level = 0; level < word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }
    public static void main(String[] args) {
        String words[] = {"apple", "app", "mango", "man", "woman"};
        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }
        String prefix1 = "app";
        String prefix2 = "moon";
        System.out.println(startWith(prefix1));
        System.out.println(startWith(prefix2));
    }
}
