package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by libsys on 6/27/2022.
 */
public class FlattenList {
    Stack<Pair> stack;
    List<NestedInteger> list;
    int pos;
    public FlattenList(List<NestedInteger> list){
        this.list = list;
        this.pos = 0;

        stack = new Stack<>();
        NestedInteger x = list.get(0);
        if(x.isInteger()){
            stack.push(new Pair(x,0));
            return;
        }
        while(!x.isInteger()){
            stack.push(new Pair(x,0));
            if(x.getList().size()==0) return;
            x = x.getList().get(0);
        }
        stack.push(new Pair(x,0));

    }
    public boolean hasNext(){
        while(pos< list.size()){
            while(!stack.isEmpty()){
                Pair pair = stack.peek();
                if(pair.nestedInteger.isInteger()) return true;
                if(pair.state<pair.nestedInteger.getList().size() && pair.nestedInteger.getList().get(pair.state).isInteger()){
                    stack.push(new Pair(pair.nestedInteger.getList().get(pair.state),0));
                    return true;
                }
                if(pair.state >= pair.nestedInteger.getList().size()){
                    stack.pop();
                    if(stack.isEmpty()) break;
                    pair = stack.peek();
                    pair.state++;
                } else {
                    stack.push(new Pair(pair.nestedInteger.getList().get(pair.state),0));
                }
            }
            if(pos+1>=list.size()){
                return false;
            }
            stack.push(new Pair(list.get(++pos),0));
        }

        return true;
    }
    public int next() {

        Pair pair = stack.peek();
        stack.pop();
        if(!stack.isEmpty()){
            Pair parent = stack.peek();
            parent.state++;
        }
        return pair.nestedInteger.getInteger();


    }
}
