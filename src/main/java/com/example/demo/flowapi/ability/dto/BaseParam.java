package com.example.demo.flowapi.ability.dto;

import com.example.demo.flowapi.config.BaseInfo;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author linkun
 * @date 2022/2/23 10:48
 */
@Data
@Accessors(chain = true)
public class BaseParam {
    private BaseInfo baseInfo;
}
