import java.util.*;

/**
 * Created by libsys on 5/25/2022.
 */
public class MaxSumPath {

    public static List<TreeNode> bottomViewTree(TreeNode root){
        List<Pair2> list = new ArrayList<>();
        List<TreeNode> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<Pair2> queue = new LinkedList<>();
        List<List<Pair2>> bfs = new ArrayList<>();
        Set<Integer> hDistanceSet = new HashSet<>();
        queue.add(new Pair2(root,0));
        hDistanceSet.add(0);
        while(!queue.isEmpty()){
            int n = queue.size()-1;
            List<Pair2> currLevelNodes = new ArrayList<>();
            while(n-->=0){
                Pair2 pair = queue.poll();
                currLevelNodes.add(pair);
                TreeNode curr = pair.node;
                int currHdis = pair.hdis;
                hDistanceSet.add(currHdis-1);
                hDistanceSet.add(currHdis+1);
                if(curr.right != null)
                    queue.add(new Pair2(curr.right,currHdis-1));
                if(curr.left != null)
                    queue.add(new Pair2(curr.left,currHdis+1));
            }
            bfs.add(currLevelNodes);
        }
        for(int i =bfs.size()-1;i>=0;i--){
            if(hDistanceSet.isEmpty())
                break;
            List<Pair2> currLevel = bfs.get(i);
            for(Pair2 pair:currLevel){
                if(hDistanceSet.contains(pair.hdis)) {
                    list.add(pair);
                    hDistanceSet.remove(pair.hdis);
                }
            }
        }
        Collections.sort(list,(o1,o2) -> o1.hdis - o2.hdis);
        for(Pair2 pair:list)
            result.add(pair.node);
        return result;
    }
    public static List<TreeNode> bottomViewTreOptimised(TreeNode root){
        List<TreeNode> result = new ArrayList<>();

        if(root == null)
            return result;
        Map<Integer,TreeNode> map = new TreeMap<>();
        Queue<Pair2> queue = new LinkedList<>();
        queue.add(new Pair2(root,0));
        map.put(0, root);
        while(!queue.isEmpty()){
            int n = queue.size()-1;
            while(n-->=0){
                Pair2 pair = queue.poll();
                TreeNode curr = pair.node;
                int currHdis = pair.hdis;
                if(curr.left!=null){
                    queue.add(new Pair2(curr.left,currHdis-1));
                    map.put(currHdis-1,curr.left);
                }
                if(curr.right!=null){
                    queue.add(new Pair2(curr.right,currHdis+1));
                    map.put(currHdis+1,curr.right);
                }
            }
        }
        for(int key:map.keySet())
            result.add(map.get(key));
        return result;
    }
    public static List<Integer> pathToNode(TreeNode root,int val){
        List<Integer> list = new ArrayList<>();
        pathToNodeHelper(root,val,list);
        return list;
    }
    public static boolean pathToNodeHelper(TreeNode root,int val,List<Integer> list){
        if(root == null)
            return false;

        list.add(root.val);
        if(root.val == val)
            return true;
        if(pathToNodeHelper(root.left,val,list) || pathToNodeHelper(root.right,val,list))
            return true;
        list.remove(list.size() - 1);
        return false;
    }
    public static List<List<Integer>> preOrderPostOrderInOrderinOneTraversal(TreeNode root){
        Stack<Pair> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        stack.push(new Pair(root,1));
        while(!stack.isEmpty()){
            Pair top = stack.pop();
            TreeNode curr = top.node;
            int state = top.state;
            if(top.node == null)
                continue;
            if(top.state == 1 || top.state == 2) {
                top.state++;
                stack.push(top);
            }
            if(state == 1){
                preOrder.add(curr.val);
                stack.push(new Pair(curr.left,1));
            }else if(state == 2){
                inOrder.add(curr.val);
                stack.push(new Pair(curr.right,1));
            }else{
                postOrder.add(curr.val);
            }
        }
        result.add(preOrder);
        result.add(inOrder);
        result.add(postOrder);
        return result;

    }
}
class Tree{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public Tree(int val){
        this.val = val;
    }
}
class Pair2{
    TreeNode node;
    int hdis;
    public Pair2(TreeNode node,int hdis){
        this.node = node;
        this.hdis = hdis;
    }

}