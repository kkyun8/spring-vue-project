package com.rest.api.controller.v1;

import com.rest.api.entity.OrderStatusEntity;
import com.rest.api.exception.COrderStatusNotFoundException;
import com.rest.api.model.response.CommonResult;
import com.rest.api.model.response.ListResult;
import com.rest.api.model.response.SingleResult;
import com.rest.api.repo.OrderStatusJpaRepository;
import com.rest.api.service.OrderStatusService;
import com.rest.api.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
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

    private final OrderStatusService orderStatusService;
    private final OrderStatusJpaRepository orderStatusJpaRepository;
    private final ResponseService responseService;


    //   Controller->Service->Repository example
    @ApiOperation(value = "オーダーの状態マスタすべて", notes = "すべてを表示（@serviceあり）")
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ListResult<OrderStatusEntity> findByAll(){
        return responseService.getListResult(orderStatusJpaRepository.findAll());
    }

    @ApiOperation(value = "１つのオーダーの状態マスタ取得", notes = "オーダー状態マスタの１つを表示（@serviceあり）")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SingleResult<OrderStatusEntity> findById(@PathVariable("id") long id) throws Exception {
        return responseService.getSingleResult(orderStatusJpaRepository.findById(id).orElseThrow(COrderStatusNotFoundException::new));
    }

    @ApiOperation(value = "オーダー状態マスタ新規登録")
    @PostMapping()
    public SingleResult<OrderStatusEntity> save(@RequestParam String name, @RequestParam String nameKanji,
                                          @RequestParam String nameHurigana){
         OrderStatusEntity orderStatus = OrderStatusEntity.builder()
                .name(name)
                .nameKanji(nameKanji)
                .nameHurigana(nameHurigana)
                .build();
        return responseService.getSingleResult(orderStatusJpaRepository.save(orderStatus));
    }

    @ApiOperation(value = "オーダー状態マスタ更新")
    @PutMapping(value = "/{id}")
    public SingleResult<OrderStatusEntity> modify( @RequestParam long id,
            @RequestParam String name, @RequestParam String nameKanji,
            @RequestParam String nameHurigana ) {
        OrderStatusEntity orderStatus = OrderStatusEntity.builder()
                .id(id).name(name).nameKanji(nameKanji).nameHurigana(nameHurigana)
                .build();
        return responseService.getSingleResult(orderStatusJpaRepository.save(orderStatus));
    }

    @ApiOperation(value = "オーダー状態マスタ削除")
    @DeleteMapping(value = "/{id}")
    public CommonResult delete(@PathVariable long id) {
        orderStatusJpaRepository.deleteById(id);
        return responseService.getSuccessResult();
    }
//    Controller->Repository example

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
