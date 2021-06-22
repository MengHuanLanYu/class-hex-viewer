package top.liu15.attribute;

import lombok.Getter;
import top.liu15.constant.ConstantInfo;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/21 13:50
 */
@Getter
public class AttributeTable extends ComponentInfo {

    /**
     * 属性表数量
     */
    private U2 attributesCount;

    /**
     * 属性表
     */
    private List<AttributeInfo> attributeInfoList;

    public AttributeTable(ByteReader byteReader) {
        read(byteReader);
    }

    @Override
    public void read(ByteReader reader) {
        // 读取属性表长度
        this.attributesCount = new U2(reader);
        int len = this.attributesCount.getValue().intValue();
        if (len > 0) {
            this.attributeInfoList = new ArrayList<>(len);
            readBefore(reader);
            for (int i = 0; i < len; i++) {
                short index = reader.read2(reader.getPosition());
                ConstantInfo constantInfo = reader.getConstantInfoList().get(--index);
                AttributeInfo attributeInfo = AttributeFactory.create(constantInfo.getDescription());
                attributeInfo.read(reader);
                this.attributeInfoList.add(attributeInfo);
            }
            readAfter(reader);
        }
    }
}
