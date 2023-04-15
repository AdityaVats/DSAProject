package trees;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by libsys on 6/22/2022.
 */
public class InvertTree {
    //dfs
    public static TreeNode originalCode(TreeNode node){
        if(node == null) return node;

        TreeNode originalLeft = originalCode(node.left);
        TreeNode originalRight = originalCode(node.right);
        node.left = originalRight;
        node.right = originalLeft;
        return node;
    }
    // 2 stack prev current
    //bfs
    // not optimal
    public static TreeNode bfs(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> prevStack = new Stack<>();
        Stack<TreeNode> currStack = new Stack<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size()-1;
            while(n-->=0){
                TreeNode node = queue.poll();

                if(node != null){
                    prevStack.push(node);
                    queue.add(node.left);
                    queue.add(node.right);
                    currStack.push(node.left);
                    currStack.push(node.right);
                }
            }
            int nx = prevStack.size()-1;
            while(nx-->=0){
                TreeNode parent = prevStack.pop();
                parent.left = currStack.pop();
                parent.right = currStack.pop();
            }
        }

        return root;
    }
    // better way using only 1 queue
    // swap left and right when polling the element
    public static TreeNode bfsBetter(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size()-1;
            while(n-->=0){
                TreeNode curr = queue.poll();

                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(1,new TreeNode(0),new TreeNode(2,null,new TreeNode(3))),
                new TreeNode(6,new TreeNode(5),new TreeNode(7,null,new TreeNode(8))));
        System.out.println(root);
        bfsBetter(root);
        System.out.println(root);

    }
}
