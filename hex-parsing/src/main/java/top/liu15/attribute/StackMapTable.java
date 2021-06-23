package top.liu15.attribute;

import lombok.Getter;
import top.liu15.attribute.stackmap.*;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U1;
import top.liu15.datatype.U2;
import top.liu15.exception.ParameterException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/21 16:52
 * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7.4
 * StackMapTable_attribute {
 * &nbsp;u2              attribute_name_index;
 * &nbsp;u4              attribute_length;
 * &nbsp;u2              number_of_entries;
 * &nbsp;stack_map_frame entries[number_of_entries];
 * }
 */
@Getter
public final class StackMapTable extends AttributeInfo {

    private U2 numberOfEntries;

    private List<StackMapFrame> entries;

    public StackMapTable(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.numberOfEntries = new U2(reader);
        int len = this.numberOfEntries.getValue().intValue();
        if (len > 0) {
            this.entries = new ArrayList<>();
            int previous = 0;
            for (int i = 0; i < len; i++) {
                U1 u1 = new U1(reader);
                StackMapFrame stackMapFrame = this.createStackMapFrame(previous, u1);
                stackMapFrame.read(reader);
                this.entries.add(stackMapFrame);
                // 然后偏移量添加
                previous += stackMapFrame.getOffsetLength();
                previous++;
            }
        }
    }


    /**
     * 创建
     *
     * @param previous
     * @param tag
     * @return
     */
    private StackMapFrame createStackMapFrame(int previous, U1 tag) {
        int value = tag.getValue().intValue();
        if (value >= 0 && value <= 63) {
            return new SameFrame(previous, tag);
        }
        if (value >= 64 && value <= 127) {
            return new SameLocals1StackItemFrame(previous, tag);
        }
        // Tags in the range [128-246] are reserved for future use.
        if (value == 247) {
            return new SameLocals1StackItemFrameExtended(previous, tag);
        }
        if (value >= 248 && value <= 250) {
            return new ChopFrame(previous, tag);
        }
        if (value == 251) {
            return new SameFrameExtended(previous, tag);
        }
        if (value >= 252 && value <= 254) {
            return new AppendFrame(previous, tag);
        }
        if (value == 255) {
            return new FullFrame(previous, tag);
        }
        throw new ParameterException("框架类型错误");
    }
}
