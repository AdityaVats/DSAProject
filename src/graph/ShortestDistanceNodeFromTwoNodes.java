package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by libsys on 1/25/2023.
 */
public class ShortestDistanceNodeFromTwoNodes {

    public static int getMinDis(int[] edges,int node1,int node2){
        int n = edges.length;
        int[] visitedFromNode1 = new int[n];
        int[] visitedFromNode2 = new int[n];
        for(int i=0;i<edges.length;i++){
            visitedFromNode1[i] = -1;
            visitedFromNode2[i] = -1;
        }
        bfs(edges,node1,visitedFromNode1);
        bfs(edges,node2,visitedFromNode2);
        int minDis = Integer.MAX_VALUE;
        int node = -1;
        for(int i=0;i<n;i++){
            if(visitedFromNode1[i] == -1 || visitedFromNode2[i] == -1)  continue;
            int dis = visitedFromNode1[i]+visitedFromNode2[i];
            if(dis < minDis){
                minDis = dis;
                node = i;
            }
        }
        return node;

    }
    public static void bfs(int[] edges,int node1,int[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node1);
        int level = 0;
        visited[node1] = level++;
        while(!queue.isEmpty()){
            int size = queue.size()-1;
            while(size-->=0){
                int curr = queue.poll();
                int next = edges[curr];
                if(next == -1)          continue;
                if(visited[next] != -1) continue;
                visited[next] = level;
                queue.offer(next);
            }
            level++;
        }

    }
    public static void main(String[] args){
        System.out.println(getMinDis(new int[]{2,2,3,-1},0,1));
        System.out.println(getMinDis(new int[]{1,2,-1}, 0, 2));
    }
}
