import java.util.Arrays;

//3. My own class:
public class MyClass {
    //1. Primitive:
    int id;
    int quantity;
    char size;
    double price;
    boolean inStock;
    //2. Non-primitive:
    String name;
    String[] coloursAvailable;

    //Random id constructor
    public MyClass(int quantity, char size, double price, boolean inStock, String name, String[] coloursAvailable) {
        this.id = 10_000 + (int) (Math.random() * 90_000);
        this.quantity = quantity;
        this.size = size;
        this.price = price;
        this.inStock = inStock;
        this.name = name;
        this.coloursAvailable = coloursAvailable;
    }

    //Id given constructor
    public MyClass(int id, int quantity, char size, double price, boolean inStock, String name, String[] coloursAvailable) {
        this.id = id;
        this.quantity = quantity;
        this.size = size;
        this.price = price;
        this.inStock = inStock;
        this.name = name;
        this.coloursAvailable = coloursAvailable;
    }

    public void printer() {
        System.out.print("id: " + id + "\n");
        System.out.print("name: " + name + "\n");
        System.out.print("size: " + size + "\n");
        System.out.print("colours: " + Arrays.toString(coloursAvailable) + "\n");
        System.out.print("price: " + price + "\n");
        System.out.print("in stock: " + inStock + "\n");
        System.out.print("quantity: " + quantity + "\n");
    }

    public boolean equals(MyClass item) {
        return ((this.id == item.id) &&
                (this.quantity == item.quantity) &&
                (this.size == item.size) &&
                (this.price == item.price) &&
                (this.inStock == item.inStock) &&
                (this.name.equals(item.name)) &&
                (Arrays.equals(this.coloursAvailable, item.coloursAvailable)));
    }
}
