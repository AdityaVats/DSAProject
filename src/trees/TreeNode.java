package trees;

/**
 * Created by libsys on 6/9/2022.
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    /*public String toString(){
        String s = val+"\t";
        if(left != null){
           s+= left.toString()+"\t";
        }else{
            s+="null\t";
        }
        if(right != null){
            s+= right.toString()+"\t";
        }else{
           s+="null";
        }
        return s;
    }*/

    @Override
    public String toString() {
        return "TreeNode{" +
                " val=" + val +
                ", left=" + left +
                ", right=" + right+
                "}";
    }
}
