
public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Apple", 1.5, 10);
        Product product2 = new Product("Banana", 2.0, 15);

        Store store = new Store("Supermarket", "123 Main St");
        store.addProduct(product1);
        store.addProduct(product2);

        System.out.println(store);
    }
}
