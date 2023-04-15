package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by libsys on 3/15/2023.
 */
public class IsCompleteTree {

    public static boolean isComplete(TreeNode root){
        if(root == null)    return true;
        boolean isLastLevel = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode nullNode = new TreeNode(-1);
        while(!queue.isEmpty()){
            int size = queue.size()-1;
            while(size-->=0){
                TreeNode curr = queue.poll();
                if(curr.left == null){
                    isLastLevel = true;
                    queue.offer(nullNode);
                } else {
                    queue.offer(curr.left);
                }
                if(curr.right == null){
                    isLastLevel = true;
                    queue.offer(nullNode);
                } else {
                    queue.offer(curr.right);
                }
            }
            if(isLastLevel){
                return isValidLastLevel(queue,nullNode);
            }
        }
        return true;
    }
    public static boolean isValidLastLevel(Queue<TreeNode> queue,TreeNode nullNode){
        boolean nullFound = false;
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr != nullNode){
                if(curr.left != null || curr.right != null) return false;
                if(nullFound)                               return false;
            }
            if(curr == nullNode){
                nullFound = true;
            }
        }
        return true;
    }
    // cleaner code
    public static boolean isCompleteCleaner(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundNull = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->=0){
                TreeNode curr = queue.poll();
                if(curr.left == null){
                    foundNull = true;
                } else {
                    queue.offer(curr.left);
                }

                if(curr.right == null){
                    foundNull = true;
                } else {
                    queue.offer(curr.right);
                }
            }
            if(foundNull){
                while (!queue.isEmpty()){
                    TreeNode curr = queue.poll();
                    if(curr.left != null || curr.right != null) return false;
                }
                return  true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(isComplete(SerializeDeserializeTree.deserialize("1,2,3,4,5,6,7,8,9,#,10,#,#,#,#,#,#,#,#,#,#")));
    }
}
class Parent{
    public
    void funct(){

    }
}
class Child extends Parent{
    
}