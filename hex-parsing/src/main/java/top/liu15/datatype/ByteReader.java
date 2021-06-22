package top.liu15.datatype;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import top.liu15.constant.ConstantInfo;
import top.liu15.exception.ParameterException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/3 9:49
 * @Description 深入理解Java虚拟机6.3Class文件结构
 * <p>无符号数属于基本的数据类型，以u1、u2、u4、u8来分别代表1个字节、2个字节、4个字节和8个
 * 字节的无符号数，无符号数可以用来描述数字、索引引用、数量值或者按照UTF-8编码构成字符串值。</p>
 * <p>1.字节：byte：用来计量存储容量的一种计量单位；位：bit</p>
 * <p>2.一个字节等于8位  1byte = 8bit</p>
 * <p>char占用的是2个字节 16位，所以一个char类型的可以存储一个汉字。</p>
 * <p>
 * 整型:
 * byte:  1个字节8位
 * short: 2个字节16位
 * int:   4个字节32位
 * long:  8个字节64位
 * </p>
 * <p>
 * 浮点型:
 * float: 4个字节32位
 * double:8个字节 64位
 * 注：默认的是double类型，如3.14是double类型的，加后缀F（3.14F）则为float类型的。
 * </p>
 * <p>
 * char类型:
 * char:  2个字节
 * </p>
 * <p>
 * boolean类型:
 * boolean: (true or false) 并未指明是多少字节
 * 1字节(理由是虽然编译后1和0只需占用1位空间，但计算机处理数据的最小单位是1个字节，1个字节等于8位，实际存储的空间是：用1个字节的最低位存储，其他7位用0填补，如果值是true的话则存储的二进制为：0000 0001，如果是false的话则存储的二进制为：0000 0000)
 * 1位(理由是boolean类型的值只有true和false两种逻辑值，在编译后会使用1和0来表示，这两个数在内存中只需要1位（bit）即可存储，位是计算机最小的存储单位。)
 * 4字节(《Java虚拟机规范》一书中的描述:"虽然定义了boolean这种数据类型，但是只对它提供了非常有限的支持。在Java虚拟机中没有任何供boolean值专用的字节码指令，Java语言表达式所操作的boolean值，在编译之后都使用Java虚拟机中的int数据类型来代替，而boolean数组将会被编码成Java虚拟机的byte数组，每个元素boolean元素占8位”。这样我们可以得出boolean类型占了单独使用是4个字节，在数组中又是1个字节)
 * </p>
 */
@Slf4j
public class ByteReader {

    private final byte[] bytes;

    private final ByteBuffer buffer;

    @Getter
    @Setter
    private List<ConstantInfo> constantInfoList;

    public ByteReader(InputStream inputStream) {
        if (null == inputStream) {
            log.error("BytesReader(InputStream)  文件为空,初始化失败!");
            throw new ParameterException("文件获取失败");
        }
        // 读取字节
        this.bytes = streamToByteArray(inputStream);
        if (null == this.bytes || this.bytes.length <= 0) {
            log.error("BytesReader(InputStream)  文件字节读取为空,初始化失败!");
            throw new ParameterException("文件获取失败");
        }
        this.buffer = ByteBuffer.wrap(this.bytes)
                // 只读
                .asReadOnlyBuffer()
                // 低地址 ---> 高地址
                // 小端
                // 44 33 22 11
                // 0  1  2  3
                // 大端 即
                // 11 22 33 44
                // 0  1  2  3
                .order(ByteOrder.BIG_ENDIAN);

    }

    /**
     * 得到位置
     *
     * @return
     */
    public int getPosition() {
        return this.buffer.position();
    }

    /**
     * 得到一个字节,不会向后偏移
     *
     * @param index
     * @return
     */
    public byte read1(int index) {
        return this.buffer.get(index);
    }

    /**
     * 得到一个字节
     *
     * @return
     */
    public byte read1() {
        return this.buffer.get();
    }

    /**
     * 得到一个字节无符号
     *
     * @return
     */
    public int readU1() {
        return Byte.toUnsignedInt(read1());
    }

    /**
     * 获取指定位置的值
     *
     * @param index
     * @return
     */
    public short read2(int index) {
        return this.buffer.getShort(index);
    }

    /**
     * 得到两个字节
     *
     * @return
     */
    public short read2() {
        return this.buffer.getShort();
    }

    /**
     * 得到两个字节无符号
     *
     * @return
     */
    public int readU2() {
        return Short.toUnsignedInt(read2());
    }

    /**
     * 获取指定位置的四个字节
     *
     * @param index
     * @return
     */
    public int read4(int index) {
        return this.buffer.getInt(index);
    }

    /**
     * 得到四个字节
     *
     * @return
     */
    public int read4() {
        return this.buffer.getInt();
    }

    /**
     * 得到四个字节无符号
     *
     * @return
     */
    public long readU4() {
        return Integer.toUnsignedLong(read4());
    }

    /**
     * 得到八个字节
     *
     * @return
     */
    public long read8() {
        return this.buffer.getLong();
    }

    /**
     * 得到八个字节无符号
     *
     * @return
     */
    public String readU8() {
        return Long.toUnsignedString(read8());
    }


    /**
     * 读取
     *
     * @param size
     * @return
     */
    public ByteBuffer read(int size) {
        byte[] bs = new byte[size];
        for (int i = 0; i < size; i++) {
            bs[i] = (byte) readU1();
        }
        return ByteBuffer.wrap(bs);
    }

    /**
     * 从文件流中读取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    private byte[] streamToByteArray(InputStream inputStream) {
        byte[] bytes = new byte[0];
        try {
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }
}
