package top.liu15.constant;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/3 18:10
 */
@Getter
public final class ClassInfo extends ConstantInfo {

    private U2 index;

    @Override
    public void readDescription(ByteReader reader) {
        readIndex(reader);
    }

    /**
     * 读取索引值
     *
     * @param reader
     */
    private void readIndex(ByteReader reader) {
        this.index = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }
}
