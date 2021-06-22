package top.liu15.constant;

import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U2;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/16 10:47
 */
public class BytesToString extends ComponentInfo {

    private final U2 len;

    public BytesToString(U2 len) {
        this.len = len;
    }

    @Override
    public void read(ByteReader reader) {
        readBefore(reader);
        int value = len.getValue().intValue();
        byte[] bytes = new byte[value];
        for (int i = 0; i < value; i++) {
            bytes[i] = reader.read1();
        }
        super.setDescription(toStr(bytes));
        // 之后
        readAfter(reader);
    }
}
