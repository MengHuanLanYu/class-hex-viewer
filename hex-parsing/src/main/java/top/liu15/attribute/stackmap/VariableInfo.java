package top.liu15.attribute.stackmap;

import lombok.Getter;
import top.liu15.datatype.*;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/23 15:29
 */
public final class VariableInfo extends ComponentInfo {

    private enum type {
        TOP,
        INTEGER,
        FLOAT,
        DOUBLE,
        LONG,
        NULL,
        UNINITIALIZED_THIS,
        OBJECT,
        UNINITIALIZED;
    }

    private StringBuilder desc;

    public VariableInfo(ByteReader reader, String desc) {
        this.desc = new StringBuilder(desc).append("\n\r");
        // 读取前
        readBefore(reader);
        // 读取中
        read(reader);
        // 读取后
        readAfter(reader);
    }

    @Override
    public void read(ByteReader reader) {
        U1 u1 = new U1(reader);
        int value = u1.getValue().intValue();
        this.desc.append(type.values()[value].name());
        if (value == 7) {
            U2 u2 = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.desc.append(" ").append(u2.getDescription());
        }
        if (value == 8) {
            U2 u2 = new U2(reader);
            this.desc.append(" offset ").append(u2.getDescription());
        }
        super.setDescription(this.desc.toString());
    }
}
