package top.liu15.attribute;

import lombok.Getter;
import top.liu15.attribute.runtimeannotation.AnnotationEntity;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/22 16:35
 * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7.16
 */
@Getter
public final class RuntimeVisibleAnnotations extends AttributeInfo {

    private U2 numAnnotations;

    private List<AnnotationEntity> annotations;

    public RuntimeVisibleAnnotations(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.numAnnotations = new U2(reader);
        long l = super.getAttributeLength().getValue().longValue() - 2;
        int len = this.numAnnotations.getValue().intValue();
        if (len > 0) {
            this.annotations = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.annotations.add(new AnnotationEntity(reader));
            }
        }
    }
}
