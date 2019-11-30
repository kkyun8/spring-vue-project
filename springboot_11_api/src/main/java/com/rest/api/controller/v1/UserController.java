package com.rest.api.controller.v1;

import com.rest.api.advice.exception.CUserNotFoundException;
import com.rest.api.entity.User;
import com.rest.api.model.response.CommonResult;
import com.rest.api.model.response.ListResult;
import com.rest.api.model.response.SingleResult;
import com.rest.api.repo.UserJpaRepo;
import com.rest.api.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"2. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    private final UserJpaRepo userJpaRepo;
    private final ResponseService responseService;

    @ApiOperation(value = "会員一覧", notes = "会員一覧取得")
    @GetMapping
    public ListResult<User> findAllUser(){
        return responseService.getListResult(userJpaRepo.findAll());
    }

    @GetMapping(value = "/{id}")
    public SingleResult<User> findUserByID(@RequestParam String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String getId = authentication.getName();
        return responseService.getSingleResult(userJpaRepo.findById(getId).orElseThrow(CUserNotFoundException::new));
    }

    @PutMapping
    public SingleResult<User> modify(
            @RequestParam String name, @RequestParam String password){
        User user = User.builder()
                .name(name).password(password).build();
        return responseService.getSingleResult(userJpaRepo.save(user));
    }

    @DeleteMapping(value = "{/id}")
    public CommonResult delete(@PathVariable Long id){
        userJpaRepo.deleteById(id);
        return responseService.getSuccessResult();
    }
}
