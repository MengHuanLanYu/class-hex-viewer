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
 * @date 2021/6/21 10:33
 */
public final class MethodInfo extends ComponentInfo {

    private final U2 count;

    @Getter
    private List<MemberStructure> methodList;

    public MethodInfo(ByteReader reader, U2 count) {
        this.count = count;
        read(reader);
    }

    @Override
    public void read(ByteReader reader) {
        int len = count.getValue().intValue();
        if (len > 0) {
            this.methodList = new LinkedList<>();
            readBefore(reader);
            for (int i = 0; i < len; i++) {
                this.methodList.add(new MemberStructure(reader, ComponentType.T_METHOD));
            }
            readAfter(reader);
        }
    }
}
