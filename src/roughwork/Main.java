package roughwork;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * Created by libsys on 1/11/2023.
 */
class Parent implements  Cloneable{
    public void func1(){


        System.out.println("PARENT CLASS");
    }
    public Object copy(Object ob) throws CloneNotSupportedException{
        return this.clone();
    }
}
class Child extends Parent{
    public void func1(){}

}
public class Main {
    public static  void main(String[] args) throws  CloneNotSupportedException{
        new Thread(
                () -> System.out.println("hello")
        ).start();
        BiFunction<Integer,Integer,Integer> biFunction = (a1,a2) -> a1+a2;
        System.out.println(biFunction.apply(1,2));

        Parent parent = new Parent();

        Object ob = new Object();
        parent.copy(ob);

    }
}
