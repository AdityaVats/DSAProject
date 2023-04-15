package trees;

/**
 * Created by libsys on 9/14/2022.
 */
public class PseudoPalindromicPaths {
    public static int getPaths(TreeNode root){
        return helper(root,new int[10],0);
    }
    public static int helper(TreeNode root,int[] freq,int count){
        if(root==null)  return 0;
        freq[root.val]++;
        count++;
        if(root.left == null && root.right == null){
            if(count%2==0){
                for(int e:freq) {
                    if (e % 2 != 0) {
                        count--;
                        freq[root.val]--;
                        return 0;
                    }
                }
                count--;
                freq[root.val]--;
                return 1;
            }else{
                boolean hasOdd = false;
                for(int e:freq){
                    if(e%2 !=0){
                        if(hasOdd) {
                            count--;
                            freq[root.val]--;
                            return 0;
                        }
                        hasOdd = true;
                    }
                }
                count--;
                freq[root.val]--;
                return hasOdd ? 1 : 0;
            }

        }
        int ans = helper(root.left,freq,count)+helper(root.right,freq,count);
        count--;
        freq[root.val]--;
        return ans;
    }
    public static void main(String[] args){
        TreeNode root = SerializeDeserializeTree.deserialize("10"+",5,20"+",5,7,15,23"+",1,2,#,#,15,#,22,25"+",#,#,#,#,15,#,#,#,#,#"+",#,16"+",16,17,#,#,17,#,17,#,17,#,#,#");
        root = SerializeDeserializeTree.deserialize("10"+",10,10"+",10,10,10,11"+",9,10,#,#,#,#,#,#"+",#,#,10,#"+",#,#");
        root = SerializeDeserializeTree.deserialize("1,2,3,#,#,4,5,#,#,#,#");
        root = SerializeDeserializeTree.deserialize("2,3,1,3,1,#,1,#,#,#,#");
        root = SerializeDeserializeTree.deserialize("2,1,1,1,3,#,#,#,#,#,1");

        //System.out.println(root);

        System.out.println(getPaths(root));
    }
}
