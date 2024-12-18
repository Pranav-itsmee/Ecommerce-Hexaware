package com.java.ecom.main;

import java.util.Scanner;
import com.java.ecom.dao.CartDAO;
import com.java.ecom.dao.CartDAOImpl;
import com.java.ecom.dao.CustomerDAO;
import com.java.ecom.dao.CustomerDAOImpl;
import com.java.ecom.dao.OrderDAO;
import com.java.ecom.dao.OrderDAOImpl;
import com.java.ecom.dao.PaymentDAO;
import com.java.ecom.dao.PaymentDAOImpl;
import com.java.ecom.dao.ProductDAO;
import com.java.ecom.dao.ProductDAOImpl;

public class EcomMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomerDAO customerDAO = new CustomerDAOImpl();
        ProductDAO productDAO = new ProductDAOImpl();
        CartDAO cartDAO = new CartDAOImpl();
        OrderDAO orderDAO = new OrderDAOImpl();
        PaymentDAO paymentDAO = (PaymentDAO) new PaymentDAOImpl();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Show Customers");
            System.out.println("2. Search by Customer ID");
            System.out.println("3. Search by Customer Username");
            System.out.println("4. Customer Authentication");
            System.out.println("5. Add Customer");
            System.out.println("6. Show Products");
            System.out.println("7. Search by Product ID");
            System.out.println("8. Add Product");
            System.out.println("9. Add Cart");
            System.out.println("10. Update Cart");
            System.out.println("11. Search by Cart ID");
            System.out.println("12. Place Order");
            System.out.println("13. Show All Customer Orders");
            System.out.println("14. Show Orders with Total Price > 10000");
            System.out.println("15. Show All Order Items");
            System.out.println("16. Show Order Items for a Product");
            System.out.println("17. Show Payment Details by Order ID");
            System.out.println("18. Show Payment Info by Payment ID");
            System.out.println("19. Add Payment");
            System.out.println("20. Update Payment");
            System.out.println("21. Show Pending Payments");
            System.out.println("22. Show Completed Payments");
//            System.out.println("23. Show Orders by Date Range");
//            System.out.println("24. Show Top 5 Products by Sales Quantity");
//            System.out.println("25. Show Customers with Most Orders");
//            System.out.println("26. Show Products Low in Stock (Stock < 10)");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                        customerDAO.showCustomers();
                        break;
                    case 2:
                        System.out.print("Enter Customer ID: ");
                        int customerId = scanner.nextInt();
                        customerDAO.searchCustomerById(customerId);
                        break;
                    case 3:
                        System.out.print("Enter Customer Username (Email): ");
                        String username = scanner.nextLine();
                        customerDAO.searchCustomerByUsername(username);
                        break;
                    case 4:
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();
                        boolean authenticated = customerDAO.authenticateCustomer(email, password);
                        System.out.println(authenticated ? "Authentication Successful" : "Authentication Failed");
                        break;
                    case 5:
                        System.out.print("Enter Customer Details (First Name, Last Name, Email, Password, Gender): ");
                        String[] customerData = scanner.nextLine().split(",");
                        customerDAO.addCustomer(
                                customerData[0].trim(),
                                customerData[1].trim(),
                                customerData[2].trim(),
                                customerData[3].trim(),
                                customerData[4].trim());
                        break;
                    case 6:
                        productDAO.showProducts();
                        break;
                    case 7:
                        System.out.print("Enter Product ID: ");
                        int productId = scanner.nextInt();
                        productDAO.searchProductById(productId);
                        break;
                    case 8:
                        System.out.print("Enter Product Details (Name, Price, Description, Stock Quantity): ");
                        String[] productData = scanner.nextLine().split(",");
                        productDAO.addProduct(
                                productData[0].trim(),
                                Double.parseDouble(productData[1].trim()),
                                productData[2].trim(),
                                Integer.parseInt(productData[3].trim()));
                        break;
                    case 9:
                        System.out.print("Enter Cart Details (Customer ID, Product ID, Quantity): ");
                        String[] cartData = scanner.nextLine().split(",");
                        cartDAO.addCart(
                                Integer.parseInt(cartData[0].trim()),
                                Integer.parseInt(cartData[1].trim()),
                                Integer.parseInt(cartData[2].trim()));
                        break;
                    case 10:
                        System.out.print("Enter Cart ID and New Quantity: ");
                        int cartId = scanner.nextInt();
                        int newQuantity = scanner.nextInt();
                        cartDAO.updateCart(cartId, newQuantity);
                        break;
                    case 11:
                        System.out.print("Enter Cart ID: ");
                        int searchCartId = scanner.nextInt();
                        cartDAO.searchCartById(searchCartId);
                        break;
                    case 12:
                        System.out.print("Enter Customer ID, Total Price, and Shipping Address: ");
                        int orderCustomerId = scanner.nextInt();
                        double totalPrice = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        String shippingAddress = scanner.nextLine();
                        orderDAO.placeOrder(orderCustomerId, totalPrice, shippingAddress);
                        break;
                    case 13:
                        System.out.print("Enter Customer ID to Show Orders: ");
                        int orderCustomerIdShow = scanner.nextInt();
                        orderDAO.showOrdersByCustomerId(orderCustomerIdShow);
                        break;
                    case 14:
                        orderDAO.showOrdersWithTotalPriceGreaterThan(10000);
                        break;
                    case 15:
                        orderDAO.showAllOrderItems();
                        break;
                    case 16:
                        System.out.print("Enter Product ID to Show Order Items: ");
                        int productOrderId = scanner.nextInt();
                        orderDAO.showOrderItemsByProductId(productOrderId);
                        break;
                    case 17:
                        System.out.print("Enter Order ID for Payment Details: ");
                        int paymentOrderId = scanner.nextInt();
                        paymentDAO.showPaymentDetailsByOrderId(paymentOrderId);
                        break;
                    case 18:
                        System.out.print("Enter Payment ID for Details: ");
                        int paymentId = scanner.nextInt();
                        paymentDAO.showPaymentById(paymentId);
                        break;
                    case 19:
                        System.out.print("Enter Payment Details (Order ID, Payment Method, Transaction ID, Payment Status): ");
                        String[] paymentData = scanner.nextLine().split(",");
                        paymentDAO.addPayment(
                                Integer.parseInt(paymentData[0].trim()),
                                paymentData[1].trim(),
                                paymentData[2].trim(),
                                paymentData[3].trim());
                        break;
                    case 20:
                        System.out.print("Enter Payment ID and New Payment Status: ");
                        int updatePaymentId = scanner.nextInt();
                        scanner.nextLine();
                        String newPaymentStatus = scanner.nextLine();
                        paymentDAO.updatePayment(updatePaymentId, newPaymentStatus);
                        break;
                    case 21:
                        paymentDAO.showPendingPayments();
                        break;
                    case 22:
                        paymentDAO.showCompletedPayments();
                        break;
                    case 23:
                        System.out.print("Enter Start Date (yyyy-mm-dd): ");
                        String startDate = scanner.nextLine();
                        System.out.print("Enter End Date (yyyy-mm-dd): ");
                        String endDate = scanner.nextLine();
                        orderDAO.showOrdersByDateRange(startDate, endDate);
                        break;
                    case 24:
                        productDAO.showTop5ProductsBySales();
                        break;
                    case 25:
                        customerDAO.showCustomersWithMostOrders();
                        break;
                    case 26:
                        productDAO.showLowStockProducts();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
