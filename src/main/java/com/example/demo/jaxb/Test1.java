package com.example.demo.jaxb;

import cn.hutool.json.JSONUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author linkun
 * @date 2022/3/7 14:02
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        Student student = new Student()
                .setId("1")
                .setName("zhangsan")
                .setAge(29);
        toXml(student, Student.class);

        String str = "<ns2:student xmlns:ns2=\"http://www.w3cschool.org/jaxb2/\">" +
                "<ns2:age>29</ns2:age>" +
                "<ns3:id xmlns:ns3=\"http://www.baidu.com/\">1</ns3:id>" +
                "<name>zhangsan</name>" +
                "</ns2:student>";
        toJava(str, Student.class);

    }

    public static <T> void toXml(T t, Class<T> tClass) throws Exception {
        JAXBContext context = JAXBContext.newInstance(tClass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(t, sw);
        System.out.println(sw.getBuffer().toString());
    }

    public static <T> void toJava(String str, Class<T> tClass) throws Exception {
        JAXBContext context = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader sr = new StringReader(str);
        T student = (T) unmarshaller.unmarshal(sr);
        System.out.println(JSONUtil.toJsonStr(student));
    }


}
