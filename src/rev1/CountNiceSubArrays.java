package rev1;

/**
 * Created by libsys on 11/23/2022.
 */
public class CountNiceSubArrays {

    public static int countNice(int[] nums,int k){
        int n = nums.length;
        int count = 0;
        int i = 0;
        int j = 0;
        while(i<n){
            if(nums[i]%2 != 0)  count++;
            if(count == k)  break;
            i++;
        }
        int ans = 0;
        while(i<n){
            int countLeft = 0;
            while(j<i && nums[j]%2 == 0){
                countLeft++;
                j++;
            }
            /**to skip the odd element for the next time above loop comes*/
            countLeft++;
            j++;

            int countRight = 0;
            /**to skip the odd element so while loop doesnt fail at count=0**/
            countRight++;
            i++;
            while(i<n && nums[i]%2 == 0){
                countRight++;
                i++;
            }


            ans += countLeft*countRight;
        }
        return ans;
    }
    public static void main(String[] args){
        String str = "13/12/2022 16:09:04\u001EASP044\u001E43947\u001E12/01/2023\u001EMoving objects databases / Ralf Hartmut Guting and Markus Schneider  \u001Enull\u001Enull\u001Eselfcheck\n" +
                "13/12/2022 16:09:05\u001EASP044\u001E45779\u001E12/01/2023\u001ETemporal and spatio-temporal data mining /\u000B Wynne Hsu and Mong Li Lee  \u001Enull\u001Enull\u001Eselfcheck";
        System.out.println(countNice(new int[]{ 2 ,2 ,2 ,1 ,2 ,2 ,1 ,2 ,2 ,1 ,2 ,2 ,2 ,2 },2));
        System.out.println(countNice(new int[]{ 2,2,2,1,2,2,1,2,2,2 },2));
        System.out.println(countNice(new int[]{ 1,1,2,1,1 },3));
    }
}
