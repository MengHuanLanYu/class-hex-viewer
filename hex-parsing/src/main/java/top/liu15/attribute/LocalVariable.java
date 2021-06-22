package top.liu15.attribute;

import lombok.Getter;
import lombok.Setter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/8 17:57
 */
@Getter
public final class LocalVariable extends AttributeInfo {

    private U2 localVariableTableLength;

    private List<LocalVariableEntity> localVariables;

    public LocalVariable(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.localVariableTableLength = new U2(reader);
        int len = this.localVariableTableLength.getValue().intValue();
        if (len > 0) {
            this.localVariables = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.localVariables.add(new LocalVariableEntity(reader));
            }
        }
    }

    @Getter
    @Setter
    public static class LocalVariableEntity {

        /**
         * 局部变量的生命周期开始的字节码偏移量
         */
        private U2 startPc;

        /**
         * 作用范围覆盖的长度
         */
        private U2 length;

        /**
         * 局部变量的名称
         */
        private U2 nameIndex;

        /**
         * 局部变量描述符
         */
        private U2 descriptorIndex;

        /**
         * 局部变量在栈帧的局部变量表中变量槽的位置
         */
        private U2 index;


        public LocalVariableEntity(ByteReader reader) {
            this.startPc = new U2(reader);
            this.length = new U2(reader);
            this.nameIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.descriptorIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.index = new U2(reader);
        }
    }
}
