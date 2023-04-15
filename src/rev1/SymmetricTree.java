package rev1;

import trees.TreeNode;

/**
 * Created by libsys on 3/13/2023.
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root){
        if(root == null)    return true;
        return symmetricHelper(root.left,root.right);
    }
    public static boolean symmetricHelper(TreeNode leftRoot,TreeNode rightRoot){
        if(leftRoot == null && rightRoot == null)   return true;
        if(leftRoot == null || rightRoot == null)   return false;
        return leftRoot.val == rightRoot.val && symmetricHelper(leftRoot.left,rightRoot.right) && symmetricHelper(leftRoot.right,rightRoot.left);
    }
}
