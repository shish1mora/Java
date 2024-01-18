import java.util.ArrayList;
import java.util.List;


    public class Store {
        private String name;
        private String location;
        private List<Product> products;

        public Store(String name, String location) {
            this.name = name;
            this.location = location;
            this.products = new ArrayList<>();
        }

        // Геттеры и сеттеры
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public List<Product> getProducts() {
            return products;
        }

        // Метод для добавления продукта в магазин
        public void addProduct(Product product) {
            products.add(product);
        }

        // Метод для удаления продукта из магазина
        public void removeProduct(Product product) {
            products.remove(product);
        }

        // Переопределенный метод toString()
        @Override
        public String toString() {
            return "Store{name='" + name + "', location='" + location + "', products=" + products + '}';
        }

        // Переопределенный метод equals()
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Store store = (Store) obj;
            return name.equals(store.name) &&
                    location.equals(store.location) &&
                    products.equals(store.products);
        }
    }

