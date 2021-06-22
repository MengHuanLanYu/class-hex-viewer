package top.liu15.structure;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.ComponentType;
import top.liu15.datatype.U2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/21 10:32
 */
public final class FieldInfo extends ComponentInfo {

    private final U2 count;

    @Getter
    private List<MemberStructure> fieldList;

    public FieldInfo(ByteReader reader, U2 count) {
        this.count = count;
        read(reader);
    }

    @Override
    public void read(ByteReader reader) {
        int len = count.getValue().intValue();
        if (len > 0) {
            this.fieldList = new LinkedList<>();
            readBefore(reader);
            for (int i = 0; i < len; i++) {
                this.fieldList.add(new MemberStructure(reader, ComponentType.T_FILED));
            }
            readAfter(reader);
        }

    }
}
