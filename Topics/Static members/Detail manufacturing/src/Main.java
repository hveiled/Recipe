
class ManufacturingController {
    static int getNumberOfProducts = 0;
    static String product;
    public static String requestProduct(String request) {
        // write your code here
        product = "No." + request;
        return product;
    }

    public static int getNumberOfProducts() {
        // write your code here
        return getNumberOfProducts;
    }
}