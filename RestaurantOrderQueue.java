import java.util.*;

// Node for Linked List
class OrderNode {
    int orderId;
    String customerName;
    String foodItem;
    OrderNode next;

    OrderNode(int orderId, String customerName, String foodItem) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.next = null;
    }
}

public class RestaurantOrderQueue {

    static Scanner sc = new Scanner(System.in);

    // Array to store all orders
    static OrderNode[] allOrders = new OrderNode[100];

    static int totalOrders = 0;
    static int orderId = 1;

    // Queue using Array
    static OrderNode[] queue = new OrderNode[100];

    static int front = 0;
    static int rear = -1;

    // Linked List for completed orders
    static OrderNode completedHead = null;

    // Add a new order
    static void addOrder() {

        if (rear == queue.length - 1) {
            System.out.println("Queue is full!");
            return;
        }

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter food item: ");
        String food = sc.nextLine();

        OrderNode newOrder = new OrderNode(orderId, name, food);

        // Add order to Queue
        queue[++rear] = newOrder;

        // Store order in Array
        allOrders[totalOrders++] = newOrder;

        System.out.println("\nOrder placed successfully!");
        System.out.println("Order ID: " + orderId);

        orderId++;
    }

    // Display pending orders
    static void displayQueue() {

        if (front > rear) {
            System.out.println("\nNo pending orders.");
            return;
        }

        System.out.println("\n===== PENDING ORDERS =====");

        for (int i = front; i <= rear; i++) {
            System.out.println("Order ID: " + queue[i].orderId);
            System.out.println("Customer: " + queue[i].customerName);
            System.out.println("Food: " + queue[i].foodItem);
            System.out.println("-------------------------");
        }
    }

    // Process the next order
    static void processOrder() {

        if (front > rear) {
            System.out.println("\nNo orders available to process!");
            return;
        }

        OrderNode order = queue[front++];

        System.out.println("\n===== ORDER PROCESSED =====");
        System.out.println("Order ID: " + order.orderId);
        System.out.println("Customer: " + order.customerName);
        System.out.println("Food: " + order.foodItem);
        System.out.println("Order served successfully!");

        // Add completed order to Linked List
        order.next = null;

        if (completedHead == null) {
            completedHead = order;
        } else {
            OrderNode temp = completedHead;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = order;
        }
    }

    // Display completed orders
    static void displayCompletedOrders() {

        if (completedHead == null) {
            System.out.println("\nNo completed orders yet.");
            return;
        }

        System.out.println("\n===== COMPLETED ORDERS =====");

        OrderNode temp = completedHead;

        while (temp != null) {
            System.out.println("Order ID: " + temp.orderId);
            System.out.println("Customer: " + temp.customerName);
            System.out.println("Food: " + temp.foodItem);
            System.out.println("-------------------------");

            temp = temp.next;
        }
    }

    // Search order using Array
    static void searchOrder() {

        System.out.print("Enter Order ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < totalOrders; i++) {

            if (allOrders[i].orderId == id) {

                System.out.println("\n===== ORDER FOUND =====");
                System.out.println("Order ID: " + allOrders[i].orderId);
                System.out.println("Customer: " + allOrders[i].customerName);
                System.out.println("Food: " + allOrders[i].foodItem);

                return;
            }
        }

        System.out.println("\nOrder not found!");
    }

    // Main Menu
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println(" RESTAURANT ORDER QUEUE SYSTEM ");
            System.out.println("================================");
            System.out.println("1. Add New Order");
            System.out.println("2. Display Pending Orders");
            System.out.println("3. Process Next Order");
            System.out.println("4. Display Completed Orders");
            System.out.println("5. Search Order");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addOrder();
                    break;

                case 2:
                    displayQueue();
                    break;

                case 3:
                    processOrder();
                    break;

                case 4:
                    displayCompletedOrders();
                    break;

                case 5:
                    searchOrder();
                    break;

                case 6:
                    System.out.println("\nThank you for using the system!");
                    break;

                default:
                    System.out.println("\nInvalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}