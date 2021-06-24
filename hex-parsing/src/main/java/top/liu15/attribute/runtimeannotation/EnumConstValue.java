package top.liu15.attribute.runtimeannotation;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U2;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/24 17:09
 */
@Getter
public final class EnumConstValue extends ComponentInfo {

    private U2 typeNameIndex;

    private U2 constNameIndex;

    public EnumConstValue(ByteReader reader) {
        read(reader);
    }

    @Override
    public void read(ByteReader reader) {
        this.typeNameIndex = new U2(reader);
        this.constNameIndex = new U2(reader);
    }
}
