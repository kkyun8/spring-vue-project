package com.rest.api.entity;

import com.rest.api.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "order_status")
public class OrderStatusEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    private String nameKanji;
    private String nameHurigana;
    private String createDate;
    private String updateDate;

    public static OrderStatus build(OrderStatus orderStatus) {
        return OrderStatus.builder()
                .id(orderStatus.getId())
                .name(orderStatus.getName())
                .nameKanji(orderStatus.getNameKanji())
                .nameHurigana(orderStatus.getNameHurigana())
                .createDate(orderStatus.getCreateDate())
                .updateDate(orderStatus.getUpdateDate())
                .build();

    }

    public OrderStatus toDomainOrderStatus() {
        return OrderStatus.builder()
                .id(this.id)
                .name(this.name)
                .nameKanji(this.nameKanji)
                .nameHurigana(this.nameHurigana)
                .createDate(this.createDate)
                .updateDate(this.updateDate)
                .build();
    }

}
