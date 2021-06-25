package top.liu15.attribute.runtimeannotation.type;

import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/25 14:48
 * @see TypeAnnotation
 * &nbsp;type_path {
 * &nbsp;    u1 path_length;
 * &nbsp;    {   u1 type_path_kind;
 * &nbsp;        u1 type_argument_index;
 * &nbsp;    } path[path_length];
 * &nbsp;}
 */
@Getter
public final class TypePath extends ComponentInfo {

    private U1 pathLength;

    private List<Path> paths;

    public TypePath(ByteReader reader) {
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
        this.pathLength = new U1(reader);
        int len = this.pathLength.getValue().intValue();
        if (len > 0) {
            this.paths = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                this.paths.add(new Path(reader));
            }
        }
    }

    @Getter
    public static class Path {

        private U1 typePathKind;

        private U1 typeArgumentIndex;

        public Path(ByteReader reader) {
            this.typePathKind = new U1(reader);
            this.typeArgumentIndex = new U1(reader);
        }
    }
}
