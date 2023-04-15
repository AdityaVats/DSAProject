import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import java.util.*;

/**
 * Created by libsys on 3/14/2022.
 */
public class Day10 {

    public static void sort(int[] arr){

        int low=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[low];
                arr[low] = temp;
                low++;
            }
        }
    }
    public static int kadane(int[] arr){
        int res=-1;
        int temp =0;
        for(int i=0;i<arr.length;i++){
            temp += arr[i];
            if(temp<0)
                temp=0;
            if(temp>res){
                res = temp;
            }
        }
        return res;
    }
    public static int[] processQueries(int[] queries,int m){
        Map<Integer,Integer> map = new HashMap<>();
        // val ---> index
        int valAtZero = 1;
        for(int i=0;i<m;i++){
            map.put(i+1,i);
        }
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){

            for(int key:map.keySet())
                System.out.println( key + " " + map.get(key) );

            int originalVal = queries[i];
            int originalIndex = map.get(originalVal);

            map.remove(originalVal);
            map.remove(valAtZero);

            map.put(originalVal,0);
            map.put(valAtZero,originalIndex);
            valAtZero = originalVal;
            res[i] = originalIndex;

        }
        return res;
    }
    public static List<String> stackOp(int[] target,int n){
        int[] res = new int[target.length];
        int k=0,z=0;
        List<String> op = new ArrayList<>();
        for(int i=1;i<=n;i++){

            op.add("Push");

            if(target[k] == i){
                k++;
                res[z++] = i;

            }else{
                op.add("POP");

            } if(k==target.length)
                break;

        }
        return op;
    }
    public static int city(int[][] costs){
        int ci=0,co=0,n=costs.length/2;
        int sum=0;
        while(ci < 2*n){
            int tempI=-1,min1=Integer.MAX_VALUE;
            for(int i=1;i<2*n;i++){

                if(min1>costs[i][0]){
                    tempI = i;
                    min1 = costs[i][0];
                }
            }
            if(tempI != -1){
                sum += costs[tempI][0];
                System.out.println(tempI);
                costs[tempI][0] = Integer.MAX_VALUE;
                costs[tempI][1] = Integer.MAX_VALUE;
                ci++;
            }

            tempI=-1;

            min1=Integer.MAX_VALUE;
            for(int i=1;i<2*n;i++){

                if(min1>costs[i][1]){
                    tempI = i;
                    min1 = costs[i][1];
                }
            }
            if(tempI != -1){
                sum += costs[tempI][1];
                costs[tempI][0] = Integer.MAX_VALUE;
                costs[tempI][1] = Integer.MAX_VALUE;
                System.out.println(tempI);
                ci++;
            }



        }
        return sum;
    }

    public static void combSum(List<List<Integer>> set,List<Integer> possibleList,List<Integer> nums,int target){

        for(int e:nums){
            if(e> target)
                continue;
            if(e == target){
                List<Integer> l = new ArrayList<>();
                l.addAll(possibleList);
                l.add(e);
                Collections.sort(l);
                if(!set.contains(l))
                    set.add(l);
                continue;
            }
            List<Integer> l = new ArrayList<>();
            l.addAll(possibleList);
            l.add(e);
            combSum(set, l, nums, target - e);

        }
    }

    public static boolean pod(int[] arr,int target){
        return false;
    }
    public static int[] searchInMatrix2(int[][] matrix,int target){
        int i=0,j=matrix[0].length-1;
        while(i<matrix.length && j>=0){
            if(matrix[i][j]==target){
                int[] res = {i,j};
                return res;
            }else if(target< matrix[i][j])
                j--;
            else
                i++;
        }
        return new int[2];
    }
    public static int searchElement(int[] arr,int target){
        int i=0,j=arr.length-1;
        int index = -1;
        int mid = i + (j-i+1)/2;
        while(i<= j){
            mid = i + (j-i+1)/2;
            if(mid-1>=i && mid+1<=j &&  arr[mid] < arr[mid-1]  && arr[mid]<=arr[mid+1])
            {
                index = mid;
                break;
            }
            if( arr[mid] <= arr[0])
                j = mid-1;
            else
                i = mid +1 ;
        }
        System.out.println(mid);

        i=0;j=arr.length-1;
        if(target>= arr[0] && target<=arr[mid]){
          i=0;j=mid;
          mid = i+(j-i+1)/2;
        }else{
            i=mid+1;j=arr.length-1;
        }
        while(i<=j){
            mid = i+(j-i+1)/2;
            if(arr[mid] == target)
                return mid;
            else if (arr[mid] <target)
                i = mid+1;
            else
                j = mid-1;
        }
        return -1;
    }

    public static boolean jumpGame(int[] nums){
        boolean[] jump = new boolean[nums.length];
        Arrays.fill(jump,false);
        jump[0] = true;
        for(int i=0;i<nums.length;i++){
            if(jump[nums.length-1] == true)
                return true;
            if(jump[i] == true){
                for(int j=1;j<=nums[i] && i+j<nums.length;j++){
                    jump[i+j] = true;
                }
            }
        }
        return jump[nums.length-1] == true;
    }
    public static void main(String[] args){
        /*  if(true){
            DoubleLinkedList node7 = new ListNode(7,null,null);
            ListNode node6 = new ListNode(6,node7,null);
            ListNode node5 = new ListNode(5,node6,null);
            ListNode node4 = new ListNode(4,node5,null);
            ListNode node3 = new ListNode(3,node4,null);
            ListNode node2 = new ListNode(2,node3,null);
            ListNode node1 = new ListNode(1,node2,null);

        }
    */






        int[] as = {1,2,3};
        System.out.print(combinationSum4(as, 4));
        int[] res = nextGreater(as);
        int[] p = {1,1,3};
        System.out.println(permute(p));
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6,node7);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        node1 = rotateList(node1,1);
        System.out.println(node1);




        String s  = " max(s.CopyTblPK.copyId ";
        int[] arr = {1,0,0,1,0};
        sort(arr);
        //int[][] tj = {{1,2},{2,3},{3,1}};
        //System.out.print(townJudge(3,tj));
        int[][] tj = {{1,2}};
    //    System.out.print(townJudge(2,tj));


        int[] a = {3,1,2,1};
        //int[] res = Day10.processQueries(a,5);


        int[] x  = {1,2,7};
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        //System.out.println(city(costs));
        int[][] matrix ={ {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

        Integer[] are = {2,3,4,6,7};
        List<List<Integer>> set = new ArrayList<>();
        combSum(set, new ArrayList<>(), Arrays.asList(are), 7);

        int[] searchinMatrix = searchInMatrix2(matrix,7);
        System.out.print(set);
        int[] aee= {1,2,3};
        System.out.println(searchElement(aee,9));
        System.out.println(jumpGame(aee));
/*        System.out.println(stackOp(x,8));
        System.out.print(arr);*/
    }





    public static void oddEvenList(ListNode head){
        ListNode p1=head,h1 = p1;
        ListNode p2=head.next,h2=p2;
        boolean flag = true;
        while(p1!=null && p2!=null){
            if(flag){
                p1.next = p2.next;
                p1 = p1.next;
                flag = false;
            }else{
                p2.next = p1.next;
                p2 = p2.next;
                flag = true;
            }
        }
        System.out.println(h1);
        System.out.println(h2);
        h2 = reverse(h2);

        p1 = h1;
        p2 = h2;


    }
    public static void reorderList(ListNode head){
        ListNode curr = head;
        int  n =0;
        while(curr!=null){
            curr = curr.next;
            n++;
        }
        int c= 0;
        if(n%2 ==0)
            c = n/2-1;
        else
            c = (n/2) ;
        curr = head;
        while(c--!=0){
            curr = curr.next;
        }
        ListNode curr2 = curr.next;
        curr.next = null;
        curr2 = reverse(curr2);
        curr= head;
        boolean flag = true;
        while(curr!=null && curr2 !=null){
            if(flag){
                flag = false;
                ListNode temp = curr.next;
                curr.next = curr2;
                curr = temp;
            }else{
                flag = true;
                ListNode temp = curr2.next;
                curr2.next = curr;
                curr2 = temp;
            }
        }
    }
    public static ListNode reverse(ListNode head){
        ListNode curr=head,prev=null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public static ListNode rotateList(ListNode head,int k){
        int n=0;
        ListNode curr = head;
        while(curr!=null){
            curr=curr.next;
            n++;
        }
        if(k%n==0)
            return head;
        if(k>n)
            k= n - k/n;
        else
           k = n-k;
        curr = head;
        while(k-->1)
            curr=curr.next;
        ListNode temp = curr.next;
        curr.next = null;
        curr = temp;
        if(curr.next!=null)
            curr=curr.next;
        curr.next = head;
        return temp;
    }
    public static ListNode mergeKLists(ListNode[] list){
        PriorityQueue<HoldObject> pq = new PriorityQueue<>((o1,o2) -> o1.node.val-o2.node.val);

        for(int i=0;i<list.length;i++){
            HoldObject obj = new HoldObject();
            obj.node = list[i];
            obj.listNum = i;
            pq.add(obj);
        }
        HoldObject holdNode = pq.poll();
        ListNode head = holdNode.node;
        while(holdNode.node!=null){
            if(pq.isEmpty()){
                break;
            }

            HoldObject newholdNode = pq.poll();
            ListNode newNode = pq.poll().node;
            ListNode temp =holdNode.node.next;
            holdNode.node.next = newholdNode.node;
            list[holdNode.listNum] = temp;

            if(temp!=null)
                pq.add(newholdNode);


        }
        return head;
    }
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        ListNode curr1 = headA,curr2=headB;
        int l1=0,l2=0;
        while(curr1!=null){
            l1++;
            curr1=curr1.next;
        }
        while(curr2!=null){
            l2++;
            curr2=curr2.next;
        }
        int extra = Math.abs(l1-l2);
        curr1 = headA;
        curr2=headB;
        if(l1>l2){
            while(extra-->0){
                curr1=curr1.next;
            }
        }else{
            while(extra-->0){
                curr2=curr2.next;
            }
        }
        while(curr1!=null){
            if(curr1 == curr2)
                return curr1;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return null;
    }
    // decreasing monotonic stac
    //
    public static int[] nextGreater(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] res=new int[nums.length];
        int pos = nums.length-1;
        while(pos>=0){
            if(stack.isEmpty()){
                stack.add(nums[pos]);
                res[pos] = -1;
                pos--;
            }else{
                //the closest greater would in this case be the curr element (stack.peek() <= nums[pos])
                // hnce keep poping till this condidition fails
                // and the nextGreater for curr will be stakcs peek
                // and insert curr as it will will the nextGreater for upcoming nos
                if(stack.peek()<=nums[pos]){
                    stack.pop();
                }else{

                    res[pos] = stack.peek();
                    stack.push(nums[pos]);
                    pos--;
                }
            }
        }
        return res;

    }
    public static DoubleLinkedList flattenMultiLevelDoubleLinkedList(DoubleLinkedList head){
        DoubleLinkedList dummyNode = new DoubleLinkedList();
        dummyNode.val = -1;
        dummyNode.prev = null;
        dummyNode.next = head;
        dummyNode.child = null;
        head.prev = dummyNode;
        DoubleLinkedList itr = dummyNode;

        while(itr!=null) {
            if (itr.child != null) {
                DoubleLinkedList curr = itr;
                DoubleLinkedList T = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                DoubleLinkedList childEnd = curr.child;
                while (childEnd.next != null)
                    childEnd = childEnd.next;
                childEnd.next = T;
                if (T != null)
                    T.prev = childEnd;
                curr.child = null;
            }
            itr = itr.next;
        }
        head.prev = null;
        return head;
    }

    public static  List<List<Integer>> permute(int[] nums){
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> finalRes = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for(int e:nums)
            numsList.add(e);
        permuteHelper(numsList,finalRes,res);
        return  finalRes;
    }
    public static void permuteHelper(List<Integer> numsList,List<List<Integer>> finalRes,List<Integer> res){
        if(numsList.size()==0){
            List<Integer> list = new ArrayList<>(res);
            if(!finalRes.contains(list))
                finalRes.add(list);
            return;
        }
        for(int i=0;i<numsList.size();i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<numsList.size();j++){
                if(i==j){
                    continue;
                }
                list.add(numsList.get(j));
            }
            res.add(numsList.get(i));
            permuteHelper(list,finalRes,res);
            res.remove(numsList.get(i));
        }

    }

    public static TreeNode kSmallest(TreeNode root,int k){

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,0));
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode curr = pair.node;
            int state = pair.state;
            if(state==3 || curr == null)
                continue;
            pair.state++;
            stack.push(pair);


            if(state == 0)
                stack.push(new Pair(curr.left,0));
            else if(state == 1){
                k--;
                if(k==1){
                    return curr;
                }
            }else if(state == 2)
                stack.push(new Pair(curr.right,0));
        }
        return null;
    }

    public static TreeNode lca(TreeNode root,TreeNode p,TreeNode q){
return null;

    }

    public static List<List<Integer>> combinationSum4(int[] nums,int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum4Helper(nums,target,list,result);
        return result;
    }
    public static void combinationSum4Helper(int[] nums,int target,List<Integer> list,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=target){
                list.add(nums[i]);
                combinationSum4Helper(nums, target - nums[i], list, result);
                list.remove(list.size()-1);
            }
        }
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
class Pair{
    TreeNode node;
    int state;
    public Pair(TreeNode node,int state){
        this.node  = node;
        this.state = state;
    }
}
class HoldObject{
    ListNode node;
    int listNum;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        HoldObject that = (HoldObject) o;

        return node.val == that.node.val;

    }

    @Override
    public int hashCode() {
        int result = node != null ? node.hashCode() : 0;
        result = 31 * result + listNum;
        return result;
    }
}