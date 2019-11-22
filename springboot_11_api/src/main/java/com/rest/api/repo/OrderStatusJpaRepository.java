package com.rest.api.repo;

import com.rest.api.entity.OrderStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusJpaRepository extends JpaRepository<OrderStatusEntity, String> {
}
