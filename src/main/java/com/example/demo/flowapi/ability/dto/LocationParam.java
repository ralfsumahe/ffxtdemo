package com.example.demo.flowapi.ability.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author linkun
 * @date 2022/2/23 11:24
 */
@Data
@Accessors(chain = true)
public class LocationParam extends BaseParam {
    private String cNo;

    /**
     * 剩下次数
     */
    private int leaveTimes;
}
