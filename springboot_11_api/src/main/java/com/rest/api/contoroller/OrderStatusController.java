package com.rest.api.contoroller;

import com.rest.api.entity.OrderStatusEntity;
import com.rest.api.model.OrderStatus;
import com.rest.api.repo.OrderStatusJpaRepository;
import com.rest.api.service.OrderStatusService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/order_status")
public class OrderStatusController {

//    Serviceは必要なのか？規模が小さいならいらないでは？
    @NonNull
    private final OrderStatusService orderStatusService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<OrderStatusEntity> findByAll(){
        return this.orderStatusService.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderStatus findById(@PathVariable("id") String id){
        return this.orderStatusService.findById(id).orElseThrow(RuntimeException::new);
    }


    private final OrderStatusJpaRepository orderStatusJpaRepository;

    @GetMapping(value = "/no_service")
    public List<OrderStatusEntity> findAllUser() {
        return orderStatusJpaRepository.findAll();
    }

//    @PostMapping(value = "/user")
//    public User save(@ApiParam(value = "회원아이디", required = true) @RequestParam String uid,
//                     @ApiParam(value = "회원이름", required = true) @RequestParam String name) {
//        User user = User.builder()
//                .uid(uid)
//                .name(name)
//                .build();
//        return userJpaRepo.save(user);
//    }

}
