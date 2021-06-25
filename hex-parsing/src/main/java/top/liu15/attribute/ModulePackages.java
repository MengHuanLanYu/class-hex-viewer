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
 * @date 2021/6/25 15:56
 * https://docs.oracle.com/javase/specs/jvms/se10/html/jvms-4.html#jvms-4.7.26
 */
@Getter
public final class ModulePackages extends AttributeInfo {

    private U2 packageCount;

    private List<U2> packageIndex;

    public ModulePackages(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.packageCount = new U2(reader);
        int len = this.packageCount.getValue().intValue();
        if (len > 0) {
            this.packageIndex = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.packageIndex.add(new U2(reader, UnsignedNumber.INT_TO_CP_INFO));
            }
        }
    }
}
