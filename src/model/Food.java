package model;

public class Food extends Menu {
    private String type; // Jenis makanan (contoh: Main Course, Snack)

    public Food(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    // Getter dan Setter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Overriding
    @Override
    public void displayDetails() {
        System.out.println("Makanan - Nama: " + getName() + ", Harga: Rp. " + getPrice() + ", Tipe: " + type);
    }
}
