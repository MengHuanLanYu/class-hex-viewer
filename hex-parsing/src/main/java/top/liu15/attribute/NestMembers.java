package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/24 10:28
 * https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.29
 */
@Getter
public final class NestMembers extends AttributeInfo {

    private U2 numberOfClasses;

    private List<U2> classes;

    public NestMembers(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.numberOfClasses = new U2(reader);
        int len = this.numberOfClasses.getValue().intValue();
        if (len > 0) {
            this.classes = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.classes.add(new U2(reader, UnsignedNumber.INT_TO_CP_INFO));
            }
        }
    }
}
