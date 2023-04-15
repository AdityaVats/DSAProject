/**
 * Created by libsys on 5/12/2022.
 */
public class DoubleLinkedList {
    int val;
    DoubleLinkedList prev,next,child;
    public DoubleLinkedList(){
        
    }
    public DoubleLinkedList(int val,DoubleLinkedList prev,DoubleLinkedList next,DoubleLinkedList child){
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
