package top.liu15.constant;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/4 9:40
 */
@Getter
public class ModuleInfo extends ConstantInfo {

    private U2 nameIndex;

    @Override
    public void readDescription(ByteReader reader) {
        readNameIndex(reader);
    }

    /**
     * 值必须是常量池有效索引,类型为CONSTANT_Utf8_info,表示模块名字 / 包名
     *
     * @param reader
     */
    private void readNameIndex(ByteReader reader) {
        this.nameIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }
}
