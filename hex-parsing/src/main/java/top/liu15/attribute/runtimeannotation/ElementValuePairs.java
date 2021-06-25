package top.liu15.attribute.runtimeannotation;

import lombok.Getter;
import top.liu15.datatype.*;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/22 16:44
 * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7.16.1
 */
@Getter
public final class ElementValuePairs extends ComponentInfo {

    private U2 elementNameIndex;

    private ElementValue value;

    public ElementValuePairs(ByteReader byteReader) {
        read(byteReader);
    }

    @Override
    public void read(ByteReader reader) {
        readBefore(reader);

        this.readDescription(reader);

        readAfter(reader);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.elementNameIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
        this.value = new ElementValue(reader);
    }
}
