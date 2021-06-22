package top.liu15.datatype;

import java.util.function.Function;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/9 10:46
 */
public interface UnsignedNumber {

    /**
     * 获取一个无符号数
     */
    Function<ByteReader, Integer> U1 = ByteReader::readU1;

    /**
     * 两个字节无符号数
     */
    Function<ByteReader, Integer> U2 = ByteReader::readU2;


    /**
     * 四个字节无符号数
     */
    Function<ByteReader, Long> U4 = ByteReader::readU4;

    /**
     * 整型转换为十六进制哈希值
     */
    Function<Integer, String> INT_TO_HEX = v -> String.format("0x%04x", v).toUpperCase();


    /**
     * 长整型转换为十六进制哈希值
     */
    Function<Long, String> LONG_TO_HEX = v -> String.format("0x%08x", v).toUpperCase();

    /**
     * 整型转换为常量池标记
     */
    Function<Integer, String> INT_TO_CP_INFO = v -> String.format("cp_info #%s", v);


    /**
     * 整型转换为普通字符串
     */
    Function<Integer, String> INT_TO_STR = v -> String.valueOf(v);

    /**
     * 长整型转换为普通字符串
     */
    Function<Long, String> LONG_TO_STR = v -> String.valueOf(v);
}
