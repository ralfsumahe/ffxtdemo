package com.example.demo.comtest;

import jssc.SerialPort;
import jssc.SerialPortException;

import static jssc.SerialPort.*;

public class WRCom {
    public static void main(String[] args) {
        write();
//        read();
    }

    public static void read() {
        SerialPort port = new SerialPort("COM5");
        try {
            port.openPort();
            port.setParams(BAUDRATE_9600, DATABITS_8, STOPBITS_1, PARITY_NONE);
            // port.setParams(9600, 8, 1, 0); // alternate technique

            System.out.println(port.readString());
            port.closePort();
        } catch (SerialPortException e) {
            e.printStackTrace();
        }

    }

    public static void write() {
        SerialPort port = new SerialPort("COM4");
        try {
            port.openPort();
            port.setParams(BAUDRATE_9600, DATABITS_8, STOPBITS_1, PARITY_NONE);
            // port.setParams(9600, 8, 1, 0); // alternate technique
            port.writeBytes("Testing serial from Java".getBytes());
            port.closePort();
        } catch (SerialPortException e) {
            e.printStackTrace();
        }

    }
}
