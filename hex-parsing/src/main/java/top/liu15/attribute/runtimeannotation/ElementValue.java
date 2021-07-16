package top.liu15.attribute.runtimeannotation;

import lombok.Getter;
import top.liu15.datatype.*;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/24 9:03
 * https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.16.1
 */
@Getter
public final class ElementValue extends ComponentInfo {
    private U1 tag;

    private ComponentInfo value;

    public ElementValue(ByteReader reader) {
        read(reader);
    }

    @Override
    public void read(ByteReader reader) {
        readBefore(reader);

        this.readDescription(reader);

        readAfter(reader);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.tag = new U1(reader, i -> Character.toString((char) i.intValue()));
        int tagItem = this.tag.getValue().intValue();
        ElementItemEnum elementItemEnum = ElementItemEnum.valueOf(tagItem);
        this.value = elementItemEnum.getByteToComponent().apply(reader);
        super.setDescription(String.format("%s <%s>", (char) tagItem, elementItemEnum.name().replace("_", "").toLowerCase()));
    }
}
