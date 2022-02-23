package com.example.demo.flowapi.ability.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author linkun
 * @date 2022/2/21 10:27
 */
@Data
@Accessors(chain = true)
public class GprsContrlParam extends BaseParam {
    private byte optType;
}
