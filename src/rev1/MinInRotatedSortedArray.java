package rev1;

/**
 * Created by libsys on 12/12/2022.
 */
public class MinInRotatedSortedArray {
    public static int getMin(int[] nums){
        int n = nums.length;

        int l = 0;
        int h = n-1;
        /**1,2,3,4,5 case**/
        if(nums[l]<nums[h]) return nums[l];
        while(l<=h){
            int mid = l + (h-l)/2;


            int leftEl = mid-1<0 ? Integer.MIN_VALUE : nums[mid-1];
            int rightEl = mid+1==n ? Integer.MAX_VALUE : nums[mid+1];

            if(leftEl>nums[mid] && nums[mid]<rightEl)   return nums[mid];


            if(nums[mid] > nums[n-1])   l = mid + 1;
            else                        h = mid - 1;
        }

        return -1;
    }
    public static void main(String[] args){
        System.out.println(getMin(new int[]{4,5,6,7,8,9,2}));
        System.out.println(getMin(new int[]{3,4,5,0,1,2}));
        System.out.println(getMin(new int[]{3,4,5,6,7,8,9}));
    }
    public static String DecToHex(String decStr) {
        int digit;
        long no = Long.parseLong(decStr);  //String must have all numericals
        char temp[] = new char[20];//todo
        int a = 0, noLen = String.valueOf(no).length();
        int index = 0;
        do {
            digit = (int) (no % 16);
            if (digit <= 9)
                temp[index++] = (char) (digit + '0');
            else
                temp[index++] = (char) (digit - 10 + 'A');
            no = no / 16;
        } while (no > 0);
        while (a < decStr.length() - noLen) {
            temp[index++] = (char) (0 + '0');
            a++;
        }
        temp[index] = 0;
        char hexTemp[] = new char[10];
        int j = 0;

        for (int i = index - 1; i >= 0; i--, j++)
            hexTemp[j] = temp[i];

        return (new String(hexTemp).substring(0, index));
    }
}
