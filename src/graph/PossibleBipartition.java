package graph;

import java.util.*;

/**
 * Created by libsys on 12/29/2022.
 */
public class PossibleBipartition {
    public static boolean isPossible(int n,int[][] dislikes){
        /**generate AL**/
        List<List<Integer>> al = getAL(n,dislikes);
        boolean[] visited = new boolean[n+1];
        Set<Integer> g1 = new HashSet<>();
        Set<Integer> g2 = new HashSet<>();
        for(int i=1;i<=n;i++){
            if(visited[i])  continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            g1.add(i);
            visited[i] = true;
            while (!queue.isEmpty()){
                int size = queue.size()-1;
                while(size-->=0){
                    Integer curr = queue.poll();
                    for(int dislike:al.get(curr)){
                        if(visited[dislike]){
                            if((g1.contains(dislike) && g1.contains(curr)) || (g2.contains(dislike) && g2.contains(curr)))    return false;
                        } else {
                            if(g1.contains(curr))   g2.add(dislike);
                            else if(g2.contains(curr))  g1.add(dislike);
                            queue.add(dislike);
                            visited[dislike] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static List<List<Integer>> getAL(int n,int[][] edges){
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<=n;i++){
            al.add(new ArrayList<Integer>());
        }

        for(int[] edge:edges){
            al.get(edge[0]).add(edge[1]);
        }
        return al;
    }
    public static void main(String[] args){
        System.out.println(isPossible(4,new int[][]{{1,2},{1,3},{2,4}}));
        System.out.println(isPossible(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        System.out.println(isPossible(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5},{1,5}}));
        System.out.println(isPossible(8,new int[][]{{2,3},{3,4},{3,5},{6,7},{6,8},{7,7}}));

    }
}
