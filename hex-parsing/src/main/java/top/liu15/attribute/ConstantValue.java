package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/22 16:31
 */
@Getter
public final class ConstantValue extends AttributeInfo {

    private U2 constantValueIndex;

    public ConstantValue(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.constantValueIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }
}
