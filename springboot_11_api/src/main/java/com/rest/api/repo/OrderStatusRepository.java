package com.rest.api.repo;

import com.rest.api.entity.OrderStatusEntity;
import com.rest.api.object.OrderStatus;

import java.util.List;
import java.util.Optional;

public interface OrderStatusRepository {
    Optional<OrderStatus> findById(long id);

    List<OrderStatusEntity> findAll();
}
