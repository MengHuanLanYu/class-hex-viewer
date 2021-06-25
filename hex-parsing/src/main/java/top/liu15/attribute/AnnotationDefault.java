package top.liu15.attribute;

import lombok.Getter;
import top.liu15.attribute.runtimeannotation.ElementValue;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.structure.MethodInfo;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/25 10:27
 */
@Getter
public final class AnnotationDefault extends AttributeInfo {

    private ElementValue defaultValue;

    public AnnotationDefault(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.defaultValue = new ElementValue(reader);
    }
}
