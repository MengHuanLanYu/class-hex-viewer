package top.liu15.attribute;

import lombok.extern.slf4j.Slf4j;
import top.liu15.exception.ParameterException;

/**
 * 属性工厂
 *
 * @author lhy
 * @version 1.0
 * @date 2021/6/8 13:00
 */
@Slf4j
public final class AttributeFactory {

    /**
     * 创建属性对象
     *
     * @param type
     * @return
     */
    public static AttributeInfo create(String type) {
        switch (type) {
            case "Code":
                return new Code(type);
            case "LineNumberTable":
                return new LineNumber(type);
            case "LocalVariableTable":
                return new LocalVariable(type);
            case "LocalVariableTypeTable":
                return new LocalVariable(type);
            case "SourceFile":
                return new SourceFile(type);
            case "StackMapTable":
                return new StackMapTable(type);
            case "MethodParameters":
                return new MethodParameters(type);
            case "ConstantValue":
                return new ConstantValue(type);
            case "RuntimeVisibleAnnotations":
                return new RuntimeVisibleAnnotations(type);
            case "Signature":
                return new Signature(type);
            case "InnerClasses":
                return new InnerClasses(type);
            case "BootstrapMethods":
                return new BootstrapMethods(type);
            case "Exceptions":
                return new Exceptions(type);
            default:
                log.error("the '{}' is not find at AttributeFactory", type);
                throw new ParameterException("属性类型错误");
        }
    }
}
