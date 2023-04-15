package graph;

import java.util.*;

/**
 * Created by libsys on 11/4/2022.
 */
public class WordLadder {

    public static int wordLadder(String word,String endWord,List<String> wordList){
        List<List<Integer>> al = new ArrayList<>();
        /**O(n.n.m)
         * n => word List size
         * m => each word size*/
        for(int i=0;i<wordList.size();i++){
            al.add(new ArrayList<>());
            String keyWord = wordList.get(i);
            for(int j=0;j<wordList.size();j++){
                if(i==j)    continue;
                String valueWord = wordList.get(j);
                for(int itr = 0;itr<keyWord.length();itr++){
                    String keyString = keyWord.substring(0,itr) + (itr==keyWord.length()-1 ? "" : keyWord.substring(itr+1));
                    String valueString = valueWord.substring(0,itr) + (itr==keyWord.length()-1 ? "" : valueWord.substring(itr+1));
                    if(keyString.equals(valueString))   al.get(i).add(j);

                }
            }
        }
        int start = -1;
        int end = -1;
        for(int i=0;i<wordList.size();i++){
            if(wordList.get(i).equals(word))    start = i;
            if(wordList.get(i).equals(endWord)) end = i;
        }
        if(start == -1){
            al.add(new ArrayList<>());
            for(int j=0;j<wordList.size();j++){
                String keyWord = word;
                String valueWord = wordList.get(j);
                for(int itr = 0;itr<word.length();itr++){
                    String keyString = keyWord.substring(0,itr) + (itr==keyWord.length()-1 ? "" : keyWord.substring(itr+1));
                    String valueString = valueWord.substring(0,itr) + (itr==keyWord.length()-1 ? "" : valueWord.substring(itr+1));
                    if(keyString.equals(valueString))   al.get(wordList.size()).add(j);
                }
            }
            start = wordList.size();
        }
        System.out.println(al);
        return shortestPath(start,end,al);


    }
    /**O(n)**/
    public static int shortestPath(int start,int end,List<List<Integer>> al){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[al.size()];
        int ans = Integer.MAX_VALUE;
        queue.add(start);
        visited[start] = true;
        int level=0;
        while (!queue.isEmpty()){
            int itr = queue.size()-1;
            while(itr-->=0){
                int curr = queue.poll();
                if(curr == end){
                    return level;
                } else {
                    for(int e:al.get(curr))
                        if(!visited[e]){
                            visited[e] = true;
                            queue.add(e);
                        }
                }
            }
            level++;

        }
        return 0;

    }
    public static int wordLadderCleaner(String beginWord,String endWord,List<String> wordList){


        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);

        queue.add(beginWord);
        if(wordSet.contains(beginWord)) visited.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size()-1;
            while(size-->=0){
                String currWord = queue.poll();
                if(currWord.equals(endWord))    return level;

                for(int i=0;i<currWord.length();i++){
                    for(int j=0;j<26;j++){
                        String str = currWord.substring(0,i) + (char)(j+(int)'a')+(i==currWord.length() ? "" : currWord.substring(i+1));
                        if(wordSet.contains(str)){
                            if(!visited.contains(str)){
                                queue.add(str);
                                visited.add(str);
                            }
                        }
                    }
                }
            }
            level++;
        }
        return 0;


    }
    public static void main(String[] args){
        System.out.println(wordLadder("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(wordLadder("hit","cog",Arrays.asList("hot","dot","dog","lot","log")));
        System.out.println(wordLadderCleaner("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(wordLadderCleaner("hit", "cog", Arrays.asList("hot", "dot","dog","lot","log")));
    }
}
