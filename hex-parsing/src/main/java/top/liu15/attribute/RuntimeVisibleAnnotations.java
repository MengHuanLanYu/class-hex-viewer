package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/22 16:35
 * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7.16
 */
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
        System.out.printf("长度 => %d\n", l);
        for (long i = 0; i < l; i++) {
            reader.read1();
        }
        if (1 == 1) {
            return;
        }
        int len = this.numAnnotations.getValue().intValue();
        if (len > 0) {
            this.annotations = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.annotations.add(new AnnotationEntity(reader));
            }
        }
    }

    @Getter
    public static class AnnotationEntity extends ComponentInfo {

        private U2 typeIndex;

        private U2 numElementValuePairs;

        private List<ElementValuePairs> elementValuePairs;

        public AnnotationEntity(ByteReader reader) {
            read(reader);
        }

        @Override
        public void read(ByteReader reader) {
            this.typeIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.numElementValuePairs = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            int len = this.numElementValuePairs.getValue().intValue();
            if (len > 0) {
                this.elementValuePairs = new ArrayList<>(len);
                for (int i = 0; i < len; i++) {
                    this.elementValuePairs.add(new ElementValuePairs(reader));
                }
            }
        }
    }
}
