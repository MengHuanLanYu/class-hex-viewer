package top.liu15.attribute.stackmap;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U1;
import top.liu15.datatype.U2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/23 15:21
 * full_frame {
 * &nbsp;u1 frame_type = FULL_FRAME; 255
 * &nbsp;u2 offset_delta;
 * &nbsp;u2 number_of_locals;
 * &nbsp;verification_type_info locals[number_of_locals];
 * &nbsp;u2 number_of_stack_items;
 * &nbsp;verification_type_info stack[number_of_stack_items];
 * }
 */
@Getter
public final class FullFrame extends StackMapFrame {

    private U2 offsetDelta;

    private U2 numberOfLocals;

    private List<VariableInfo> locals;

    private U2 numberOfStackItems;

    private List<VariableInfo> stack;

    public FullFrame(int previous, U1 value) {
        super(previous, value);
    }


    @Override
    public void readDescription(ByteReader reader) {
        this.offsetDelta = new U2(reader);
        this.numberOfLocals = new U2(reader);
        int numberOfLocalLength = this.numberOfLocals.getValue().intValue();
        if (numberOfLocalLength > 0) {
            this.locals = new ArrayList<>(numberOfLocalLength);
            for (int i = 0; i < numberOfLocalLength; i++) {
                this.locals.add(new VariableInfo(reader, "Local verifications:"));
            }
        }
        this.numberOfStackItems = new U2(reader);
        int numberOfStackLength = this.numberOfStackItems.getValue().intValue();
        if (numberOfStackLength > 0) {
            this.stack = new ArrayList<>(numberOfStackLength);
            for (int i = 0; i < numberOfStackLength; i++) {
                this.stack.add(new VariableInfo(reader, "Stack verifications:"));
            }
        }
        super.offsetLength = this.offsetDelta.getValue().intValue();
        super.setDescription(String.format("FULL(%d),Offset:%d(+%d)", super.sameFrame.getValue().intValue(), super.previous +  super.offsetLength,  super.offsetLength));
    }
}
