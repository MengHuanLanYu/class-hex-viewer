package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/24 10:22
 * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7.7
 */
@Getter
public final class EnclosingMethod extends AttributeInfo {

    private U2 classIndex;

    private U2 methodIndex;

    public EnclosingMethod(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.classIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
        this.methodIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }
}
