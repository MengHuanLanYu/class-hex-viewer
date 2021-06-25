package top.liu15.attribute.runtimeannotation.type;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U1;
import top.liu15.datatype.U2;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/25 14:09
 * @see TargetInfoEnum
 */
@Getter
public final class TypeArgument extends ComponentInfo {

    private U2 offset;

    private U1 typeArgumentIndex;

    public TypeArgument(ByteReader reader) {
        read(reader);
    }

    @Override
    public void read(ByteReader reader) {
        this.offset = new U2(reader);
        this.typeArgumentIndex = new U1(reader);
    }
}
