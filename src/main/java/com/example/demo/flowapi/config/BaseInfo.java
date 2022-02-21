package com.example.demo.flowapi.config;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author linkun
 * @date 2022/2/21 9:53
 */
@Data
@Accessors(chain = true)
public class BaseInfo {
    private String otype;
}
