package com.rest.api.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {

    @ApiModelProperty(value = "処理結果：ture or false")
    private boolean success;

    @ApiModelProperty(value = "処理コード：>= 0 正常, < 0 異常")
    private int code;

    @ApiModelProperty(value = "処理メッセージ")
    private String msg;
}
