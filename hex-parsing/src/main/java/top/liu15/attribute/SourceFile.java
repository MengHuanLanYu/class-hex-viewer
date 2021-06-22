package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/8 18:08
 */
@Getter
public final class SourceFile extends AttributeInfo {

    private U2 sourceFileIndex;

    public SourceFile(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.sourceFileIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }
}
