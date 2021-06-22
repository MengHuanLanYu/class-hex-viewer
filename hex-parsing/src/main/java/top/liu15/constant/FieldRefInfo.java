package top.liu15.constant;


import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;
import top.liu15.datatype.UnsignedNumber;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/3 18:08
 */
@Getter
public class FieldRefInfo extends ConstantInfo {

    private U2 classInfo;

    private U2 nameAndType;

    @Override
    public void readDescription(ByteReader reader) {
        // 读取类名
        readClassInfo(reader);
        // 读取名字
        readNameAndType(reader);
    }

    /**
     * 读取类名索引
     *
     * @param reader
     */
    private void readClassInfo(ByteReader reader) {
        this.classInfo = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }

    /**
     * 读取名字和描述符
     *
     * @param reader
     */
    private void readNameAndType(ByteReader reader) {
        this.nameAndType = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }
}
