package top.liu15.attribute.stackmap;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U1;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/23 15:08
 */
@Getter
public class StackMapFrame extends ComponentInfo {

    protected int previous;

    protected U1 sameFrame;

    /**
     * 偏移长度
     */
    protected int offsetLength;

    public StackMapFrame(int previous, U1 value) {
        this.sameFrame = value;
        this.previous = previous;
    }

    @Override
    public void read(ByteReader reader) {
        readBefore(reader);

        readDescription(reader);

        readAfter(reader);
    }
}
