package com.rest.api.object;

import lombok.Builder;
import lombok.Data;

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

