package com.example.demo.jaxb;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author linkun
 * @date 2022/3/7 14:33
 */
@XmlRootElement
@Data
@Accessors(chain = true)
public class User {
    private String name;
    private String password;
    private Orders orders;

    @Data
    @Accessors(chain = true)
    public static class Orders {
        List<Order> order;
    }

    @Data
    @Accessors(chain = true)
    public static class Order {
        private String orderNo;
        private Double price;
        private String detail;
    }
}
