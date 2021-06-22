package top.liu15.constant;

import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U4;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/3 23:03
 */
public final class IntegerInfo extends ConstantInfo {

    private U4 bytes;

    @Override
    public void readDescription(ByteReader reader) {
        // 读取高位在前的int值
        this.bytes = new U4(reader);
        // 填充自己
        super.setDescription(this.bytes.getDescription());
    }
}
