package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExe {
    public static void main(String[] args) {
        String[] cmds = {"curl", "http://www.baidu.com"};//必须分开写，不能有空格
//        System.out.println(execCurl(cmds));

        Map<Integer, String> map = new ConcurrentHashMap();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int x = i;
            map.put(i, "begin");
            executorService.submit(() -> {
                System.out.println(execCurl(cmds));
                map.put(x, "end");
            });
        }

        while (true) {
            map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
            System.out.println("=========================================");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static String execCurl(String[] cmds) {
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder.toString();

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
        return null;
    }


    public static void openExe() {
        Runtime rn = Runtime.getRuntime();
        Process p = null;
        try {
            p = rn.exec("D:/BeTheBest/stitp/NLPIR-Parser/bin-win64/NLPIR-Parser.exe");
        } catch (Exception e) {
            System.out.println("Error exec!");
        }
    }

}
