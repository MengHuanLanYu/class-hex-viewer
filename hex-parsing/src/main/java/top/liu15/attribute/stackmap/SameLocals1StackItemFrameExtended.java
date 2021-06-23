package top.liu15.attribute.stackmap;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U1;
import top.liu15.datatype.U2;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/23 17:01
 */
@Getter
public class SameLocals1StackItemFrameExtended extends StackMapFrame {

    private U2 offsetDelta;

    private VariableInfo stack;


    public SameLocals1StackItemFrameExtended(int previous, U1 value) {
        super(previous, value);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.offsetDelta = new U2(reader);
        this.stack = new VariableInfo(reader, "Stack verifications:");
        super.offsetLength = this.offsetDelta.getValue().intValue();
        super.setDescription(String.format("SAME_LOCALS_1_STACK_ITEM_EXTENDED(%d),Offset:%d(+%d)", super.sameFrame.getValue().intValue(), super.previous + super.offsetLength, super.offsetLength));
    }
}
