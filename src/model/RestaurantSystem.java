package model;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSystem {
    public List<Menu> menuList;
    private List<Order> orderList;
    public List<Customer> customerList;
    private OrderHistory orderHistory;

    public RestaurantSystem() {
        menuList = new ArrayList<>();
        orderList = new ArrayList<>();
        customerList = new ArrayList<>();
        orderHistory = new OrderHistory();
    }

    // Menambahkan menu baru
    public void addMenu(Menu menu) {
        menuList.add(menu);
    }

    // Menambahkan pelanggan baru
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    // Mencatat pesanan baru
    public void placeOrder(Order order) {
        orderList.add(order);
        orderHistory.addOrderToHistory(order);
    }

    // Menampilkan menu
    public void displayMenu() {
        System.out.println("Menu Restoran:");
        for (Menu menu : menuList) {
            menu.displayDetails();
        }
    }

    // Menampilkan riwayat pesanan
    public void displayOrderHistory() {
        orderHistory.displayHistory();
    }
}
