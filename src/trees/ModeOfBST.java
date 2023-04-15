package trees;

import java.util.*;

/**
 * Created by libsys on 7/7/2022.
 */
/**
 * Not able to do in 1 go
 * Approach was though wasn not able to code
 *
 * O(1) solution
 * 2 passes
 * in first pass calculate the highest number of recurrence in BST and count of such numbers
 * in second pass fill the arr o count size with those numbers
 * */
public class ModeOfBST {
    /**O(1) Sol ---------------------------------------------**/
    static int count = 0;
    static int[] result = null;
    static int prevVal = -1;
    static int currentFreq = 0;
    static int maxFreq = 0;

    public static int[] getModeOfBST(TreeNode root){
        inorder(root);
        result = new int[count];
        prevVal = -1;
        currentFreq = 0;
        count =0;
        inorder(root);
        return result;
    }
    public static void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }
    public static void handleValue(int val){
        if(prevVal == val){
            currentFreq++;
        }else{
            prevVal  = val;
            currentFreq = 0;
        }
        if(currentFreq>maxFreq){
            maxFreq = currentFreq;
            count=1;
        }else if(currentFreq == maxFreq){
            if(result == null){
                count++;
            }else{
                result[count++] = val;
            }
        }
    }





















    /**O(1) Sol ---------------------------------------------**/








    static int res = 0;
    static Set<Integer> set=new HashSet<>();
    public static int mode(TreeNode root){
        //if(root == null) return 0;
        helper(root);
        System.out.println(res);
        getNodes(root, res);
        System.out.println(Arrays.asList(set.toArray()));
        return res;
    }
    public static int helper(TreeNode root){
        if(root == null) return 0;

        int lc = helper(root.left);
        int rc = helper(root.right);

        res = Math.max(res,Math.max(lc,rc));

        int myResult = 1;
        if(root.left != null && root.left.val == root.val)
            myResult += lc;
        if(root.right != null && root.right.val == root.val)
            myResult += rc;


        res = Math.max(res,myResult);

        return myResult;
    }
    public static void getNodes(TreeNode root,int mode){
        if(root == null) return;
        if(mode == 0) return;
        if(mode==1 ){    set.add(root.val); }
        //dfs(root,0,mode);
        getNodes(root.left, mode);
        getNodes(root.right, mode);

    }

    public static void main(String[] args){

        TreeNode root = SerializeDeserializeTree.deserialize("10"+",5,20"+",5,7,15,23"+",1,2,#,#,15,#,22,25"+",#,#,#,#,15,#,#,#,#,#"+",#,16"+",16,17,#,#,17,#,17,#,17,#,#,#");
        root = SerializeDeserializeTree.deserialize("10"+",10,10"+",10,10,10,11"+",9,10,#,#,#,#,#,#"+",#,#,10,#"+",#,#");
        root = SerializeDeserializeTree.deserialize("1,2,3,#,#,4,5,#,#,#,#");
        //System.out.println(root);

        int[] ans = getModeOfBST(root);
        System.out.println();
    }


}
