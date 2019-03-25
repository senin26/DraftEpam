package staticGeneric;

public class StaticGeneric<T, U> {

    private T field;
   // private static U otherField;
    private static Integer myInt = 5;

    public StaticGeneric(T field) {
        this.field = field;
    }

    public T getField(){
       return field;
    }

    public static <U> U staticMethod(U item) {
        if (item instanceof Integer) System.out.println("item is an Integer");
        System.out.println(((Integer) item).intValue() + 5);
        return item;
    }

}
