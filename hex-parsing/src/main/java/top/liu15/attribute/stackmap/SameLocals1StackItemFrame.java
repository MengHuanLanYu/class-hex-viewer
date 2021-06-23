package top.liu15.attribute.stackmap;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U1;
import top.liu15.datatype.U2;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/23 16:08
 */
@Getter
public final class SameLocals1StackItemFrame extends StackMapFrame {

    private VariableInfo stack;

    public SameLocals1StackItemFrame(int previous, U1 value) {
        super(previous, value);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.stack = new VariableInfo(reader, "Stack verifications:");
        // The frame type same_locals_1_stack_item_frame is represented by tags in the range [64, 127]. This frame type indicates that the frame has exactly the same local variables as the previous frame and that the operand stack has one entry. The offset_delta value for the frame is given by the formula frame_type - 64. The verification type of the one stack entry appears after the frame type.
        super.offsetLength = super.sameFrame.getValue().intValue() - 64;
        super.setDescription(String.format("SAME_LOCALS_1_STACK_ITEM(%d),Offset:%d(+%d)", super.sameFrame.getValue().intValue(), super.previous + super.offsetLength, super.offsetLength));
    }
}
