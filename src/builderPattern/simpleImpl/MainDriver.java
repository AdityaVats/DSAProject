package builderPattern.simpleImpl;

/**
 * Created by libsys on 6/8/2022.
 */
public class MainDriver {
    public static void main(String[] args){
        Coffee coffee = new Coffee.Builder(Coffee.BaseType.DECAF, Coffee.Size.LARGE).add(Coffee.AddOn.CREAM).add(Coffee.AddOn.ExtraShot).build();
        System.out.print(coffee);
    }
}
