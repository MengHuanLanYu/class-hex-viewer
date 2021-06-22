package top.liu15.constant;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/4 9:20
 */
@Getter
public class DynamicInfo extends ConstantInfo {

    private U2 bootstrapMethodAttrIndex;

    private U2 nameAddTypeIndex;

    @Override
    public void readDescription(ByteReader reader) {
        readBootstrapMethodAttrIndex(reader);
        readNameAddTypeIndex(reader);
    }

    /**
     * 值必须是对当前class文件引导方法表的bootstrap_methods[]数组的有效索引
     *
     * @param reader
     */
    private void readBootstrapMethodAttrIndex(ByteReader reader) {
        this.bootstrapMethodAttrIndex = new U2(reader);
    }

    /**
     * 值必须是对常量有效的索引，常量池在该索引处的项必须是CONSTANT_NameAndType_info结构，
     * 表示方法名和方法描述符
     *
     * @param reader
     */
    private void readNameAddTypeIndex(ByteReader reader) {
        this.nameAddTypeIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }
}
