package com.persion.study.sharding.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 彭心潮
 * @date 2022/10/15 17:03
 */
@Getter
@Setter
public class CreateOrderDto {

    private String shopId;

    private String memberId;

    private String orderType;
}
