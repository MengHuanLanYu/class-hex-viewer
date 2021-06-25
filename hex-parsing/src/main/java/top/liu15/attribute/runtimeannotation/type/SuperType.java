package top.liu15.attribute.runtimeannotation.type;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U1;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/25 13:45
 * @see TargetInfoEnum
 */
@Getter
public final class SuperType extends ComponentInfo {

    private U1 typeParameterIndex;

    private U1 boundIndex;

    public SuperType(ByteReader reader) {
        read(reader);
    }

    @Override
    public void read(ByteReader reader) {
        this.typeParameterIndex = new U1(reader);
        this.boundIndex = new U1(reader);
    }
}
