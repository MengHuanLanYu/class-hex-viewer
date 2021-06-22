package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;

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

    public StackMapTable(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.numberOfEntries = new U2(reader);
        int len = super.attributeLength.getValue().intValue() - 2;
        for (int i = 0; i < len; i++) {
            System.out.println(reader.read1());
        }
    }
}
