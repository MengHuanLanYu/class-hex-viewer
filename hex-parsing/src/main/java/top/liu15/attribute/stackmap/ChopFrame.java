package top.liu15.attribute.stackmap;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U1;
import top.liu15.datatype.U2;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/23 15:54
 */
@Getter
public final class ChopFrame extends StackMapFrame {

    private U2 offsetDelta;

    public ChopFrame(int previous, U1 value) {
        super(previous, value);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.offsetDelta = new U2(reader);
        // 设置偏移长度
        super.offsetLength = this.offsetDelta.getValue().intValue();
        super.setDescription(String.format("CHOP(%d),Offset:%d(+%d)", super.sameFrame.getValue().intValue(), super.previous + super.offsetLength, super.offsetLength));
    }
}
