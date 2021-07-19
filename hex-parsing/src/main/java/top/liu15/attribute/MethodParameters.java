package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U1;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/22 10:38
 */
@Getter
public final class MethodParameters extends AttributeInfo {

    private U1 parametersCount;

    private List<ParametersEntity> parameters;

    public MethodParameters(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.parametersCount = new U1(reader);
        int len = this.parametersCount.getValue().intValue();
        if (len > 0) {
            this.parameters = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.parameters.add(new ParametersEntity(reader));
            }
        }
    }

    @Getter
    public static class ParametersEntity {
        private U2 nameIndex;

        private U2 accessFlags;

        public ParametersEntity(ByteReader reader) {
            this.nameIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.accessFlags = new U2(reader);
            int value = this.accessFlags.getValue().intValue();
            if (value != 0) {
                this.accessFlags.setDescription(value == 0x0010 ? "final" : (value == 0x1000 ? "synthetic" : "mandated"));
            }
        }
    }
}
