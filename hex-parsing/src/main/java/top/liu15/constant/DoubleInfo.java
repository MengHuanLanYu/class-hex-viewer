package top.liu15.constant;

import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U4;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/4 0:33
 */
public final class DoubleInfo extends ConstantInfo {

    private U4 highBytes;

    private U4 lowBytes;

    @Override
    public void readDescription(ByteReader reader) {
        // 计算当前偏描述
        // https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.5
        // ((long) high_bytes << 32) + low_bytes
        this.highBytes = new U4(reader, UnsignedNumber.LONG_TO_HEX);
        this.lowBytes = new U4(reader, UnsignedNumber.LONG_TO_HEX);
        double longBitsToDouble = Double.longBitsToDouble((this.highBytes.getValue() << 32) + this.lowBytes.getValue());
        super.setDescription(String.valueOf(longBitsToDouble));
    }
}
