package trees;

/**
 * Created by libsys on 6/22/2022.
 */
public class DiameterOfTree {
    static int diameter=0;
    public static int originalFunction(TreeNode root){
       getDiameterOfTree(root);
       return diameter;
    }
    public static int getDiameterOfTree(TreeNode root){
        if(root == null) return 0;
        int maxLeftEdgePathCount = getDiameterOfTree(root.left);
        int maxRightEdgePathCount = getDiameterOfTree(root.right);
        diameter = Math.max(diameter,maxLeftEdgePathCount+maxRightEdgePathCount);
        return Math.max(maxLeftEdgePathCount,maxRightEdgePathCount)+1;

    }

}
