package model;
import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orderHistory;

    public OrderHistory() {
        this.orderHistory = new ArrayList<>();
    }

    // Menambahkan pesanan ke riwayat
    public void addOrderToHistory(Order order) {
        orderHistory.add(order);
    }

    // Menampilkan semua riwayat pesanan
    public void displayHistory() {
        System.out.println("Riwayat Pesanan:");
        for (Order order : orderHistory) {
            order.displayOrderDetails();
            System.out.println("------------------------");
        }
    }
}
