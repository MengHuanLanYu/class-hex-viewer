package top.liu15.attribute.runtimeannotation;

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
 * @date 2021/6/24 9:02
 */
@Getter
public final class AnnotationEntity extends ComponentInfo {

    private U2 typeIndex;

    private U2 numElementValuePairs;

    private List<ElementValuePairs> elementValuePairs;

    public AnnotationEntity(ByteReader reader) {
        read(reader);
    }

    @Override
    public void read(ByteReader reader) {
        this.typeIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
        this.numElementValuePairs = new U2(reader);
        int len = this.numElementValuePairs.getValue().intValue();
        if (len > 0) {
            this.elementValuePairs = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.elementValuePairs.add(new ElementValuePairs(reader));
            }
        }
    }
}
