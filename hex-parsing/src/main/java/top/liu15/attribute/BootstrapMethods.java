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
 * @date 2021/6/22 17:32
 */
@Getter
public final class BootstrapMethods extends AttributeInfo {

    private U2 numBootstrapMethods;

    private List<BootstrapMethodInfo> bootstrapMethods;

    public BootstrapMethods(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.numBootstrapMethods = new U2(reader);
        int len = this.numBootstrapMethods.getValue().intValue();
        if (len > 0) {
            this.bootstrapMethods = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.bootstrapMethods.add(new BootstrapMethodInfo(reader));
            }
        }
    }

    @Getter
    public static class BootstrapMethodInfo {

        private U2 bootstrapMethodRef;

        private U2 numBootstrapArguments;

        private List<U2> bootstrapArguments;

        public BootstrapMethodInfo(ByteReader reader) {
            this.bootstrapMethodRef = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.numBootstrapArguments = new U2(reader);
            int len = this.numBootstrapArguments.getValue().intValue();
            if (len > 0) {
                this.bootstrapArguments = new ArrayList<>(len);
                for (int i = 0; i < len; i++) {
                    this.bootstrapArguments.add(new U2(reader, UnsignedNumber.INT_TO_CP_INFO));
                }
            }
        }
    }
}
