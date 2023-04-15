package binarySearch;

/**
 * Created by libsys on 12/20/2022.
 */
public class MaxRemovalCharacters {

    public static int maxRemovable(String s,String p,int[] removable){
        char[] sArr = s.toCharArray();


        int low = 0;
        int high = removable.length;
        while(low<=high){
            int mid = low + (high-low)/2;

            for(int itr=0;itr<mid;itr++){
                int index = removable[itr];
                sArr[index] = '$';
            }
            int pos = 0;
            boolean hasSS = false;
            for(int itr=0;itr<s.length();itr++){

                if(sArr[itr] == p.charAt(pos)){
                    pos++;
                    if(pos==p.length()){
                        hasSS = true;
                        break;
                    }
                }
            }

            sArr = s.toCharArray();

            if(hasSS){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    public static void main(String[] args){
        System.out.println(maxRemovable("abcacb","ab",new int[]{3,1,0}));
        System.out.println(maxRemovable("abcbddddd","abcd",new int[]{3,2,1,4,5,6}));
        System.out.println(maxRemovable("abcab","abc",new int[]{0,1,2,3,4}));
    }
}
