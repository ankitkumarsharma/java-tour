package com.store.basicstore.controllers;

import com.store.basicstore.dto.OrderRequest;
import com.store.basicstore.entities.Orders;
import com.store.basicstore.services.OrdersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrdersService ordersService;

    @PostMapping
    public Orders createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        return ordersService.createOrder(orderRequest);
    }

    // get all orders
    // get order by id
}
