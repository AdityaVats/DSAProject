package trees;

/**
 * Created by libsys on 10/14/2022.
 */
public class RecoverBST {
    public static void recoverBST(TreeNode root){
        helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static TreeNode helper(TreeNode root,int min,int max){
        if(root == null)    return null;
        // i am a faulty node
        if( root.val < min || max < root.val ){
            return root;
        }
        TreeNode faultyNode = null;
        if( root.left != null ) faultyNode = helper(root.left,min,root.val);
        if(faultyNode != null){
            // faulty with me
            if(root.val < faultyNode.val){
                int temp = root.val;
                root.val = faultyNode.val;
                faultyNode.val = temp;
                return null;
            }
            return  faultyNode;
        }
        if( root.right != null) faultyNode = helper(root.right,root.val,max);

        if(faultyNode != null){
            // fault with me
            if(faultyNode.val < root.val){
                int temp = root.val;
                root.val = faultyNode.val;
                faultyNode.val = temp;
                return null;
            }
            return  faultyNode;
        }
        // no fault in this tree
        return  null;
    }
    public static  void main(String[] args){
        TreeNode root = SerializeDeserializeTree.deserialize("3,1,4,#,#,2,#,#,#");
        root = SerializeDeserializeTree.deserialize("1,3,#,#,2,#,#");
        System.out.println(root);
        recoverBST(root);
        System.out.println(root);
    }
}
