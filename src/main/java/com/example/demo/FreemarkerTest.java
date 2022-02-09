package com.example.demo;

import cn.hutool.extra.template.TemplateUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linkun
 * @date 2021/11/4 17:52
 */
public class FreemarkerTest {
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        params.put("param", "01");
        params.put("num", 1);
        System.out.println(TemplateUtil.createEngine().getTemplate("${num?string('0000')}").render(params));
    }
}
