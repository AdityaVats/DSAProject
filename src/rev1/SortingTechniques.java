package rev1;

/**
 * Created by libsys on 3/1/2023.
 */
public class SortingTechniques {

    public static void bubbleSort(int[] nums){
        int n = nums.length;

        for(int i=0;i<n;i++){
            for(int j=i;j<n-i;j++){
                if(nums[i] > nums[i+1]){
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }
    }
    public static void insertionSort(int[] nums){
        int n = nums.length;
        for(int i=0;i<n;i++){
            int j=i-1;
            for(;j>=0 && nums[j] >=nums[i];j++);
            if(j>=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
    public static void selectionSort(int[] nums){
        int n = nums.length;
        for(int i=0;i<n;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }
    public static void quickSort(int[] nums){
        int n = nums.length;
        quickSortHelper(nums,0,n-1);
    }
    public static void quickSortHelper(int[] nums,int start,int end){
        if(start >= end)    return;
        int index = nums[end];
        int leftItr = start;
        for(int i=start;i<end;i++){
            if(nums[i] < nums[end]){
                int temp = nums[leftItr];
                nums[leftItr] = nums[i];
                nums[i] = temp;
                leftItr++;
            }
        }
        int temp = nums[leftItr];
        nums[leftItr] = nums[end];
        nums[end] = temp;
        leftItr++;
        quickSortHelper(nums, start, leftItr);
        quickSortHelper(nums,leftItr+1,end);
    }
    public static void countSort(int[] nums){
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        int[] freqNegativeNo = new int[min+1];
        int[] freqPositiveNo = new int[max+1];
        for(int num:nums)
            if(num >= 0)    freqPositiveNo[num]++;
            else            freqNegativeNo[-num]++;

        int itr = 0;
        for(int i=freqNegativeNo.length-1;i>=1;i--) {
            if (freqNegativeNo[i] == 0) continue;
            for (int count = 0; count < freqNegativeNo[i]; count++) nums[itr++] = -i;
        }
        for(int i=0;i<freqPositiveNo.length;i++) {
            if (freqPositiveNo[i] == 0) continue;
            for (int count = 0; count < freqPositiveNo[i]; count++) nums[itr++] = i;
        }
    }
}
