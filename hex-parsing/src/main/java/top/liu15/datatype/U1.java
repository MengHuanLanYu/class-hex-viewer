package top.liu15.datatype;

import java.util.function.Function;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/9 22:24
 */
public final class U1 extends UnsignedInteger {

    public U1(ByteReader reader) {
        this(reader, INT_TO_STR);
    }

    public U1(ByteReader reader, Function<Integer, String> integerStringFunction) {
        super(U1, integerStringFunction);
        read(reader);
    }
}
