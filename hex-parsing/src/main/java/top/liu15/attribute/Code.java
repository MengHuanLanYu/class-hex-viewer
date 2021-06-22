package top.liu15.attribute;

import lombok.Getter;
import lombok.ToString;
import top.liu15.datatype.*;
import top.liu15.structure.ByteCodeInstruction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/21 14:20
 */
@Getter
public final class Code extends AttributeInfo {

    private U2 maxStack;

    private U2 maxLocals;

    private U4 codeLength;

    private List<String> codes;

    private U2 exceptionTableLength;

    private List<ExceptionTable> exceptionTables;

    private AttributeTable attributes;

    public Code(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        // 读取操作数栈最大深度
        this.maxStack = new U2(reader);
        // 读取本地变量表最大深度
        this.maxLocals = new U2(reader);
        // 读取字节码指令
        readCodes(reader);
        // 异常表
        readExceptionInfos(reader);
        // 属性
        this.attributes = new AttributeTable(reader);
    }

    /**
     * 读取字节码指令
     *
     * @param reader
     */
    private void readCodes(ByteReader reader) {
        this.codeLength = new U4(reader);
        long len = this.codeLength.getValue().longValue();
        if (len > 0) {
            this.codes = new ArrayList<>();
            long current = 0;
            while (current < len) {
                int index = reader.readU1();
                ByteCodeInstruction codeInstruction = ByteCodeInstruction.getValue(index);
                String name = codeInstruction.name().indexOf('_') == 0 ? codeInstruction.name().substring(1) : codeInstruction.name();
                int paramsLength = codeInstruction.getParamsLength();
                String codeStr = name;
                if (paramsLength > 0) {
                    codeStr = String.format("%s%s", name, codeInstruction.getFormat().apply(reader.read(paramsLength)));
                }
                this.codes.add(codeStr);
                for (int i = 0; i < paramsLength; i++) {
                    this.codes.add("\n");
                    current += 1;
                }
                current += 1;
            }
        }
    }

    /**
     * 读取异常表信息
     *
     * @param reader
     */
    private void readExceptionInfos(ByteReader reader) {
        this.exceptionTableLength = new U2(reader);
        int len = this.exceptionTableLength.getValue().intValue();
        if (len > 0) {
            this.exceptionTables = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.exceptionTables.add(new ExceptionTable(reader));
            }
        }
    }


    @Getter
    public static class ExceptionTable {

        private U2 startPc;

        private U2 endPc;

        private U2 handlerPc;

        private U2 catchType;

        public ExceptionTable(ByteReader reader) {
            this.startPc = new U2(reader);
            this.endPc = new U2(reader);
            this.handlerPc = new U2(reader);
            this.catchType = new U2(reader);
        }
    }
}
