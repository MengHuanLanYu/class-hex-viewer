package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentType;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;
import top.liu15.structure.AccessFlags;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/22 17:14
 */
@Getter
public final class InnerClasses extends AttributeInfo {

    private U2 numberOfClasses;

    private List<InnerClassesInfo> innerClassesInfos;

    public InnerClasses(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.numberOfClasses = new U2(reader);
        int len = this.numberOfClasses.getValue().intValue();
        if (len > 0) {
            this.innerClassesInfos = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.innerClassesInfos.add(new InnerClassesInfo(reader));
            }
        }
    }

    @Getter
    public static class InnerClassesInfo {
        /**
         * 内部类的符号引用
         */
        private U2 innerClassInfoIndex;

        /**
         * 宿主类的符号引用
         */
        private U2 outerClassInfoIndex;

        /**
         * 内部类的名称，如果是匿名内部类，这项值为0
         */
        private U2 innerNameIndex;

        /**
         * 内部类访问标志
         */
        private AccessFlags innerClassAccessFlags;

        public InnerClassesInfo(ByteReader reader) {
            this.innerClassInfoIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.outerClassInfoIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.innerNameIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.innerClassAccessFlags = new AccessFlags(ComponentType.T_INTERNAL_INTERFACE, reader);
        }
    }
}
