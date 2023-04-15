package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libsys on 1/10/2023.
 */
public class LeftView {

    public List<Integer> LeftLeftView(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        leftViewHelper(root,ans,0);
        return ans;
    }
    public void leftViewHelper(TreeNode root,List<Integer> ans,int level){
        if(root == null)    return;
        if(ans.size() == level) ans.add(root.val);
        leftViewHelper(root.left,ans,level+1);
        leftViewHelper(root.right,ans,level+1);
    }
    public void rightViewHelper(TreeNode root,List<Integer> ans,int level){
        if(root == null)    return;
        if(ans.size() == level) ans.add(root.val);
        leftViewHelper(root.right,ans,level+1);
        leftViewHelper(root.left,ans,level+1);
    }
}
