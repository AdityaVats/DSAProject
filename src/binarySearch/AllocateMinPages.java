package binarySearch;

/**
 * Created by libsys on 11/15/2022.
 */
public class AllocateMinPages {

    public static int getMinPages(int[] A,int B){
        return helper(A,B,0);

    }
    /**Recursive*/
    public static int helper(int[] A,int B,int index){
        if(index==A.length) return 0;
        int n = A.length;
        int currPages = 0;
        int ans = Integer.MAX_VALUE;

        if(B==1){
            for(int i=index;i<n;i++){
                currPages+=A[i];
            }
            return currPages;
        }
        for(int i=index;i<n-B+1;i++){
            currPages+=A[i];
            int smallAns = helper(A,B-1,i+1);
            smallAns = Math.max(smallAns, currPages);
            ans = Math.min(ans, smallAns);
        }
        return ans;

    }
    /**Binary Search based**/
    public static int getMinPagesBinarySearch(int[] A,int B){
        int low = A[0];
        int high = 0;

        for(int el:A){
            low = Math.max(low,el);
            high += el;
        }
        int ans = -1;

        while(low<=high){
            int mid = low + (high-low)/2;

            int students = 1;
            int currPages = 0;
            for(int i=0;i<A.length;i++){
                if(currPages+A[i] > mid ){
                    currPages = 0;
                    students++;
                }
                currPages += A[i];
            }

            if(students == B){
                ans =mid;
                high = mid-1;
            } else if( students < B){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] A = new int[]{5,7,100,11};
        int B = 2;
        System.out.println(getMinPages(A,B));
    }
}
