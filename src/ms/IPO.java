package ms;

import java.util.PriorityQueue;

/**
 * Created by libsys on 2/23/2023.
 */
public class IPO {

    public static int maxCapital(int[] capital,int[] profits,int k,int w){
        int n = profits.length;

        PriorityQueue<Integer> minCapitalPQ = new PriorityQueue<>((i1,i2) -> capital[i1] == capital[i2] ? profits[i2] - profits[i1] : capital[i1] - capital[i2]);
        PriorityQueue<Integer> maxProfitPQ = new PriorityQueue<>((i1,i2) -> {
            if((profits[i2] - capital[i2]) - (profits[i1] - capital[i1]) == 0){
                return capital[i1] - capital[i2];
            }
            return (profits[i2] - capital[i2]) - (profits[i1] - capital[i1]);


        });

        for(int i=0;i<n;i++)    minCapitalPQ.offer(i);

        // Max(k,n) log n
        //   (n + k )logn
        //k
        for(int i=0;i<k;i++){
            //  Worst case n log n
            while (!minCapitalPQ.isEmpty() && capital[minCapitalPQ.peek()] <= w)    maxProfitPQ.offer(minCapitalPQ.poll());

            if(maxProfitPQ.isEmpty())   break;
            int index = maxProfitPQ.poll();                     //  log n
            w = w - capital[index] + profits[index];
            System.out.println(w);
        }
        return w;
    }
    public static void main(String[] args){
        System.out.println(
                maxCapital(new int[]{7, 5, 3, 4, 2, 2}, new int[]{10, 7, 6, 6, 5, 4}, 3, 4)
        );
        System.out.println(lastOneStanding(11));
        System.out.println(lastOneStanding(10));
    }

    public static int lastOneStanding(int n){
        return 0;
    }
}
