package com.example.demo.flowapi.ability;

import cn.hutool.core.map.MapBuilder;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ability.vo.CardListParam;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * AbilityService Tester.
 *
 * @author linkun
 * @version 1.0
 * @since <pre>2�� 16, 2022</pre>
 */
@SpringBootTest
public class AbilityServiceTest {
    @Autowired
    private AbilityService abilityService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @DisplayName("eid")
    @Test
    public void test() {
        abilityService.process("comid", "bNo", "eid", JSONUtil.parseObj(
                MapBuilder.create().put("cNo", "cNo").build()));
    }

    @DisplayName("cardList")
    @Test
    public void test2() {
        CardListParam cardListParam = new CardListParam();
        cardListParam.setBegin(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).minusDays(30).toInstant()));
        cardListParam.setEnd(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        cardListParam.setComId("comId");
        cardListParam.setBNo("bNo");
        cardListParam.setPage(1);
        cardListParam.setPageSize(20);
        abilityService.process("comid", "bNo", "cardList", JSONUtil.parseObj(cardListParam));
    }

} 
