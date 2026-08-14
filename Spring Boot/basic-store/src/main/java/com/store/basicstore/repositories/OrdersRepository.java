package com.store.basicstore.repositories;

import com.store.basicstore.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
}
