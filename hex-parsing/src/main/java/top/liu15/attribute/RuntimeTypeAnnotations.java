package top.liu15.attribute;

import lombok.Getter;
import top.liu15.attribute.runtimeannotation.type.TypeAnnotation;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/25 10:41
 * https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.20
 * https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.21
 * RuntimeVisibleTypeAnnotations_attribute {
 * &nbsp;u2              attribute_name_index;
 * &nbsp;u4              attribute_length;
 * &nbsp;u2              num_annotations;
 * &nbsp;type_annotation annotations[num_annotations];
 * }
 */
@Getter
public final class RuntimeTypeAnnotations extends AttributeInfo {

    private U2 numAnnotations;

    private List<TypeAnnotation> annotations;

    public RuntimeTypeAnnotations(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.numAnnotations = new U2(reader);
        int len = this.numAnnotations.getValue().intValue();
        if (len > 0) {
            this.annotations = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.annotations.add(new TypeAnnotation(reader));
            }
        }
    }
}
