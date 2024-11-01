package model;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Menu> orderedItems;
    private String orderType; // "Dine-In" atau "Take-Away"
    private double totalPrice;
    private String status; // Status pesanan (Contoh: "Diproses", "Selesai")

    public Order(Customer customer, List<Menu> orderedItems, String orderType) {
        this.customer = customer;
        this.orderedItems = orderedItems;
        this.orderType = orderType;
        this.totalPrice = calculateTotalPrice();
        this.status = "Diproses";
    }

    // Menghitung total harga pesanan
    private double calculateTotalPrice() {
        double total = 0.0;
        for (Menu item : orderedItems) {
            total += item.getPrice();
        }
        return total;
    }

    // Setter dan Getter
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Menampilkan detail pesanan
    public void displayOrderDetails() {
        System.out.println("Pelanggan: " + customer.getName());
        System.out.println("Tipe Pesanan: " + orderType);
        System.out.println("Item yang Dipesan:");
        for (Menu item : orderedItems) {
            item.displayDetails();
        }
        System.out.println("Total Harga: Rp. " + totalPrice);
        System.out.println("Status Pesanan: " + status);
    }
}
