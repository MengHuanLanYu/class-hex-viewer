package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/25 10:18
 * https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.18
 * https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.19
 */
@Getter
public final class RuntimeParameterAnnotations extends AttributeInfo {

    private U1 numParameters;

    private List<RuntimeAnnotations> parameterAnnotations;

    public RuntimeParameterAnnotations(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.numParameters = new U1(reader);
        int len = this.numParameters.getValue().intValue();
        if (len > 0) {
            this.parameterAnnotations = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.parameterAnnotations.add(new RuntimeAnnotations(String.format("[%d]%s", i, super.getDescription())));
            }
        }
    }
}
