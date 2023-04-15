package ms;

/**
 * Created by libsys on 1/2/2023.
 */

import trees.TreeNode;

/**Trie ==> prefix stsrts with
 *
 *
 * Suffix from chaarcter array should exactly match with on of the words
 * ab   sb  cd  f   kcm     Reverse all of them ====>     ba  bs    dc  f   mck
 *  Create a trie by reversing the words
 *      b           d           f           m
 *    a  s         c                       c
 *                                        k
 *
 *
 *
 *
 *  Store these characters in char Array
 * F    T   F   F   F   F   T   F   F   F   T
 * a    b   c   x   x   d   f   c   k   c   m
 *iteratre from end to start manner
 *  see for match in the trie
 *
 *  TLE
 *
 *
 *  Imrpove hint:   use pointers
 *
 *
 * **/
public class StreamCharactersSuffix {
    String[] words;
    StringBuilder sb;
    Trie trie;
    public StreamCharactersSuffix(String[] words){
        this.words = words;
        trie = new Trie();
        for(String word:words){
            String reverseWord = new StringBuilder(word).reverse().toString();
            trie.insert(reverseWord);
        }
        sb = new StringBuilder();
    }
    public boolean query(Character character){
        sb.append(character);
        StringBuilder suffixBuilder = new StringBuilder();
        for(int i=sb.length()-1;i>=0;i--){
            suffixBuilder.append(sb.charAt(i));
            if(trie.search(suffixBuilder.toString()))   return true;
        }
        return false;
    }

    public static void main(String[] args){
        StreamCharactersSuffix streamCharactersSuffix = new StreamCharactersSuffix(new String[]{"ab","sb","cd","f","kcm"});
        String str = "abcxxdfckcm";
        for(int i=0;i<str.length();i++)        System.out.println(streamCharactersSuffix.query(str.charAt(i)));
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    class TrieNode{
        boolean isWord;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    public void insert(String word){
        insertHelper(word,0,root);
    }
    private  void insertHelper(String word,int index, TrieNode node){
        if(index == word.length()){
            node.isWord = true;
            return;
        }
        int childIndex = word.charAt(index) - 'a';
        if(node.children[childIndex] == null)   node.children[childIndex] = new TrieNode();
        insertHelper(word,index+1,node.children[childIndex]);

    }
    public boolean search(String word){
        return searchHelper(word,0,root);
    }
    private boolean searchHelper(String word,int index,TrieNode node){
        if(index == word.length())  return node.isWord;

        int childIndex = word.charAt(index) - 'a';

        if(node.children[childIndex] == null)   return false;

        return searchHelper(word,index+1,node.children[childIndex]);
    }
}
