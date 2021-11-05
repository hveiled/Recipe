import java.util.function.LongUnaryOperator;

class Operator {

    public static LongUnaryOperator unaryOperator = (long a) -> {
        while (true) {
            a += 1;
            if (a % 2 == 0) {
                return a;
            }
        }
    };
}
