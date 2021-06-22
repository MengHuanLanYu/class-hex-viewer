package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.*;

/**
 * 属性信息
 *
 * @author lhy
 * @version 1.0
 * @date 2021/6/21 13:40
 */
@Getter
public class AttributeInfo extends ComponentInfo {

    protected U2 attributeNameIndex;

    protected U4 attributeLength;

    public AttributeInfo(String name) {
        super.setDescription(name);
    }

    @Override
    public void read(ByteReader reader) {
        readBefore(reader);

        this.attributeNameIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);

        this.attributeLength = new U4(reader);

        readDescription(reader);

        readAfter(reader);
    }
}
