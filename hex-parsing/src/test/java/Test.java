import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import top.liu15.ClassFileInfo;
import top.liu15.attribute.runtimeannotation.ElementItemEnum;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.function.Function;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/9 22:03
 */
public class Test {

    @SneakyThrows
    public static void main(String[] args) throws FileNotFoundException {

        long begin = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream("D:\\test_class_file\\AcceptanceRecordServiceImpl.class");
        ClassFileInfo info = new ClassFileInfo(fileInputStream);
        long end = System.currentTimeMillis();
        System.out.printf("用时 ===> [%f]秒\n", (end - begin) / 1000d);
        ObjectMapper mapper = new ObjectMapper();

//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//// 允许序列化空的POJO类
//// （否则会抛出异常）
//        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//// 强制JSON 空字符串("")转换为null对象值:
//        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        // Include.Include.ALWAYS 默认
        // Include.NON_DEFAULT 属性为默认值不序列化
        // Include.NON_EMPTY 属性为 空（""） 或者为 NULL 都不序列化，则返回的json是没有这个字段的。这样对移动端会更省流量
        // Include.NON_NULL 属性为NULL 不序列化,就是为null的字段不参加序列化
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        String s = mapper.writeValueAsString(info);
        System.out.println(s);
    }
}
