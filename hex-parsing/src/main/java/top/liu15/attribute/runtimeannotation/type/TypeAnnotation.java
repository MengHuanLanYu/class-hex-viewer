package top.liu15.attribute.runtimeannotation.type;

import lombok.Getter;
import top.liu15.attribute.runtimeannotation.AnnotationEntity;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U1;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/25 10:46
 * https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.20
 */
@Getter
public final class TypeAnnotation extends ComponentInfo {

    private U1 targetType;

    private ComponentInfo targetInfo;

    private TypePath targetPath;

    private AnnotationEntity annotationEntity;

    public TypeAnnotation(ByteReader reader) {
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
        this.targetType = new U1(reader);
        TargetInfoEnum targetInfoEnum = TargetInfoEnum.valueOf(this.targetType.getValue().intValue());
        this.targetInfo = targetInfoEnum.getByteToComponentInfo().apply(reader);
        this.targetPath = new TypePath(reader);
        this.annotationEntity = new AnnotationEntity(reader);
    }
}
