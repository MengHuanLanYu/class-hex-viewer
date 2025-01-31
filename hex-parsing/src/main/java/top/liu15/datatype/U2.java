package top.liu15.datatype;

import java.util.function.Function;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/9 22:10
 */
public final class U2 extends UnsignedInteger {
    public U2(ByteReader reader) {
        this(reader, INT_TO_STR);
    }

    public U2(ByteReader reader, Function<Integer, String> integerStringFunction) {
        super(U2, integerStringFunction);
        read(reader);
    }


    /**
     * 读取信息
     *
     * @param reader
     * @return
     */
    public static U2 readToCPInfo(ByteReader reader) {
        return new U2(reader, INT_TO_CP_INFO);
    }
}
