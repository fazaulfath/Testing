//Program to define Order Service - place the order, update the status, retrieve order by ID and List all orders
package com.tnsif.onlineshopping.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.tnsif.onlineshopping.entities.Order;
import com.tnsif.onlineshopping.entities.Product;
import com.tnsif.onlineshopping.entities.ProductQuantityPair;

public class OrderService {
	private List<Order> orderList = new ArrayList<>();

	public OrderService() {
	}

	public void placeOrder (Order order) {
		orderList.add (order);
	}
	
	public boolean updateOrderStatus(int orderId, String status) {
        Order order = getOrder(orderId);

        if (order != null) {
            if ("Completed".equalsIgnoreCase(status) && "Pending".equalsIgnoreCase(order.getStatus())) {
                for (ProductQuantityPair pair : order.getProducts()) {
                    Product product = pair.getProduct();
                    int quantity = pair.getQuantity();

                    if (product.getStockQuantity() >= quantity) {
                        product.setStockQuantity(product.getStockQuantity() - quantity);
                    } else {
                        System.out.println("Insufficient stock for product: " + product.getName());
                        return false; // Stock issue, return false
                    }
                }
            } else if ("Cancelled".equalsIgnoreCase(status)) {
                if ("Completed".equalsIgnoreCase(order.getStatus()) || "Pending".equalsIgnoreCase(order.getStatus())) {
                    for (ProductQuantityPair pair : order.getProducts()) {
                        Product product = pair.getProduct();
                        int quantity = pair.getQuantity();
                        product.setStockQuantity(product.getStockQuantity() + quantity);
                    }
                }
            } else if ("Delivered".equalsIgnoreCase(status) && "Completed".equalsIgnoreCase(order.getStatus())) {
                // Only update the status to Delivered, no stock adjustment needed
            }
            order.setStatus(status);
            return true; // Status update successful
        } else {
            System.out.println("Invalid Order");
            return false; // Order not found, return false
        }
    }

	public Order getOrder (int orderId) {
		return orderList. stream() .filter (order -> order.getOrderId () == orderId) .findFirst () .orElse (null);
	}
	
	public List<Order> getOrders () {
		return orderList;
	}
	
	public List<Order> getOrdersForCustomer(int customerId) {
        return orderList.stream()
                .filter(order -> order.getCustomer().getUserId() == customerId)
                .collect(Collectors.toList());
    }
}
