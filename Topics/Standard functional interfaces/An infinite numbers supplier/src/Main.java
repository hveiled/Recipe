import java.util.Optional;
import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        Integer[] number = {0};
        return new Supplier<Integer>() {
            @Override
            public Integer get() {
                return number[0]++;
            }
        };
    }

    public static void main(String[] args) {
        Supplier<Integer> supplier = getInfiniteRange();
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());

    }

}