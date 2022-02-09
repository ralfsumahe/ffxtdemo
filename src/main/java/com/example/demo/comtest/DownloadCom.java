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
//        String portName = SerialPortList.getPortNames()[0];
//        System.out.println(portName);
//        exe(new String[]{"D:\\福信富通\\aboot-tools-2020.09.10-win-x64_old\\adownload.exe", "-p", portName, "-s", "115200", "D:\\福信富通\\aboot-tools-2020.09.10-win-x64_old\\test.zip"});
        exe(new String[]{"curl", "https://www.csdn.net/"});
//        exe(new String[]{"D:\\apache-tomcat-9.0.50\\bin\\startup.bat"});
    }

    public static void exe(String[] cmds) {
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        BufferedReader reader = null;
        try {
            p = process.start();
//            System.out.println(p.pid());
            p.destroy();
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line != null) {
                    log.info(line);
                }

            }
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
