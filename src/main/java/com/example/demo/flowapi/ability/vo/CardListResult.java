package com.example.demo.flowapi.ability.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author linkun
 * @date 2022/2/16 16:58
 */
@Data
@Accessors(chain = true)
public class CardListResult {
    List<String> cardNos;
}
