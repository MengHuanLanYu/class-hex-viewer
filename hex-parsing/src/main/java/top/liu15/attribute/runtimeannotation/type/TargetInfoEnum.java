package top.liu15.attribute.runtimeannotation.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U1;
import top.liu15.datatype.U2;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/25 13:28
 * @descriptor 取出 type_annotation 中的联合 target_info对应的值
 * @see TypeAnnotation
 * @see top.liu15.attribute.RuntimeTypeAnnotations
 */
@Getter
@AllArgsConstructor
public enum TargetInfoEnum {

    // 0x00	type parameter declaration of generic class or interface	type_parameter_target
    // 0x01	type parameter declaration of generic method or constructor	type_parameter_target
    TYPE_PARAMETER_TARGET(0x00, 0x01, U1::new),
    // 0x10	type in extends or implements clause of class declaration (including the direct superclass or direct superinterface of an anonymous class declaration), or in extends clause of interface declaration	supertype_target
    SUPERTYPE_TARGET(0x10, 0x10, U2::new),
    // 0x11	type in bound of type parameter declaration of generic class or interface	type_parameter_bound_target
    // 0x12	type in bound of type parameter declaration of generic method or constructor	type_parameter_bound_target
    TYPE_PARAMETER_BOUND_TARGET(0x11, 0x12, SuperType::new),
    // 0x13	type in field declaration	empty_target
    // 0x14	return type of method, or type of newly constructed object	empty_target
    // 0x15	receiver type of method or constructor	empty_target
    EMPTY_TARGET(0x13, 0x15, reader -> null),
    // 0x16	type in formal parameter declaration of method, constructor, or lambda expression	formal_parameter_target
    FORMAL_PARAMETER_TARGET(0x16, 0x16, U1::new),
    // 0x17	type in throws clause of method or constructor	throws_target
    THROWS_TARGET(0x17, 0x17, U2::new),
    // 0x40	type in local variable declaration	localvar_target
    // 0x41	type in resource variable declaration	localvar_target
    LOCAL_VAR_TARGET(0x40, 0x41, LocalVar::new),
    // 0x42	type in exception parameter declaration	catch_target
    CATCH_TARGET(0x42, 0x42, U2::new),
    // 0x43	type in instanceof expression	offset_target
    // 0x44	type in new expression	offset_target
    // 0x45	type in method reference expression using ::new	offset_target
    // 0x46	type in method reference expression using ::Identifier	offset_target
    OFFSET_TARGET(0x43, 0x46, U2::new),
    // 0x47	type in cast expression	type_argument_target
    // 0x48	type argument for generic constructor in new expression or explicit constructor invocation statement	type_argument_target
    // 0x49	type argument for generic method in method invocation expression	type_argument_target
    // 0x4A	type argument for generic constructor in method reference expression using ::new	type_argument_target
    // 0x4B	type argument for generic method in method reference expression using ::Identifier	type_argument_target
    TYPE_ARGUMENT_TARGET(0x47, 0x4B, TypeArgument::new);


    /**
     * 标志最小
     */
    private int minTag;


    /**
     * 标志最大
     */
    private int maxTag;

    /**
     * C语言中联合的结构与值
     */
    private Function<ByteReader, ComponentInfo> byteToComponentInfo;

    /**
     * 找出合适的枚举
     *
     * @param tag
     * @return
     */
    public static TargetInfoEnum valueOf(int tag) {
        return Stream.of(values()).filter(item -> item.getMinTag() >= tag && tag <= item.getMaxTag()).findFirst().get();
    }
}
