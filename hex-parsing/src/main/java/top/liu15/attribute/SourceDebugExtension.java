package top.liu15.attribute;

import lombok.Getter;
import top.liu15.constant.BytesToString;
import top.liu15.datatype.ByteReader;

import java.util.Collections;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/24 10:41
 * https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.11
 */
@Getter
public final class SourceDebugExtension extends AttributeInfo {

    public SourceDebugExtension(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        int len = super.attributeLength.getValue().intValue();
        BytesToString bytesToString = new BytesToString(len);
        bytesToString.read(reader);
        super.setDescription(bytesToString.getDescription());
    }
}
