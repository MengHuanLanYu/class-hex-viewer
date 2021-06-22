package top.liu15.structure;

import java.nio.ByteBuffer;
import java.util.function.Function;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/22 15:19
 */
public interface CodeInstructionConversion {

    /**
     * 得到一字节常量值
     */
    Function<ByteBuffer, String> TO_BYTE_CONST_STRING = buffer -> String.format(" %d", buffer.get());

    /**
     * 得到两个字节常量值
     */
    Function<ByteBuffer, String> TO_SHORT_CONST_STRING = buffer -> String.format(" %d", buffer.getShort());

    /**
     * 常量池索引的
     */
    Function<ByteBuffer, String> TO_BYTE_CP_INFO_STRING = buffer -> String.format(" #%d", buffer.get());

    /**
     * 常量池索引的
     */
    Function<ByteBuffer, String> TO_SHORT_CP_INFO_STRING = buffer -> String.format(" #%d", buffer.getShort());

    /**
     * 位置跳转的
     */
    Function<ByteBuffer, String> TO_POSITION_JUMP_STRING = buffer -> String.format(" (+%d)", buffer.getShort());


    /**
     * ++i
     * --i
     * +=?
     */
    Function<ByteBuffer, String> TO_INCREMENT_STRING = buffer -> String.format(" %d by %d", buffer.get(), buffer.get());


    /**
     * invokeinterface
     * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html#jvms-6.5.invokeinterface
     */
    Function<ByteBuffer, String> TO_INVOKE_STRING = buffer -> String.format(" #%d , %d , %d", buffer.getShort(), buffer.get(), buffer.get());


    /**
     * 数组类型
     * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html#jvms-6.5.newarray
     */
    Function<ByteBuffer, String> TO_ARRAY_TYPE_STRING = buffer -> {
        byte b = buffer.get();
        switch (b) {
            case 4:
                return " boolean";
            case 5:
                return " char";
            case 6:
                return " float";
            case 8:
                return " double";
            case 9:
                return " short";
            case 10:
                return " int";
            case 11:
                return " long";
            default:
                return "";
        }
    };

    /**
     * 宽索引跳转
     * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html#jvms-6.5.goto_w
     * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html#jvms-6.5.jsr_w
     */
    Function<ByteBuffer, String> TO_GOTO_WIDE_STRING = buffer -> {
        byte b1 = buffer.get();
        byte b2 = buffer.get();
        byte b3 = buffer.get();
        byte b4 = buffer.get();
        return String.format(" %d", (b1 << 24) | (b2 << 16) | (b3 << 8) | b4);
    };


    /**
     * 多维数据操作
     * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html#jvms-6.5.multianewarray
     */
    Function<ByteBuffer, String> TO_MULTIDIMENSIONAL_STRING = buffer -> String.format(" #%d , %d", buffer.getShort(), buffer.get());
}
