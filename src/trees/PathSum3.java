package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by libsys on 10/4/2022.
 */
public class PathSum3 {
    /**brute force*/
    public static int pathSum(TreeNode root,int target){
        if(root == null)    return 0;
        if(root.val == target)  return 1;
        int ans = 0;
        ans+=pathSum(root.left,target);
        ans+=pathSum(root.right, target);
        ans+=dfs(root,target);
        return ans;
    }
    public static int dfs(TreeNode root,int target){
        if(root == null)    return 0;
        if(root.val == target)  return 1;
        return dfs(root.left,target-root.val) + dfs(root.right,target-root.val);
    }
    public static void main(String[] args){
        TreeNode root = SerializeDeserializeTree.deserialize("10"+",5,-3"+",3,2,#,11"+",3,-2,#,1,#,#");
        //root = SerializeDeserializeTree.deserialize("5,4,8,11,#,13,4,7,2,#,#,5,1");
        System.out.println(pathSumBetterApproach(root,8));
    }
    /**using sub array logic**/
    public static int pathSumBetterApproach(TreeNode root,int target){
        Map<Integer,Integer> prefixSumToCountMap = new HashMap<>();
        /***
         *   consider this
             1->2->3
             target 6
             Condition at root 3
             sum = 6;
             map {1=1,3=1}
             in map we would search sum- target (6-6=0)
             but it wont be in the map and hence it wont add to our ans
             hence a base case value needs to be added to map
             sum = 0 and count = 1 for this
             map {0=1,1=1,3=1}

         prefixSumToCountMap.put(0,1);
         ***/
        return helper(root,target,prefixSumToCountMap,0);
    }
    public static int helper(TreeNode root,int target,Map<Integer,Integer> prefixSumToCountMap,int sum){
        if(root==null)  return 0;
        System.out.println(root.val + " " +prefixSumToCountMap);

        sum+=root.val;
        int ans = 0;
        if(prefixSumToCountMap.containsKey(sum-target)) ans+=prefixSumToCountMap.get(sum-target);

        prefixSumToCountMap.put(sum, prefixSumToCountMap.getOrDefault(sum, 0) + 1);
        ans+=helper(root.left, target, prefixSumToCountMap, sum);
        ans+=helper(root.right,target,prefixSumToCountMap,sum);
        prefixSumToCountMap.put(sum, prefixSumToCountMap.get(sum) - 1);
        if(prefixSumToCountMap.get(sum)==0) prefixSumToCountMap.remove(sum);
        return ans;

    }
}
