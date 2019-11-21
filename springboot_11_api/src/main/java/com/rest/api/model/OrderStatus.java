package com.rest.api.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
public class OrderStatus {

    private String id;
    private int orderStatus;
    private String name;
    private String nameKanji;
    private String nameHurigana;
    private String createDate;
    private String updateDate;
}

