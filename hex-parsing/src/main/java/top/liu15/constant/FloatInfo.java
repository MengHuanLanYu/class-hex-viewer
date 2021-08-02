package top.liu15.constant;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U4;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/3 23:06
 */
@Getter
public final class FloatInfo extends ConstantInfo {

    private U4 bytes;


    @Override
    public void readDescription(ByteReader reader) {
        // 读取高位在前的float值
        this.bytes = new U4(reader, UnsignedNumber.LONG_TO_HEX);
        // https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.4
        // 填充自己
        super.setDescription(String.valueOf(Float.intBitsToFloat(this.bytes.getValue().intValue())));
    }
}
