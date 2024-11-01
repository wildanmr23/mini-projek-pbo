package model;

public class Menu {
    private String name;
    private double price;

    // Constructor Overloading
    public Menu() {
        this.name = "";
        this.price = 0.0;
    }

    public Menu(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter dan Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method Polymorphism (Overriding)
    public void displayDetails() {
        System.out.println("Nama: " + name + ", Harga: Rp. " + price);
    }
}