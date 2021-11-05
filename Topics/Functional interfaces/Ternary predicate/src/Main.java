class Predicate {
    public static final TernaryIntPredicate ALL_DIFFERENT = (int a, int b, int c) -> {
        if (a != b && b != c && a != c) {
            return true;
        } else {
            return false;
        }
    };

    @FunctionalInterface
    public interface TernaryIntPredicate {
        boolean test(int a, int b, int c);
    }
}