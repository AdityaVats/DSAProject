package trees;

import java.util.*;

/**
 * Created by libsys on 1/13/2023.
 */
public class LongestPathWithDiffAdjacentCharacters {
    static int longestPath;
    /**DFS Sol.**/
    public static int getMax(int[] parent,String s){
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<parent.length;i++)    al.add(new ArrayList<>());
        for (int i=1;i<parent.length;i++){
            al.get(parent[i]).add(i);
        }
        longestPath = 0;
        dfs(0, -1, al, s);
        return longestPath;
    }
    public static int dfs(int index,int parentIndex,List<List<Integer>> al,String s){

        /**Base case**/
        if(index == al.size())  return 0;

        PriorityQueue<Integer> topTwoPaths = new PriorityQueue<>();
        /**DFS in child nodes**/
        for(int child:al.get(index)){
            int smallAns = dfs(child,index,al,s);
            if(s.charAt(index) == s.charAt(child))  continue;
            topTwoPaths.offer(smallAns);
            if(topTwoPaths.size() == 3) topTwoPaths.poll();
        }



        if(topTwoPaths.size() == 0){
            longestPath = Math.max(longestPath,1);
            return 1;
        }

        int max2 = topTwoPaths.poll();
        int max1 = topTwoPaths.isEmpty() ? -1 : topTwoPaths.poll();

        /**path that passes through current node**/
        if(max1 != -1){
            int pathThroughIndex = max2 + 1 + max1;
            longestPath = Math.max(longestPath,pathThroughIndex);
        }

        int endHere = ( max1 == -1 ? max2 : max1 ) + 1;
        /***path that ends on the current node**/
        longestPath = Math.max(longestPath,endHere);
        return endHere;
    }
    public static void main(String[] args){
        System.out.println(getMax(new int[]{-1,0,0,1,1,2},"abacbe"));
        System.out.println(getMax(new int[]{-1,0,0,0},"aabc"));
        System.out.println(getMax(new int[]{-1,0,0,2,3,2,4},"aaaxaax"));

    }
}
