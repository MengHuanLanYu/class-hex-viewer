package top.liu15.constant;

import lombok.Getter;
import lombok.ToString;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U1;


/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/3 14:35
 */
@Getter
@ToString
public abstract class ConstantInfo extends ComponentInfo {


    private U1 tag;

    @Override
    public void read(ByteReader reader) {
        // 之前
        readBefore(reader);
        // 读取标记
        readTag(reader);
        // 读取详情
        readDescription(reader);
        // 之后
        readAfter(reader);
    }

    private void readTag(ByteReader reader) {
        this.tag = new U1(reader);
    }
}
