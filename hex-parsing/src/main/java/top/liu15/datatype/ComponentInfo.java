package top.liu15.datatype;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.UnsupportedEncodingException;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/9 21:35
 * @description 所有的类都该继承此类, 因为他们都包含这些属性
 */
@Getter
@Setter
@ToString
public abstract class ComponentInfo implements FileReader {

    /**
     * 魔数
     */
    public static final long MAGIC_NUMBER = 0xCAFEBABE;

    /**
     * 偏移位置
     */
    protected int offset;

    /**
     * 长度
     */
    protected int size;

    /**
     * 描述
     */
    protected String description;

    /**
     * 读取之前进行操作
     */
    protected void readBefore(ByteReader reader) {
        // 获取偏移位置
        this.offset = reader.getPosition();
    }

    /**
     * 读取字节
     *
     * @param reader
     */
    @Override
    public abstract void read(ByteReader reader);

    /**
     * 读取之后进行操作
     *
     * @param reader
     */
    protected void readAfter(ByteReader reader) {
        // 记录长度
        this.size = reader.getPosition() - this.offset;
    }

    /**
     * 转换为字符串
     *
     * @param bytes
     * @return
     */
    protected String toStr(byte[] bytes) {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
