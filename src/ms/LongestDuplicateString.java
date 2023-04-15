package ms;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by libsys on 1/3/2023.
 */
/**Binary search
 * Rolling hash/Rabin-Karp algo**/
public class LongestDuplicateString {
    public static String getDup(String s){
        int n = s.length();
        int low = 1;
        int high = n-1;
        String ans = "";
        while(low<=high){
            int mid = low + (high-low)/2;

            String duplicate = rabinKarpAlgo(s,mid);


            if (duplicate.length() != 0){
                ans = duplicate;
                low  = mid + 1;
            }
            else                high = mid - 1;
        }
        return ans;
    }
    public static String rabinKarpAlgo(String s,int l){
        int n = s.length();
        long pow = 1;
        for(int x=1;x<l;x++)    pow *= 31;
        long hash = hash(s.substring(0,l));
        Map<Long,String> map = new HashMap<>();
        map.put(hash,s.substring(0,l));

        for(int i=1;i<=n-l;i++){
            hash = nextHash(s.charAt(i-1),s.charAt(i+l-1),hash,pow);
            if(map.containsKey(hash) /*&& s.substring(i,i+l).equals(map.get(hash))*/){
                return map.get(hash);
            }
            map.put(hash,s.substring(i,i+1));
        }
        return "";
    }

    public static long hash(String s){
        long hash = 0L;
        long prime = 31;
        for(int i=0;i<s.length();i++){
            hash = hash*prime + s.charAt(i);
        }
        return hash;
    }
    public static long nextHash(char oldChar,char newChar,long hash,long pow){
        long prime = 31;
        return (hash - oldChar*pow)*prime + newChar;
    }
    public static void main(String[] args){
        System.out.println(getDup("banana"));
        System.out.println(getDup("abcd"));
        System.out.println(getDup("breadkaparorawitharora"));

    }
}
