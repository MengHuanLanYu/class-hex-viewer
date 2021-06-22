package top.liu15.datatype;

import java.util.function.Function;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/9 22:28
 */
public final class U4 extends UnsignedLong {

    public U4(ByteReader reader) {
        this(reader, LONG_TO_STR);
    }

    public U4(ByteReader reader, Function<Long, String> longStringFunction) {
        super(U4, longStringFunction);
        read(reader);
    }
}
