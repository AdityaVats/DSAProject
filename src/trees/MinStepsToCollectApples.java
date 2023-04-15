package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libsys on 1/11/2023.
 */
public class MinStepsToCollectApples {
    public static int getMin(int n,int[][] edges,boolean[] hasApple){
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<n;i++)    al.add(new ArrayList<Integer>());
        for(int[] edge:edges){
            al.get(edge[0]).add(edge[1]);

            al.get(edge[1]).add(edge[0]);
        }
        int ans = dfs(0,al,hasApple,-1);
        return ans>0 ? ans -2 : 0;
    }
    public static int dfs(int index,List<List<Integer>> al,boolean[] hasApple,int prevIndex){
        int ans = 0;
        for(int child:al.get(index)){
            if(prevIndex == child)  continue;
            int smallAns = dfs(child,al,hasApple,index);
            ans += smallAns;
        }

        if(ans == 0){
            if(hasApple[index]) return 2;
            else                return 0;
        }
        return ans+2;

    }
    public static void main(String[] args){
        System.out.println(getMin(
                7
                ,new int[][]{
                {0,1},
                {0,2},
                {1,4},
                {1,5},
                {2,3},
                {2,6}
                }
                ,new boolean[]{false,false,true,false,true,true,false}
        ));

        System.out.println(getMin(
                7
                ,new int[][]{
                        {0,1},
                        {0,2},
                        {1,4},
                        {1,5},
                        {2,3},
                        {2,6}
                }
                ,new boolean[]{false,false,true,false,false,true,false}
        ));

        System.out.println(getMin(
                7
                ,new int[][]{
                        {0,1},
                        {0,2},
                        {1,4},
                        {1,5},
                        {2,3},
                        {2,6}
                }
                ,new boolean[]{false,false,false,false,false,false,false}
        ));

        System.out.println(getMin(
                4
                ,new int[][]{
                        {0,1},
                        {0,3},
                        {1,2}
                }
                ,new boolean[]{false,true,false,false}
        ));
    }
}
