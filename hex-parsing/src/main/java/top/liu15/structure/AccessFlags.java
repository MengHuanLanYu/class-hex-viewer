package top.liu15.structure;

import top.liu15.datatype.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/4 10:20
 */
public final class AccessFlags extends UnsignedInteger {

    public AccessFlags(ComponentType type, ByteReader reader) {
        super(U2, v -> intToDescription(type, v));
        read(reader);
    }

    private static String intToDescription(ComponentType type, int number) {
        // public   0x0001  0000 0001
        //                 &
        // 49       0x0031  0011 0001
        //                  0000 0001
        //abstract  0x0400  100 0000 0000
        //                 &
        //  49      0x0031      0011 0001
        //                  000 0000 0000
        return Stream.of(AccessFlag.values())
                .filter(item -> item.getType().indexOf(type.name()) != -1)
                .filter(item -> (item.getFlagValue() & number) != 0)
                .map(AccessFlag::getFlagName)
                .collect(Collectors.joining(" "));
    }
}
