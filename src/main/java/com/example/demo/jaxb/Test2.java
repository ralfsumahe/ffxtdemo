package com.example.demo.jaxb;

import cn.hutool.core.collection.ListUtil;

/**
 * @author linkun
 * @date 2022/3/7 14:32
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        User user = new User()
                .setName("zhangsan")
                .setPassword("123456")
                .setOrders(new User.Orders().setOrder(ListUtil.of(new User.Order().setOrderNo("20220304").setPrice(100.0).setDetail("一本书"),
                        new User.Order().setOrderNo("20220305").setPrice(1250.0).setDetail("吸尘器"))));

        Test1.toXml(user, User.class);


        String str = "<user><name>zhangsan</name><orders><order><detail>一本书</detail><orderNo>20220304</orderNo><price>100.0</price></order>" +
                "<order><detail>吸尘器</detail><orderNo>20220305</orderNo><price>1250.0</price></order></orders><password>123456</password></user>";
        Test1.toJava(str, User.class);
    }


}
