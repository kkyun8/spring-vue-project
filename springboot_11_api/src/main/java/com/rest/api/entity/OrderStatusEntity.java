package com.rest.api.entity;

import com.rest.api.object.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "order_status")
public class OrderStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
