package com.example.demo.flowapi.apiservice.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author linkun
 * @date 2022/2/16 15:10
 */
@Data
@Accessors(chain = true)
public class CardStatusResult {
    private int status;
}
