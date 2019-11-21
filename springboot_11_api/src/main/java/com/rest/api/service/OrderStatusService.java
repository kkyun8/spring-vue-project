package com.rest.api.service;

import com.rest.api.entity.OrderStatusEntity;
import com.rest.api.object.OrderStatus;
import com.rest.api.repo.OrderStatusRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderStatusService {

    @NonNull
    private final OrderStatusRepository orderStatusRepository;

    public Optional<OrderStatus> findById(String id){

        return  this.orderStatusRepository.findById(id);
    }

    public List<OrderStatusEntity> findAll() {
        return  this.orderStatusRepository.findAll();
    }
}
