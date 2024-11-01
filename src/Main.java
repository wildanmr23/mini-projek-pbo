import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Customer;
import model.Drink;
import model.Food;
import model.Menu;
import model.Order;
import model.RestaurantSystem;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestaurantSystem restaurantSystem = new RestaurantSystem();

        restaurantSystem.addMenu(new Food("Nasi Goreng", 25000, "Main Course"));
        restaurantSystem.addMenu(new Food("Mie Ayam", 20000, "Main Course"));
        restaurantSystem.addMenu(new Drink("Es Teh Manis", 8000, true));
        restaurantSystem.addMenu(new Drink("Kopi Panas", 12000, false));

        Customer customers = new Customer("Andi", "081234567890");
        restaurantSystem.addCustomer(customers);

        boolean running = true;
        
        while (running) {
            System.out.println("\n=== Sistem Manajemen Pesanan Restoran ===");
            System.out.println("1. Lihat Menu");
            System.out.println("2. Tambah Pelanggan");
            System.out.println("3. Buat Pesanan");
            System.out.println("4. Lihat Riwayat Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // Lihat Menu
                    restaurantSystem.displayMenu();
                    break;

                case 2:
                    // Tambah Pelanggan
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan Nomor Telepon: ");
                    String phoneNumber = scanner.nextLine();
                    Customer newCustomer = new Customer(name, phoneNumber);
                    restaurantSystem.addCustomer(newCustomer);
                    System.out.println("Pelanggan berhasil ditambahkan.");
                    break;

                case 3:
                    // Buat Pesanan
                    System.out.println("Masukkan Nama Pelanggan yang Memesan:");
                    String customerName = scanner.nextLine();
                    Customer customer = findCustomerByName(restaurantSystem, customerName);

                    if (customer == null) {
                        System.out.println("Pelanggan tidak ditemukan!");
                        break;
                    }

                    System.out.println("Pilih tipe pesanan (Dine-In/Take-Away): ");
                    String orderType = scanner.nextLine();

                    List<Menu> orderedItems = new ArrayList<>();
                    boolean ordering = true;

                    while (ordering) {
                        restaurantSystem.displayMenu();
                        System.out
                                .print("Masukkan nama item yang ingin dipesan (atau ketik 'selesai' untuk selesai): ");
                        String itemName = scanner.nextLine();

                        if (itemName.equalsIgnoreCase("selesai")) {
                            ordering = false;
                        } else {
                            Menu menuItem = findMenuItemByName(restaurantSystem, itemName);
                            if (menuItem != null) {
                                orderedItems.add(menuItem);
                                System.out.println("Item ditambahkan ke pesanan.");
                            } else {
                                System.out.println("Item tidak ditemukan di menu.");
                            }
                        }
                    }

                    if (!orderedItems.isEmpty()) {
                        Order order = new Order(customer, orderedItems, orderType);
                        restaurantSystem.placeOrder(order);
                        System.out.println("Pesanan berhasil dibuat.");
                    } else {
                        System.out.println("Pesanan kosong, tidak dapat diproses.");
                    }
                    break;

                case 4:
                    // Lihat Riwayat Pesanan
                    restaurantSystem.displayOrderHistory();
                    break;

                case 5:
                    // Keluar
                    running = false;
                    System.out.println("Terima kasih telah menggunakan Sistem Manajemen Pesanan Restoran.");
                    break;

                default:
                    System.out.println("Opsi tidak valid. Silakan pilih lagi.");
                    break;
            }
        }

        scanner.close();
    }

    // Fungsi untuk mencari pelanggan berdasarkan nama
    private static Customer findCustomerByName(RestaurantSystem restaurantSystem, String name) {
        for (Customer customer : restaurantSystem.customerList) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    // Fungsi untuk mencari item menu berdasarkan nama
    private static Menu findMenuItemByName(RestaurantSystem restaurantSystem, String itemName) {
        for (Menu menu : restaurantSystem.menuList) {
            if (menu.getName().equalsIgnoreCase(itemName)) {
                return menu;
            }
        }
        return null;
    }
}
