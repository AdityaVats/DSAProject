/**
 * Created by libsys on 2/22/2022.
 */
public class Day2 {
    public static boolean buddyString(String s,String goal){
        if(s.length()!=goal.length())
            return false;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(i==j)
                    continue;
                System.out.println(i+" "+j);
                String res = buddyStringHelper(s, i, j);
                if(res.equals(goal))
                    return true;
            }
        }
        return false;
    }
    public static String buddyStringHelper(String s,int i,int j){
        return s.substring(0,i)+s.charAt(j)+s.substring(i+1,j)+s.charAt(i)+s.substring(j+1);

    }
    public static boolean buddyStringRec(String s,String goal){
    return true;
    }
}
