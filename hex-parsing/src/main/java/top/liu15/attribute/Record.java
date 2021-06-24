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
 * @date 2021/6/24 10:32
 * https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.30
 */
@Getter
public final class Record extends AttributeInfo {

    private U2 componentsCount;

    private List<RecordComponentInfo> components;

    public Record(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.componentsCount = new U2(reader);
        int len = this.componentsCount.getValue().intValue();
        if (len > 0) {
            this.components = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.components.add(new RecordComponentInfo(reader));
            }
        }
    }

    @Getter
    public static class RecordComponentInfo extends ComponentInfo {

        private U2 nameIndex;

        private U2 descriptorIndex;

        /**
         * 属性
         */
        private AttributeTable attributes;

        public RecordComponentInfo(ByteReader reader) {
            read(reader);
        }

        @Override
        public void read(ByteReader reader) {
            this.nameIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.descriptorIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.attributes = new AttributeTable(reader);
        }
    }
}
