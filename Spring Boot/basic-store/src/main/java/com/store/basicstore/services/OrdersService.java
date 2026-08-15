package com.store.basicstore.services;

import com.store.basicstore.dto.OrderItemRequest;
import com.store.basicstore.dto.OrderRequest;
import com.store.basicstore.entities.OrderItem;
import com.store.basicstore.entities.Orders;
import com.store.basicstore.entities.Product;
import com.store.basicstore.repositories.OrdersRepository;
import com.store.basicstore.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Orders createOrder(OrderRequest orderRequest) {
        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;

        Orders order = new Orders();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("CONFIRMED");
        for(OrderItemRequest itemRequest : orderRequest.getItems()){
            Product product = productRepository.findById(itemRequest.getProductId()
            ).orElseThrow(()-> new RuntimeException("Product not found with this id"+itemRequest.getProductId()));
            // check the product stock
            if(product.getStockQuantity() < itemRequest.getQuantity()){
                throw new RuntimeException("Not enough stock for "+itemRequest.getQuantity());
            }
            // calculate total price
            BigDecimal priceOfItem = product.getPrice()
                    .multiply(BigDecimal.valueOf(itemRequest.getQuantity()));
            totalPrice = totalPrice.add(priceOfItem);
            // update the product table with latest stock quantity
            product.setStockQuantity(
                    product.getStockQuantity() - itemRequest.getQuantity()
            );
            productRepository.save(product);
            //Builder pattern to make object
            OrderItem orderItem = OrderItem.builder()
                    .orders(order)
                    .product(product)
                    .quantity(itemRequest.getQuantity())
                    .priceAtPurchase(product.getPrice())
                    .build();
            orderItems.add(orderItem);
        }
        order.setTotalPrice(totalPrice);
        order.setOrderItems(orderItems);
        return ordersRepository.save(order);
    }
}
