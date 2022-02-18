package com.example.demo.flowapi.ability.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author linkun
 * @date 2022/2/18 15:15
 */
@Data
@Accessors(chain = true)
public class LocationResult {
    private double lat;
    private double lon;
}
