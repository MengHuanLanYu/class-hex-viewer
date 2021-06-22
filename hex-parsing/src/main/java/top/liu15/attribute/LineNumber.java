package top.liu15.attribute;

import lombok.Getter;
import lombok.Setter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.U2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/8 17:44
 */
@Getter
public final class LineNumber extends AttributeInfo {


    private U2 lineNumberTableLength;

    private List<LineNumberEntity> lineNumbers;

    public LineNumber(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.lineNumberTableLength = new U2(reader);
        int len = this.lineNumberTableLength.getValue().intValue();
        if (len > 0) {
            this.lineNumbers = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.lineNumbers.add(new LineNumberEntity(reader));
            }
        }
    }


    @Getter
    @Setter
    public static class LineNumberEntity {

        /**
         * 字节码行号
         */
        private U2 startPc;

        /**
         * java源代码行号
         */
        private U2 lineNumber;

        public LineNumberEntity(ByteReader reader) {
            this.startPc = new U2(reader);
            this.lineNumber = new U2(reader);
        }
    }
}
