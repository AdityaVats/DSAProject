package trees;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libsys on 6/20/2022.
 */
public class UniqueBSTList {
    public static List<TreeNode> getUniqueBST2(int n){
        return helper(1,n);
    }
    public static List<TreeNode> helper(int currVal,int endVal){
        List<TreeNode> res = new ArrayList<>();
        if(currVal > endVal){
            res.add(null);
            return res;
        }

        if(currVal == endVal){
            res.add(new TreeNode(currVal));
            return res;
        }
        for(int i=currVal;i<=endVal;i++){
            List<TreeNode> leftList = helper(currVal,i-1);
            List<TreeNode> rightList = helper(i+1,endVal);
            for(int j=0;j<leftList.size();j++){
                for(int k=0;k<rightList.size();k++){
                    TreeNode node = new TreeNode(i);
                    node.left = leftList.get(j);
                    node.right = rightList.get(k);
                    res.add(node);
                }
            }
        }

        return res;
    }

    public  static void main(String[] args){
        System.out.print(getUniqueBST2(3));
    }
}
