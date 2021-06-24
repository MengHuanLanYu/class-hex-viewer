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

    private final int len;

    public BytesToString(int len) {
        this.len = len;
    }

    @Override
    public void read(ByteReader reader) {
        readBefore(reader);
        byte[] bytes = new byte[this.len];
        for (int i = 0; i < this.len; i++) {
            bytes[i] = reader.read1();
        }
        super.setDescription(toStr(bytes));
        // 之后
        readAfter(reader);
    }
}
