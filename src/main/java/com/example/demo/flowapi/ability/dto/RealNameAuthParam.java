package com.example.demo.flowapi.ability.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author linkun
 * @date 2022/2/21 9:51
 */
@Data
@Accessors(chain = true)
public class RealNameAuthParam {
    private Integer status;
}
