import java.util.Objects;
import java.util.function.Supplier;

public class MyClass<T>
{
    T field;
    private final Supplier<T> ctor;

    MyClass(Supplier<T> ctor) {
        this.ctor = Objects.requireNonNull(ctor);
    }

    public void myMethod()
    {
        field = ctor.get();
    }


    public static void main(String[] args) {
        MyClass<Integer> myclass = new MyClass<>(() -> 5);

//        MyClass<Integer> myclass = new MyClass<>(1);
//        myclass.field='dsf';

        myclass.myMethod();
        System.out.println(myclass.field.longValue());
    }
}