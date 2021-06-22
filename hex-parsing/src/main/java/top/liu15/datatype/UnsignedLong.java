package top.liu15.datatype;

import lombok.Getter;

import java.util.function.Function;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/9 22:10
 * @description 无符号整数类型
 */
public class UnsignedLong extends ComponentInfo implements UnsignedNumber {

    private Function<ByteReader, Long> readerLongFunction;
    private Function<Long, String> longStringFunction;

    @Getter
    private Long value;

    public UnsignedLong(Function<ByteReader, Long> readerLongFunction, Function<Long, String> longStringFunction) {
        this.readerLongFunction = readerLongFunction;
        this.longStringFunction = longStringFunction;
    }

    @Override
    public void read(ByteReader reader) {
        readBefore(reader);
        this.value = readerLongFunction.apply(reader);
        super.setDescription(longStringFunction.apply(this.value));
        readAfter(reader);
    }
}
