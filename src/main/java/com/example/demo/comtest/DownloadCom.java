package com.example.demo.comtest;

import jssc.SerialPortList;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class DownloadCom {
    public static void main(String[] args) {
//        listPort();
        download();
    }

    public static void listPort() {
        //com列表
        for (String port : SerialPortList.getPortNames()) {
            System.out.println(port);
        }
    }

    public static void download() {
        String portName = SerialPortList.getPortNames()[0];
        System.out.println(portName);
        exe(new String[]{"D:\\福信富通\\aboot-tools-2020.09.10-win-x64_old\\adownload.exe", "-p", portName, "-s", "115200", "D:\\福信富通\\aboot-tools-2020.09.10-win-x64_old\\test.zip"});
    }

    public static void exe(String[] cmds) {
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        BufferedReader reader = null;
        try {
            p = process.start();
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                log.info(line);
//                builder.append(line);
//                builder.append(System.getProperty("line.separator"));
            }
//            return builder.toString();
            reader.close();

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        return null;
    }
}
