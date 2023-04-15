package rev1;

import org.omg.CORBA.MARSHAL;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by libsys on 12/8/2022.
 */
class MedianFinder{
    PriorityQueue<Integer> leftPQ,rightPQ;
    public MedianFinder(){
        leftPQ = new PriorityQueue<>(Comparator.<Integer>reverseOrder());
        rightPQ = new PriorityQueue<>(Comparator.<Integer>naturalOrder());
    }
    public void addNumVerbose(int num){
        int l1 = leftPQ.size();
        int l2 = rightPQ.size();

        int sizeDiff = Math.abs(l1-l2);

        if(sizeDiff == 0){
            if(leftPQ.isEmpty() || num < leftPQ.peek()){
                leftPQ.offer(num);
            }
            else if(num > rightPQ.peek()){
                rightPQ.offer(num);
                leftPQ.offer(rightPQ.poll());
            } else {
                leftPQ.offer(num);
            }

            /** state after insertion
             left size  = x + 1
             right size = x
             */
        } else {
            if(num < leftPQ.peek()){
                leftPQ.offer(num);
                rightPQ.offer(leftPQ.poll());
            }
            else if(rightPQ.isEmpty() || num > rightPQ.peek()){
                rightPQ.offer(num);
            } else {
                rightPQ.offer(num);
            }
            /** state after insertion
             left size  = x
             right size = x
             */
        }
    }
    public void addNum(int num){
        int t1 = leftPQ.isEmpty() ? Integer.MAX_VALUE : leftPQ.peek();
        int t2 = rightPQ.isEmpty() ? Integer.MAX_VALUE : rightPQ.peek();

        if(num < t1)    leftPQ.offer(num);
        else if(num > t2)   rightPQ.offer(num);
        else leftPQ.offer(num);

        int sizeDiff = Math.abs(leftPQ.size()-rightPQ.size());
        if(sizeDiff == 2){
            if(leftPQ.size() > rightPQ.size())  rightPQ.offer(leftPQ.poll());
            else                                leftPQ.offer(rightPQ.poll());
        }
    }
    public double findMedian(){
        int n = leftPQ.size() + rightPQ.size();
        double ans = 0;
        if(n%2==0){
            ans = (leftPQ.peek()+rightPQ.peek())/2.0;
        } else {
            ans = leftPQ.size()>rightPQ.size() ? leftPQ.peek() : rightPQ.peek();
        }
        return ans;
    }
    public double findMedianVerbose(){
        int n = leftPQ.size() + rightPQ.size();
        double ans = 0;
        if(n%2==0){
            ans = (leftPQ.peek()+rightPQ.peek())/2.0;
        } else {
            ans = leftPQ.peek();
        }
        return ans;
    }
}

public class MedianInDataStream {

    public static void main(String[] args){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(4);
        medianFinder.addNum(3);
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());

    }
}
