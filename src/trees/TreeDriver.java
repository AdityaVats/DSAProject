package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by libsys on 6/28/2022.
 */
public class TreeDriver {
    public static void main(String[] args){
        NestedInteger leaf1 = new NestedInteger(1);
        NestedInteger leaf2 = new NestedInteger(2);
        List<NestedInteger> list1 = new ArrayList<>();
        List<NestedInteger> f = Arrays.asList(new NestedInteger(1),new NestedInteger(2));
        List<NestedInteger> g = new ArrayList<>();
        List<NestedInteger> b = Arrays.asList(new NestedInteger(f),new NestedInteger(g));

        List<NestedInteger> h = Arrays.asList(new NestedInteger(4),new NestedInteger(5));
        List<NestedInteger> c = Arrays.asList(new NestedInteger(3),new NestedInteger(h));

        List<NestedInteger> d = new ArrayList<>();

        List<NestedInteger> e = Arrays.asList(new NestedInteger(7),new NestedInteger(8));

        List<NestedInteger> a = Arrays.asList(new NestedInteger(-100),new NestedInteger(b),/*new NestedInteger(c),*/new NestedInteger(d),new NestedInteger(6),new NestedInteger(e));


        FlattenList itr = new FlattenList(a);
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
