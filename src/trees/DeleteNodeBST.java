package trees;

/**
 * Created by libsys on 6/9/2022.
 */
public class DeleteNodeBST {
    public static TreeNode deleteNode(TreeNode root,int key){
       if(root == null)
           return null;
        if(root.val == key)
            return helper(root);
        TreeNode curr = root;
        while(curr != null){
            if(curr.val > key){
                if(curr.left!=null && curr.left.val == key) {
                    curr.left = helper(curr.left);
                    break;
                }else
                    curr = curr.left;
            }
            else{
                if(curr.right!=null && curr.left.val == key){
                    curr.right = helper(curr.right);
                    break;
                }else
                    curr = curr.right;
            }

        }
        return root;
    }
    public static TreeNode helper(TreeNode root){
        if(root.left==null && root.right==null)
            return null;
        if(root.left==null)
            return root.right;
        if(root.right==null)
            return root.left;
        TreeNode leftMaxNode = getMaxNode(root.left);
        TreeNode newRoot = root.left;
        leftMaxNode.right = root.right;
        return root.left;
    }
    public static TreeNode getMaxNode(TreeNode root){
        if(root.right == null)
            return root;
        return getMaxNode(root.right);
    }
}

