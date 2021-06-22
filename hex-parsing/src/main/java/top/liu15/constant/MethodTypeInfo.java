package top.liu15.constant;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/4 9:17
 */
@Getter
public final class MethodTypeInfo extends ConstantInfo {

    private U2 descriptorIndex;

    @Override
    public void readDescription(ByteReader reader) {
        readDescriptorIndex(reader);
    }

    /**
     * 值必须是对常量池的有效索引，常量池在该索引处的项必须是CONSTANT_Utf8_info结构，表示方法的描述符
     *
     * @param reader
     */
    private void readDescriptorIndex(ByteReader reader) {
        this.descriptorIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }
}
