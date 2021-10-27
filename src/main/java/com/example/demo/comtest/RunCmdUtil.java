package com.example.demo.comtest;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.function.Consumer;

/**
 * @author huanglusen
 * @date 2020-03-25
 */
@Slf4j
public class RunCmdUtil {

    public static String exec(String cmd) {
        return exec(cmd, null, true);
    }

    public static String exec(String cmd, File dir, boolean print) {
        return exec(cmd, dir, print, null);
    }

    public static String exec(String cmd, File dir, boolean print, Consumer<String> consumerPrint) {
        return exec(cmd, dir, print, consumerPrint, null);
    }

    public static String exec(String cmd, File dir, boolean print, Consumer<String> consumerPrint, Consumer<Process> monitorThread) {
        try {
            StringBuilder resb = new StringBuilder();
            Runtime run = Runtime.getRuntime();
            if (print) {
                if (dir != null) {
                    System.out.println("执行命令：" + cmd + "; workDir=" + dir);
                } else {
                    System.out.println("执行命令：" + cmd);
                }
            }
            final Process p = run.exec(cmd, null, dir);
            InputStream ins = p.getInputStream();
            InputStream ers = p.getErrorStream();
            Thread thread1 = new Thread(new ReadRespThread(ins, System.out, resb, print, consumerPrint));
            thread1.start();
            Thread thread2 = new Thread(new ReadRespThread(ers, System.err, resb, print, consumerPrint));
            thread2.start();
            if (monitorThread != null) {
                Thread thread3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            monitorThread.accept(p);
                        } catch (Throwable e) {
                            log.error("monitorThread执行出错！cmd=" + cmd, e);
                        }
                    }
                });
                thread3.start();
            }
            p.waitFor();
            thread1.join(200);
            thread2.join(200);
            return resb.toString();
        } catch (Exception e) {
            log.error("", e);
            return "";
        }
    }

    static class ReadRespThread implements Runnable {
        private InputStream ins = null;
        private BufferedReader bfr = null;
        private PrintStream out;
        private StringBuilder resb;
        private boolean print;
        private Consumer<String> consumerPrint;

        public ReadRespThread(InputStream ins, PrintStream out, StringBuilder resb, boolean print, Consumer<String> consumerPrint) {
            this.ins = ins;
            this.out = out;
            this.resb = resb;
            this.print = print;
            this.consumerPrint = consumerPrint;
            try {
                String charset = System.getProperty("sun.jnu.encoding");
//                if(encoding != null) {
//                    charset = encoding;
//                }
                this.bfr = new BufferedReader(new InputStreamReader(ins, charset));
//                this.bfr = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
            } catch (Exception e) {
                log.error("", e);
            }
        }

        @Override
        public void run() {
            try {
                String line = bfr.readLine();
                while (line != null) {
                    if (print) {
                        out.println(line);
                    }
                    if (this.consumerPrint != null) {
                        consumerPrint.accept(line + "\n");
                    }
                    resb.append(line + "\n");
                    line = bfr.readLine();
                }
            } catch (IOException e) {
                log.error("", e);
            }
        }
    }


    public static void main(String[] args) {
        RunCmdUtil.exec("D:\\福信富通\\aboot-tools-2020.09.10-win-x64_old\\adownload.exe -p COM3 -s 115200 -q D:\\福信富通\\aboot-tools-2020.09.10-win-x64_old\\test.zip", new File("D:\\aaa"), true, printstr -> {
            try {
                FileUtils.write(new File("d:/aa.txt"), printstr, "utf-8", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
//        RunCmdUtil.exec("curl http://www.baidu.com", new File("D:\\aaa"), true, printstr -> {
//            try {
//                FileUtils.write(new File("d:/aa.txt"), printstr, "utf-8", true);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
    }

}
