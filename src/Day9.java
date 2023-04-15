import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by libsys on 3/9/2022.
 */
public class Day9 {

    public static int qq(int[] a,int k){
        int max = 0;
        int res=0;
        for(int i=0;i<a.length;i++){
            if(max<a[i])
                max = a[i];
        }
        int[] check = new int[max+1];
        Arrays.fill(check,0);
        for(int i=0;i<a.length;i++){
            check[a[i]] =-1;
        }
        int i=1;
        for(;i<check.length && k>0;i++){
            if(check[i]!=-1){
                res += i;
                k--;
            }
        }

        if(k>0){
            res +=k*(2*(max+1)+k-1)/2;
        }
        return res;


    }

    public static long kSum(int[] a,int k){
        Set<Integer> set = new HashSet<>();
        long max = 0;

        for(int i=0;i<a.length;i++){
            set.add(a[i]);
            if(max<a[i])
                max = a[i];
        }
        long idealSum = (max*(max+1))/2;
        for(int e:set)
            idealSum -=e;
        int remainingElements = (int)max -set.size();
        if(k==remainingElements)
            return idealSum;
        if( k<remainingElements){
            int temp = (int)max;
            int z = remainingElements - k;
            int endE = -1;
            int startE = -1;
            while(z>0 && temp>0){
                    if(set.contains(temp)){
                         if(endE !=-1 && temp+1<=max)
                            startE = temp+1;

                        if(startE!=-1 && endE!=-1) {
                            System.out.println(startE + " " + endE);


                            if (endE - startE + 1 > z) {
                                while (endE - startE + 1 != z) {
                                    startE++;
                                }
                            }
                            z -= endE - startE + 1;
                        }
                    }else{
                        if(endE == -1)
                        endE = temp;
                     }
                temp --;
            }
            if(endE!=-1 && temp+1<max ){
                startE = temp+1;
                System.out.println(startE+" "+endE);

                idealSum -= ((endE-startE+1)*(startE+endE))/2;
            }
            return idealSum;
        }else{
            k = k -remainingElements;
            return  idealSum + k*(2*(max+1)+k-1)/2;
        }
    }

    public static void main(String[] args) {
        int [] arr = {10,10,20,21,21,999999996,1000000000};
        System.out.println(kSum(arr,999999993));
    }
}
