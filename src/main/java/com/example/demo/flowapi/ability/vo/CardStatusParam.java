package com.example.demo.flowapi.ability.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author linkun
 * @date 2022/2/16 15:10
 */
@Data
@Accessors(chain = true)
public class CardStatusParam {
    private String cNo;
}
