package top.liu15.attribute.stackmap;

import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U1;
import top.liu15.datatype.U2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/23 17:05
 */
public final class AppendFrame extends StackMapFrame{

    private U2 offsetDelta;

    private List<VariableInfo> locals;

    public AppendFrame(int previous, U1 value) {
        super(previous, value);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.offsetDelta = new U2(reader);

        int numberOfLocalLength = super.sameFrame.getValue().intValue() - 251;
        if (numberOfLocalLength > 0) {
            this.locals = new ArrayList<>(numberOfLocalLength);
            for (int i = 0; i < numberOfLocalLength; i++) {
                this.locals.add(new VariableInfo(reader, "Local verifications:"));
            }
        }

        super.offsetLength = this.offsetDelta.getValue().intValue();
        super.setDescription(String.format("APPEND(%d),Offset:%d(+%d)", super.sameFrame.getValue().intValue(), super.previous +  super.offsetLength,  super.offsetLength));
    }
}
