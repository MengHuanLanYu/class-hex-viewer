package top.liu15.constant;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/3 18:06
 */
@Getter
public final class StringInfo extends ConstantInfo {

    private U2 index;

    public StringInfo() {
    }

    public StringInfo(String name) {
        super.setDescription(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        // 读取索引
        this.index = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
        // 填充自己
        super.setDescription(this.index.getDescription());
    }
}
