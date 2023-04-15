package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by libsys on 11/14/2022.
 */
public class TrianglePathSum {
    static List<List<Integer>> dp;
    public static int minPathSum(List<List<Integer>> triangle){
        dp = new ArrayList<>();
        for(int i=0;i<triangle.size();i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<triangle.get(i).size();j++)
                list.add(0);
            dp.add(list);
        }
        return helperDPOptimal(triangle);
    }
    public static int helper(List<List<Integer>> triangle,int i,int j){
        if(i==triangle.size()-1)  return triangle.get(i).get(j);

        int smallAns1 = triangle.get(i).get(j) + helper(triangle,i+1,j);
        int smallAns2 = triangle.get(i).get(j) + helper(triangle,i+1,j+1);

        int ans = Math.min(smallAns1, smallAns2);
        return ans;

    }
    //Space O(n.n)
    public static int helperDP(List<List<Integer>> triangle){
        int n = triangle.size();
        dp = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<triangle.get(i).size();j++)
                list.add(0);
            dp.add(list);
        }
        for(int i=0;i<triangle.get(n-1).size();i++)    dp.get(n-1).set(i, triangle.get(n - 1).get(i));
        for(int i=n-2;i>=0;i--){
            for(int j=triangle.get(i).size()-1;j>=0;j--){
                int smallAns1 = triangle.get(i).get(j) + dp.get(i+1).get(j);
                int smallAns2 = triangle.get(i).get(j) + dp.get(i+1).get(j+1);
                int smallAns = Math.min(smallAns1,smallAns2);
                dp.get(i).set(j,smallAns);

            }
        }
        return dp.get(0).get(0);
    }
    //Space O(n)
    public static int helperDPOptimal(List<List<Integer>> triangle) {
        List<Integer> prevLevel = new ArrayList<>();
        int n = triangle.size();
        for(int i=0;i<n;i++)    prevLevel.add(triangle.get(n-1).get(i));

        for(int i=n-2;i>=0;i--){
            for(int j=prevLevel.size()-2;j>=0;j--){
                int smallAns1 = triangle.get(i).get(j) + prevLevel.get(j);
                int smallAns2 = triangle.get(i).get(j) + prevLevel.get(j+1);
                int smallAns = Math.min(smallAns1,smallAns2);
                prevLevel.set(j+1,smallAns);
            }
            prevLevel = prevLevel.subList(1,prevLevel.size());
        }
        return prevLevel.get(0);
    }
    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.stream(new int[]{2}).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(new int[]{3,4}).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(new int[]{6,5,7}).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(new int[]{4,1,8,3}).boxed().collect(Collectors.toList()));
        System.out.println(minPathSum(list));

        list = new ArrayList<>();

        list.add(Arrays.stream(new int[]{-10}).boxed().collect(Collectors.toList()));
        System.out.println(minPathSum(list));

    }
}
