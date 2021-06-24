package top.liu15.attribute.runtimeannotation;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/24 17:12
 */
@Getter
public final class ArrayValue extends ComponentInfo {

    private U2 numValues;

    private List<ElementValue> values;

    public ArrayValue(ByteReader reader) {
        read(reader);
    }

    @Override
    public void read(ByteReader reader) {
        this.numValues = new U2(reader);
        int len = this.numValues.getValue().intValue();
        if (len > 0) {
            this.values = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.values.add(new ElementValue(reader));
            }
        }
    }
}
