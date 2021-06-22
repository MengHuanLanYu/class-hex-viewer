package top.liu15.structure;

import lombok.Getter;
import top.liu15.attribute.AttributeTable;
import top.liu15.datatype.*;

import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/21 10:20
 * 成员结构，指的是 字段和方法
 * 他们都有相同的属性
 */
@Getter
public class MemberStructure extends ComponentInfo {

    /**
     * 访问标志变量
     */
    private AccessFlags accessFlags;

    /**
     * 字段简单名称
     */
    private U2 nameIndex;

    /**
     * 字段和方法描述符
     */
    private U2 descriptorIndex;

    /**
     * 属性
     */
    private AttributeTable attributes;

    public MemberStructure(ByteReader reader, ComponentType type) {
        readBefore(reader);
        this.accessFlags = new AccessFlags(type, reader);
        read(reader);
    }

    @Override
    public void read(ByteReader reader) {
        this.nameIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
        // 设置方法名称
        super.setDescription(reader.getConstantInfoList().get(this.nameIndex.getValue().intValue() - 1).getDescription());
        this.descriptorIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
        // 读取属性
        this.attributes = new AttributeTable(reader);
        readAfter(reader);
    }


}
