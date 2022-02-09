package com.example.demo.comtest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linkun
 * @date 2021/11/2 17:01
 */
public class ByteTest {
    public static void main(String[] args) {
        System.out.println(HexConvert.convertStringToHex("F"));
        System.out.println(HexConvert.convertStringToHex("1"));
        System.out.println(HexConvert.BinaryToHexString(HexConvert.hexStringToBytes("4631")));

        System.out.println(HexConvert.BinaryToHexString(HexConvert.StringToByte("F1")));

//        findMessage();
    }

    public static void findMessage() {
        byte[] bs = new byte[]{0x33, 0x22, 0x11,
                0x3A, 0x34, 0x35, 0x32, 0x42, 0x30, 0x30, 0x30, 0x32, 0x45, 0x32, 0x30, 0x37, 0x34, 0x38
                , 0x35, 0x36, 0x33, 0x31, 0x32, 0x45, 0x33, 0x31, 0x32, 0x45, 0x33, 0x30, 0x45, 0x33, 0x30, 0x37, 0x35,
                0x33, 0x35, 0x36, 0x33, 0x31, 0x32, 0x45, 0x33, 0x31, 0x32, 0x45, 0x33, 0x30, 0x39, 0x38, 0x0D, 0x0A, 0x22, 0x11,
                0x3A, 0x34, 0x35, 0x32, 0x42, 0x0D, 0x0A, 0x3A, 0x33, 0x31, 0x32, 0x45, 0x33,};
        ByteBuf bytebuf = ByteBufAllocator.DEFAULT.buffer();
        bytebuf.writeBytes(bs);
        List<byte[]> results = getDatas(bytebuf);

        System.out.println("====byteBuf====");
        System.out.println(bytebuf);


        System.out.println("==================================================================================");
        results.stream().forEach(bytes -> {
            String hexString = HexConvert.BinaryToHexString(bytes);
            System.out.println(hexString);

//            String hexString = HexConvert.BinaryToHexString(bytes);
//            System.out.println(hexString);
//            hexString = hexString.replace(" ", "");//去除空格
//            System.out.println(hexString);
//            String asc = HexConvert.convertHexToString("3438353633313245333132453330");//转为ASCII,如：*00007VERSION\n1$
//            System.out.println(asc);
        });
    }


    private static List<byte[]> getDatas(ByteBuf byteBuf) {
        List<byte[]> results = new ArrayList<>();
        ByteBuf temp = ByteBufAllocator.DEFAULT.buffer(1024);
        boolean findHead = false;
        boolean findTail = false;
        while (byteBuf.isReadable()) {
            byte b = byteBuf.readByte();
            if (!findHead) {
                if (b != 0x3A) {
                    continue;
                } else {
                    findHead = true;
                    temp.writeByte(b);
                }
            } else if (!findTail) {
                temp.writeByte(b);
                if (b == 0x0D) {
                    findTail = true;
                }
            } else {
                temp.writeByte(b);
                if (b == 0x0A) {
                    byte[] result = new byte[temp.writerIndex() - temp.readerIndex()];
                    temp.readBytes(result, 0, temp.writerIndex() - temp.readerIndex());
                    results.add(result);
                    temp.discardReadBytes();
                    findHead = false;
                    findTail = false;
                } else {
                    findTail = false;
                }
            }
        }
        byteBuf.discardReadBytes();
        byteBuf.writeBytes(temp, temp.writerIndex() - temp.readerIndex());
        return results;
    }
}
