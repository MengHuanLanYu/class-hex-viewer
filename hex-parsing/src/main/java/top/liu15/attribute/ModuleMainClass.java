package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/25 15:58
 * https://docs.oracle.com/javase/specs/jvms/se10/html/jvms-4.html#jvms-4.7.27
 */
@Getter
public final class ModuleMainClass extends AttributeInfo {

    private U2 mainClassIndex;

    public ModuleMainClass(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.mainClassIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }
}
