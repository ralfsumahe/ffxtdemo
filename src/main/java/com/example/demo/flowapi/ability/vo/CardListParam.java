package com.example.demo.flowapi.ability.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author linkun
 * @date 2022/2/16 16:57
 */
@Data
@Accessors(chain = true)
public class CardListParam {
    private String comId;
    private String bNo;
    private Date begin;
    private Date end;
    private int page;
    private int pageSize;
}
