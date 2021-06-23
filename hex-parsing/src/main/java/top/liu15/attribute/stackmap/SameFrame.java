package top.liu15.attribute.stackmap;

import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U1;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/23 15:08
 */
public final class SameFrame extends StackMapFrame {

    public SameFrame(int previous, U1 value) {
        super(previous, value);
    }

    @Override
    public void readDescription(ByteReader reader) {
        int value = super.sameFrame.getValue().intValue();
        super.offsetLength = value;
        super.setDescription(String.format("SAME(%d),Offset:%d(+%d)", value, super.previous + value, value));
    }
}
