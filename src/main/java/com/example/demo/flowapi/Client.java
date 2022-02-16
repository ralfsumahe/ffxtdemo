package com.example.demo.flowapi;

import cn.hutool.core.map.MapBuilder;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ability.AbilityService;

/**
 * @author linkun
 * @date 2022/2/16 16:00
 */
public class Client {
    public static void main(String[] args) {
        new AbilityService().process("comid", "bNo", "eid", JSONUtil.parseObj(
                MapBuilder.create().put("cNo", "cNo").build()));
    }
}
