package com.example.demo.jaxb;

/**
 * @author linkun
 * @date 2022/3/7 15:18
 */
public class Test3 {

    public static void main(String[] args) throws Exception {
        String str = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <SOAP-ENV:Header/>\n" +
                "   <SOAP-ENV:Body>\n" +
                "      <ns2:GetModifiedTerminalsResponse ns2:requestId=\"S7Zvp7cP72430ztW\" xmlns:ns2=\"http://api.jasperwireless.com/ws/schema\">\n" +
                "         <ns2:correlationId>1</ns2:correlationId>\n" +
                "         <ns2:version>7.28</ns2:version>\n" +
                "         <ns2:build>Unknown</ns2:build>\n" +
                "         <ns2:timestamp>2022-03-07T03:34:05.032Z</ns2:timestamp>\n" +
                "         <ns2:iccids>\n" +
                "            <ns2:iccid>89860617040056466347</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464607</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465083</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465513</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056466354</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465091</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464136</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465950</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465109</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465539</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465968</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464144</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056466370</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465117</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464151</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465125</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056466388</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464169</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465133</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465984</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056466396</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465141</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465562</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464177</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056466404</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465158</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464664</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464185</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056466412</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056466008</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465166</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465588</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464193</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464672</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056466016</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056466420</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465174</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056466024</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056466438</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464680</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465182</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056466032</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465190</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464698</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465612</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464219</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465208</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056465620</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056466453</ns2:iccid>\n" +
                "            <ns2:iccid>89860617040056464706</ns2:iccid>\n" +
                "         </ns2:iccids>\n" +
                "         <ns2:totalPages>39</ns2:totalPages>\n" +
                "      </ns2:GetModifiedTerminalsResponse>\n" +
                "   </SOAP-ENV:Body>\n" +
                "</SOAP-ENV:Envelope>";
        Test1.toJava(str, Envelope.class);
    }
}
