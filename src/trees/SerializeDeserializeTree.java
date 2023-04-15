package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by libsys on 6/23/2022.
 */

public class SerializeDeserializeTree {
    private final static char delim = ',';
    private final static char nullVal = '#';
    public static String serialize(TreeNode root){
        if(root == null) return "";
        String str = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size()-1;
            while(n-->=0) {
                TreeNode curr = queue.poll();
                str += curr.val + delim;
                if (curr != null) {
                    queue.add(curr.left);
                    queue.add(curr.right);
                }

            }
        }
        return str;
    }
    public static  TreeNode deserialize(String data){
        if(data==null || data.isEmpty())
            return null;
        String[] parts = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        if(!parts[0].equalsIgnoreCase(nullVal+"")){
            root = new TreeNode(Integer.parseInt(parts[0]));
            queue.add(root);
        }
        for(int i=1;i<parts.length;i+=2){
            String part = parts[i];
            TreeNode curr = queue.poll();

            if(i<parts.length){
                String left = parts[i];
                if(!left.equalsIgnoreCase(nullVal+"")){
                    TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                    curr.left = leftNode;
                    queue.add(leftNode);
                }
            }
            if(i+1<parts.length){
                String right = parts[i+1];
                if(!right.equalsIgnoreCase(nullVal+"")){
                    TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                    curr.right = rightNode;
                    queue.add(rightNode);
                }
            }

        }
        return root;
    }
    public static void main(String[] args){
        System.out.println(deserialize("1,2,3,#,#,4,5,#,#,#,#"));
        System.out.println(deserialize(""));
        System.out.println(deserialize(null));
        System.out.println(deserialize("1,#,3,#,#"));
    }
}
