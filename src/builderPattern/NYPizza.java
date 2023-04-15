package builderPattern;

/**
 * Created by libsys on 6/8/2022.
 */
public class NYPizza extends Pizza {
    public enum Size {SMALL,MEDIUM,LARGE};
    final Size size;
    static class Builder extends Pizza.Builder<Builder>{
        private Size size;
        public Builder(Size size){
            this.size = size;

        }
        @Override
        public NYPizza build(){
            return new NYPizza(this);
        }
        @Override
        public Builder self(){
            return this;
        }
    }
    NYPizza(Builder builder){
        super(builder);
        size = builder.size;
    }
}
