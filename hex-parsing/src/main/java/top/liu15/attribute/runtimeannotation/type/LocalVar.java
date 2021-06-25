package top.liu15.attribute.runtimeannotation.type;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/25 13:52
 * @// TODO: 2021/6/25 这个没试验过,没碰到过这个属性,可能与JVM文档理解有偏差
 * @see TargetInfoEnum
 */
@Getter
public final class LocalVar extends ComponentInfo {

    private U2 tableLength;

    private List<Table> tables;

    public LocalVar(ByteReader reader) {
        read(reader);
    }

    @Override
    public void read(ByteReader reader) {
        readBefore(reader);

        this.readDescription(reader);

        readAfter(reader);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.tableLength = new U2(reader);
        int len = this.tableLength.getValue().intValue();
        if (len > 0) {
            this.tables = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.tables.add(new Table(reader));
            }
        }
    }

    /**
     * The given local variable must be at index in the local variable array of the current frame.
     * If the local variable at index is of type double or long, it occupies both index and index + 1.
     */
    @Getter
    public static class Table {
        private U2 startPc;

        private U2 length;

        private U2 index;

        public Table(ByteReader reader) {
            this.startPc = new U2(reader);
            this.length = new U2(reader);
            this.index = new U2(reader);
        }
    }
}
