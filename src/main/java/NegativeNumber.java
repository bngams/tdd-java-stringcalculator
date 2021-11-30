public interface NegativeNumber {

    static void throwRuntimeIfNegative(Integer n) {
        if(n < 0 ) {
            throw new RuntimeException("Negatives are not allowed: " + n.toString());
        }
    }
}
