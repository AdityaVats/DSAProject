package rev1;

/**
 * Created by libsys on 12/7/2022.
 */
/**lazy propragation only useful for range updation queries*/
public class RangeSumQuery {
    public static void main(String[] args){
        int[] nums = new int[]{1,3,5};
        RangeSum rangeSum = new RangeSum(nums);
        rangeSum.sum(0,1);
        rangeSum.sum(0,2);
        rangeSum.update(1, 5);
        rangeSum.sum(0, 2);

    }
}

class RangeSum{
    int[] nums;
    int[] segmentTree;
    int[] lazyTree;
    public RangeSum(int[] nums){
        int n = nums.length;
        this.nums = nums;
        segmentTree = new int[4*n];
        lazyTree = new int[4*n];
        build(0,0,n-1);
    }
    public void build(int index,int low,int high){
        if(low==high){
            segmentTree[index] = nums[low];
            return;
        }

        int mid = low + (high-low)/2;
        build(2*index+1,low,mid);
        build(2*index+2,mid+1,high);
        segmentTree[index] = segmentTree[2*index+1] + segmentTree[2*index+2];

    }
    public int sum(int start,int end){
        int ans = helperSum(start, end, 0, 0, nums.length - 1);
        System.out.println(ans);
        return ans;
    }
    /**
     *
     *
     *
     * **/
    public int helperSum(int start,int end,int index,int low,int high){

        if(start==low && end==high) return segmentTree[index];

        int mid = low + (high-low)/2;

        if(end<=mid){
            if(lazyTree[index] != 0){
                segmentTree[index] += lazyTree[index];
                lazyTree[2*index+1] = lazyTree[index];
                lazyTree[index] = 0;
            }
            return helperSum(start,end,2*index+1,low,mid);
        }
        else if(start>mid){
            if(lazyTree[index] != 0){
                segmentTree[index] += lazyTree[index];
                lazyTree[2*index+1] = lazyTree[index];
                lazyTree[index] = 0;
            }
            return helperSum(start,end,2*index+2,mid+1,high);
        }
        else{
            if(lazyTree[index] != 0){
                segmentTree[index] += lazyTree[index];
                lazyTree[2*index+1] = lazyTree[index];
                lazyTree[2*index+2] = lazyTree[index];
                lazyTree[index] = 0;
            }
            return  helperSum(start,mid,2*index+1,low,mid) + helperSum(mid+1,end,2*index+2,mid+1,high);
        }
    }
    public void update(int index,int value){
        nums[index] += value-nums[index];
        lazyTree[0] = value;
        helperUpdate(index,value,0,0,nums.length-1);
    }
    public void updateRange(int start,int end,int value){
        boolean useLazy = false;
        if(useLazy){
            helperLazyRangeUpdate(start,end,value,0,nums.length-1);
        } else {
            for(int i=start;i<=end;i++) update(i,value);
        }
    }
    public void helperUpdate(int changeIndex,int change,int index,int low,int high){
        if(low == high){
            segmentTree[index] = change;
            return;
        }

        int mid = low + (high-low)/2;
        if(changeIndex<=mid){
            helperUpdate(changeIndex, change, 2 * index+1,low,mid);
        }
        else{
            helperUpdate(changeIndex,change,2*index+2,mid+1,high);
        }

        segmentTree[index] = segmentTree[2*index+1] + segmentTree[2*index+2];
    }
    public  void helperLazyRangeUpdate(int start,int end,int value,int low,int high){

    }
}
