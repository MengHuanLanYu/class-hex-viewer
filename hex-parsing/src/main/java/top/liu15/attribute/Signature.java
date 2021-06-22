package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/22 17:10
 */
@Getter
public final class Signature extends AttributeInfo {

    private U2 signatureIndex;

    public Signature(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.signatureIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }
}
