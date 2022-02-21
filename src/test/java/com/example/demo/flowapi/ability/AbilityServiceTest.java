package com.example.demo.flowapi.ability;

import cn.hutool.core.map.MapBuilder;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ability.dto.CNoParam;
import com.example.demo.flowapi.ability.dto.CardListParam;
import com.example.demo.flowapi.ability.dto.RealNameAuthParam;
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
        abilityService.process("福信富通_移动", "bNo", "eid", JSONUtil.parseObj(
                MapBuilder.create().put("cNo", "cNo").build()));

        abilityService.process("福信富通_小米", "bNo", "eid", JSONUtil.parseObj(
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

    @DisplayName("location")
    @Test
    public void test3() {
        CNoParam cNoParam = new CNoParam().setCNo("1064657376099");
        abilityService.process("福信富通_小米卡", "bNo", "10002", JSONUtil.parseObj(cNoParam));
    }

    @DisplayName("realnameauth")
    @Test
    public void test4() {
        RealNameAuthParam param = new RealNameAuthParam().setStatus(1);
        abilityService.process("福信富通_移动", "bNo", "30009", JSONUtil.parseObj(param));
    }

} 
