package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by libsys on 2/28/2023.
 */
public class FindDuplicateSubTrees {

    public List<TreeNode> getDuplicates(TreeNode root){
        Map<String,List<TreeNode>> map = new HashMap<>();
        postorder(root,map);
        List<TreeNode> ans = new ArrayList<>();
        for(String key:map.keySet()){
            if(map.get(key).size() < 2) continue;
            ans.add(map.get(key).get(0));
        }
        return ans;
    }
    public String postorder(TreeNode root,Map<String,List<TreeNode>> map){
        if(root == null)    return "";
        String leftStr = postorder(root.left,map);
        String rightStr = postorder(root.right,map);
        String str = root.val + "#" + leftStr + "#" + rightStr;
        if(!map.containsKey(str))   map.put(str,new ArrayList<>());
        map.get(str).add(root);
        return str;
    }
    public static void main(String[] args){

    }
}
