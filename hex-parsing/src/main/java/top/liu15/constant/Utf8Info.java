package top.liu15.constant;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/3 14:33
 */
@Getter
public final class Utf8Info extends ConstantInfo {

    private U2 length;

    private BytesToString bytes;

    @Override
    public void readDescription(ByteReader reader) {
        // 读取长度
        readLength(reader);
        // 读取字符串
        readBytes(reader);
        // 设置描述
        super.setDescription(this.bytes.getDescription());
    }

    /**
     * 读取长度
     *
     * @param reader
     */
    private void readLength(ByteReader reader) {
        this.length = new U2(reader);
    }

    /**
     * 读取字节
     *
     * @param reader
     */
    private void readBytes(ByteReader reader) {
        this.bytes = new BytesToString(this.length.getValue().intValue());
        this.bytes.read(reader);
    }
}
