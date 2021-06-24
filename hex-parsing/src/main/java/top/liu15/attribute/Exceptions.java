package top.liu15.attribute;

import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/24 9:42
 * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7.5
 */
public final class Exceptions extends AttributeInfo {

    private U2 numberOfExceptions;


    private List<U2> exceptionIndexTable;


    public Exceptions(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.numberOfExceptions = new U2(reader);
        int len = this.numberOfExceptions.getValue().intValue();
        if (len > 0) {
            this.exceptionIndexTable = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.exceptionIndexTable.add(new U2(reader, UnsignedNumber.INT_TO_CP_INFO));
            }
        }
    }
}
