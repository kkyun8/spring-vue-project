package com.rest.api.repo;

import com.rest.api.entity.OrderStatusEntity;
import com.rest.api.object.OrderStatus;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderStatusRepositoryImpl implements OrderStatusRepository{

    @NonNull
    private final OrderStatusJpaRepository orderStatusJpaRepository;

    @Override
    public Optional<OrderStatus> findById(String id) {
        return this.orderStatusJpaRepository.findById(id)
                .map(OrderStatusEntity::toDomainOrderStatus);
    }

    @Override
    public List<OrderStatusEntity> findAll() {
        return this.orderStatusJpaRepository.findAll();
    }

}
