package model;

public class Drink extends Menu {
    private boolean isCold; // Apakah minuman dingin

    public Drink(String name, double price, boolean isCold) {
        super(name, price);
        this.isCold = isCold;
    }

    // Getter dan Setter
    public boolean isCold() {
        return isCold;
    }

    public void setCold(boolean isCold) {
        this.isCold = isCold;
    }

    // Overriding
    @Override
    public void displayDetails() {
        String temperature = isCold ? "Dingin" : "Hangat";
        System.out.println("Minuman - Nama: " + getName() + ", Harga: Rp. " + getPrice() + ", Suhu: " + temperature);
    }
}
