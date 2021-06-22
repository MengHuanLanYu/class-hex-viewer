package top.liu15.attribute;

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
        this.elementNameIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
        ElementValue elementValue = new ElementValue();
        elementValue.read(reader);
        this.value = elementValue;
    }

    @Getter
    public static class ElementValue extends ComponentInfo {
        private U1 tag;

        private U2 constValueIndex;

        private U2 typeNameIndex;




        @Override
        public void read(ByteReader reader) {
            this.tag = new U1(reader);
            this.constValueIndex = new U2(reader,UnsignedNumber.INT_TO_CP_INFO);

        }
    }
}
