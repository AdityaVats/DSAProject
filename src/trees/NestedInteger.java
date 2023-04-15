package trees;

import java.util.List;

/**
 * Created by libsys on 6/27/2022.
 */
public class NestedInteger {
    private Integer i;
    private List<NestedInteger> list;
    private boolean isInteger;
    public NestedInteger(int i){
        this.i = i;
        this.isInteger = true;

    }
    public NestedInteger(List<NestedInteger> list){
        this.list = list;
        this.isInteger = false;
    }
    public boolean isInteger(){
        return isInteger;

    }
    public int getInteger(){
        return i;
    }
    public List<NestedInteger> getList(){
        return list;
    }
}
