package factoryPattern;

/**
 * Created by libsys on 2/23/2023.
 */
// interrelated objects
public interface AbstractQueryFactory {
    public Object createProductA();
    public Object createProductB();
}

interface factory{
    public Object createProduct();
}
