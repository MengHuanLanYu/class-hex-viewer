package top.liu15.structure;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/4 13:11
 */
public final class InterfacesInfo extends ComponentInfo {

    private final U2 interfacesCount;

    @Getter
    private List<U2> interfaceList;

    public InterfacesInfo(U2 interfacesCount, ByteReader reader) {
        this.interfacesCount = interfacesCount;
        read(reader);
    }

    @Override
    public void read(ByteReader reader) {
        int len = interfacesCount.getValue().intValue();
        if (len > 0) {
            this.interfaceList = new LinkedList<>();
            // 记录偏移位置
            readBefore(reader);
            for (int i = 0; i < len; i++) {
                U2 info = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
                interfaceList.add(info);
            }
            // 记录偏移长度
            readAfter(reader);
        }
    }
}
