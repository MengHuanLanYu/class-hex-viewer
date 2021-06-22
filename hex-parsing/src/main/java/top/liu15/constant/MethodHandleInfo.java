package top.liu15.constant;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U1;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/4 9:13
 */
@Getter
public final class MethodHandleInfo extends ConstantInfo {

    private U1 referenceKind;

    private U2 referenceIndex;

    @Override
    public void readDescription(ByteReader reader) {
        readReferenceKind(reader);
        readReferenceIndex(reader);
    }

    /**
     * 值必须在1-9之间（包括1和9），他决定了方法句柄的类型。
     * 方法句柄类型的值表示方法句柄的字节码行为
     *
     * @param reader
     */
    private void readReferenceKind(ByteReader reader) {
        this.referenceKind = new U1(reader);
    }

    /**
     * 值必须是对常量有效的索引
     *
     * @param reader
     */
    private void readReferenceIndex(ByteReader reader) {
        this.referenceIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }
}
