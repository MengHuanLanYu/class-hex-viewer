package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/24 10:27
 * https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.28
 */
@Getter
public final class NestHost extends AttributeInfo {

    private U2 hostClassIndex;

    public NestHost(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.hostClassIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }
}
