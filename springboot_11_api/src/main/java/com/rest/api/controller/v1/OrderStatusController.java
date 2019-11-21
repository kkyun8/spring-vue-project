package com.rest.api.controller.v1;

import com.rest.api.entity.OrderStatusEntity;
import com.rest.api.object.OrderStatus;
import com.rest.api.repo.OrderStatusJpaRepository;
import com.rest.api.service.OrderStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"1. order_status"})
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/order_status")
public class OrderStatusController {

//   Controller->Service->Repository example
    @NonNull
    private final OrderStatusService orderStatusService;

    @ApiOperation(value = "オーダーの状態マスタすべて", notes = "すべてを表示（@serviceあり）")
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<OrderStatusEntity> findByAll(){
        return this.orderStatusService.findAll();
    }

    @ApiOperation(value = "１つのオーダーの状態マスタ取得", notes = "オーダー状態マスタの１つを表示（@serviceあり）")
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderStatus findById(@PathVariable("id") String id){
        return this.orderStatusService.findById(id).orElseThrow(RuntimeException::new);
    }


//    Controller->Repository example
    private final OrderStatusJpaRepository orderStatusJpaRepository;

    @ApiOperation(value = "オーダーの状態マスタすべて", notes = "すべてを表示（@serviceなし）")
    @GetMapping(value = "/no_service")
    public List<OrderStatusEntity> findAllUser() {
        return orderStatusJpaRepository.findAll();
    }

//    string data json 表示
    @GetMapping(value = "/test/json")
    @ResponseBody
    public Hello testJson() {
        Hello test = new Hello();
        test.message = "helloworld";
        return test;
    }

    @Setter
    @Getter
    public static class Hello {
        private String message;
    }

}
