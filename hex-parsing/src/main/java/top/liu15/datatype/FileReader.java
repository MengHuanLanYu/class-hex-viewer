package top.liu15.datatype;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/9 21:45
 * @description 文件读取接口
 */
public interface FileReader {


    /**
     * 读取
     *
     * @param reader
     */
    void read(ByteReader reader);


    /**
     * 读取描述
     *
     * @param reader
     */
    default void readDescription(ByteReader reader) {
        // 默认不去读取描述
    }
}
