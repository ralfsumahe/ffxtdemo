package com.example.demo.comtest;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static jssc.SerialPort.*;

/**
 * @author linkun
 * @date 2021/10/26 19:50
 */
public class ThreadWrite {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws SerialPortException {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getId());
                    SerialPort port = new SerialPort("COM12");
                    port.openPort();
                    port.setParams(BAUDRATE_9600, DATABITS_8, STOPBITS_1, PARITY_NONE);
// port.setParams(9600, 8, 1, 0); // alternate technique
                    int mask = MASK_RXCHAR + MASK_CTS + MASK_DSR;
                    port.setEventsMask(mask);
                    port.addEventListener(new MyPortListener(port) /* defined below */);
                    port.writeString("你好com12");
                    while (port.isOpened()) {
                        Thread.sleep(100);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }

    }

    static class MyPortListener implements SerialPortEventListener {
        SerialPort port;

        public MyPortListener(SerialPort port) {
            this.port = port;
        }

        @Override
        public void serialEvent(SerialPortEvent event) {
            System.out.println(Thread.currentThread().getId());
            if (event.isRXCHAR()) { // data is available
                // read data, if 10 bytes available
                if (event.getEventValue() > 0) {
                    try {
//                    byte[] buffer = port.readBytes();
                        System.out.println(port.readString());
//                    System.out.println(new String(buffer));
                    } catch (SerialPortException ex) {
                        System.out.println(ex);
                    }
                }
            } else if (event.isCTS()) { // CTS line has changed state
                if (event.getEventValue() == 1) { // line is ON
                    System.out.println("CTS - ON");
                } else {
                    System.out.println("CTS - OFF");
                }
            } else if (event.isDSR()) { // DSR line has changed state
                if (event.getEventValue() == 1) { // line is ON
                    System.out.println("DSR - ON");
                } else {
                    System.out.println("DSR - OFF");
                }
            }
            try {
                port.closePort();
            } catch (SerialPortException e) {
                e.printStackTrace();
            }
        }
    }
}







