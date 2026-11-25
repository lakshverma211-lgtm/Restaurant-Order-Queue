# Restaurant Order Queue System

A console-based Java application for managing restaurant orders using an array as a queue and a linked list for completed orders.

## Features

- Add a new customer order
- Display pending orders
- Process the next order
- Display completed orders
- Search for an order by ID
- Exit the application

## Data Structures

- **Array queue:** Stores pending orders in FIFO (First In, First Out) order
- **Array:** Keeps references to all orders for ID-based searching
- **Linked list:** Stores completed orders

## Requirements

- Java Development Kit (JDK) 8 or later

## Run the Application

Open a terminal in the project directory and run:

```powershell
javac RestaurantOrderQueue.java
java RestaurantOrderQueue
```

## Menu

1. Add New Order
2. Display Pending Orders
3. Process Next Order
4. Display Completed Orders
5. Search Order
6. Exit

## Example

When placing an order, enter the customer name and food item. The system automatically assigns an order ID and adds the order to the pending queue.

```text
Enter customer name: Alex
Enter food item: Pizza

Order placed successfully!
Order ID: 1
```

## Project File

- `RestaurantOrderQueue.java` - Main application source code
