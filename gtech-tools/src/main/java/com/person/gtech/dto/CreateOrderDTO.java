package com.person.gtech.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author 彭心潮
 * @date 2022/12/4 23:33
 */
@Data
public class CreateOrderDTO {

    private Integer createQty;

    private JSONObject orderIn;
}
