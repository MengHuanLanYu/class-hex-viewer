package top.liu15.constant;

import lombok.Getter;
import lombok.ToString;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 常量池信息
 *
 * @author lhy
 * @version 1.0
 * @date 2021/6/3 14:33
 */
@ToString
public final class ConstantPool extends ComponentInfo {

    /**
     * 常量个数
     */
    private final U2 count;

    /**
     * 常量池
     */
    @Getter
    private List<ConstantInfo> constantInfoList;

    public ConstantPool(U2 count, ByteReader reader) {
        this.count = count;
        read(reader);
    }

    @Override
    public void read(ByteReader reader) {
        // 常量个数 - 1
        final int length = this.count.getValue().intValue();
        if (length > 0) {
            this.constantInfoList = new ArrayList<>(length);
            // 记录偏移位置
            readBefore(reader);
            for (int i = 1; i < length; i++) {
                // 创建常量池内的对象
                ConstantInfo constantInfo = createConstantInfo(reader);
                this.constantInfoList.add(constantInfo);
                // 碰到 long 和 double 就不对了 也就是碰到 U8 要 +1
                if (constantInfo instanceof LongInfo || constantInfo instanceof DoubleInfo) {
                    this.constantInfoList.add(new StringInfo("续上一个数字型常量,实质无作用"));
                    i++;
                }
            }
            // 记录偏移长度
            readAfter(reader);
        }
    }

    /**
     * 创建对象
     *
     * @param reader
     * @return
     */
    private ConstantInfo createConstantInfo(ByteReader reader) {
        // 读取指定位置的字节
        byte tag = reader.read1(reader.getPosition());
        // 通过工厂创建相应的常量池对象
        ConstantInfo constantInfo = ConstantFactory.create(tag);
        // 读取常量内容
        constantInfo.read(reader);
        return constantInfo;
    }
}
