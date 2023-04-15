/**
 * Created by libsys on 2/24/2022.
 */
public class Day4 {
    public static String getKPer(int n,int k){
        String s ="";
        for(int i=1;i<=n;){
            s =+ i+"";
        }
        for(int i=0;i<n;i++){

        }
        return null;
    }
    public static String[] getP(String s){
        if(s.length()==1){
            String[] res = new String[111];
            res[0] = s;
            return res;
        }
        String[] smallAns = getP(s.substring(1));
        /*for(int i=0;i<s.length();i++){
            str = smallAns(0,i) + s.charAt(0) + smallAns(i);
        }*/
        return null;
    }
}
