package dp;

import java.util.Arrays;

/**
 * Created by libsys on 1/31/2023.
 */
public class TeamWithNoConflicts {

    public static int getMaxScore(int[] scores,int[] ages){
        System.out.println(scores.length+" "+ages.length);
        if(ages.length != scores.length)    return -1;
        int n = ages.length;
        Integer[] index = new Integer[n];
        for(int i=0;i<n;i++)    index[i] = i;
        Arrays.sort(index,
                (i1, i2) ->
                        ages[i1] == ages[i2] ? scores[i1] - scores[i2] : ages[i1] - ages[i2]
        );
        return helper(0, -1, index, ages, scores);
    }
    public static int helper(int pos,int maxPerson,Integer[] index,int[] ages,int[] scores){
        int n = index.length;
        if(pos == n)    return 0;

        /*if(maxPerson != -1 && ages[index[maxPerson]] != ages[index[pos]] && scores[index[maxPerson]] > scores[index[pos]]){
            return helper(pos+1,maxPerson,index,ages,scores);
        }
*/
        int smallAns1 = 0;
        if(maxPerson==-1 || scores[index[maxPerson]] <= scores[index[pos]]){
            if(maxPerson== -1 || scores[index[maxPerson]] < scores[index[pos]]){
                smallAns1 = scores[index[pos]] + helper(pos+1,pos,index,ages,scores);
            } else {
                smallAns1 = scores[index[pos]] + helper(pos+1,maxPerson,index,ages,scores);
            }

        }
        int smallAns2 = helper(pos+1,maxPerson,index,ages,scores);
        return Math.max(smallAns1,smallAns2);

    }
    /***LIS***/
    public static void main(String[] args){
        System.out.println(getMaxScore(
                new int[] {596,277,897,622,500,299,34,536,797,32,264,948,645,537,83,589,770},
                new int[] {18,52,60,79,72,28,81,33,96,15,18,5,17,96,57,72,72}
        ));

        System.out.println(getMaxScore(

                new int[] {1,1,1,1,3},
                new int[] {9,9,8,8,4}
        ));
    }
}
