package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by libsys on 12/23/2022.
 */
public class KeysAndRooms {

    public static boolean canVisit(int[][] rooms){
        int n = rooms.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()){
            int size = queue.size()-1;
            while(size-->=0){
                Integer curr = queue.poll();

                for(int keys:rooms[curr]){
                    if(visited[keys])   continue;
                    queue.add(keys);
                    visited[keys] = true;
                }
            }
        }

        for(boolean visitRoom:visited)   if(!visitRoom)  return false;
        return true;
    }
    public static void main(String[] args){
        System.out.println(canVisit(new int[][]{{1},{2},{3},{}}));
        System.out.println(canVisit(new int[][]{{1,3},{3,0,1},{2},{0}}));
    }
}
