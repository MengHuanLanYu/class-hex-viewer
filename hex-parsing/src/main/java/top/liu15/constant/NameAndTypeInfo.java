package top.liu15.constant;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/3 18:12
 */
@Getter
public final class NameAndTypeInfo extends ConstantInfo {

    private U2 name;

    private U2 describe;

    @Override
    public void readDescription(ByteReader reader) {
        // 读取该字段或方法名常量索引
        readName(reader);
        // 读取名字和描述符
        readDescribe(reader);
    }

    /**
     * 读取该字段或方法名常量索引
     *
     * @param reader
     */
    private void readName(ByteReader reader) {
        this.name = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }

    /**
     * 读取名字和描述符
     *
     * @param reader
     */
    private void readDescribe(ByteReader reader) {
        this.describe = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }
}
