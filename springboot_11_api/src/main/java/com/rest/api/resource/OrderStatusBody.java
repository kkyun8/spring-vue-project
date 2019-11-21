package com.rest.api.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrderStatusBody {

    @NotBlank
    private String id;

    @NotBlank
    private String name;


}
