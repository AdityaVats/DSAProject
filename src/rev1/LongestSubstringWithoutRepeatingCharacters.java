package rev1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by libsys on 11/21/2022.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int get(String s){
        int n = s.length();
        int i=0;
        int j=0;
        Set<Character> set = new HashSet<>();
        int ans = 0;
        while(i<n){
            char c = s.charAt(i);

            while(set.contains(c)){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(c);
            ans = Math.max(ans,i-j+1);
            i++;


        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(get("aaabsbbbbbbbadkl"));
    }
}
