package top.liu15.datatype;

import lombok.Getter;

import java.util.function.Function;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/9 22:10
 * @description 无符号整数类型
 */
public class UnsignedInteger extends ComponentInfo implements UnsignedNumber {

    private Function<ByteReader, Integer> readerIntegerFunction;
    private Function<Integer, String> integerStringFunction;

    @Getter
    private Integer value;

    public UnsignedInteger(Function<ByteReader, Integer> readerIntegerFunction, Function<Integer, String> integerStringFunction) {
        this.readerIntegerFunction = readerIntegerFunction;
        this.integerStringFunction = integerStringFunction;
    }

    @Override
    public void read(ByteReader reader) {
        readBefore(reader);
        this.value = readerIntegerFunction.apply(reader);
        super.setDescription(integerStringFunction.apply(this.value));
        readAfter(reader);
    }
}
