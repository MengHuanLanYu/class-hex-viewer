package top.liu15.attribute.runtimeannotation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.liu15.datatype.ByteReader;
import top.liu15.datatype.ComponentInfo;
import top.liu15.datatype.U2;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/24 15:52
 * @descriptor 取出 element_value 中的联合 value 对应的值
 * @see top.liu15.attribute.runtimeannotation.ElementValue
 * @see top.liu15.attribute.RuntimeAnnotations
 */
@Getter
@AllArgsConstructor
public enum ElementItemEnum {
    // B	byte	const_value_index	CONSTANT_Integer
    // C	char	const_value_index	CONSTANT_Integer
    // D	double	const_value_index	CONSTANT_Double
    // F	float	const_value_index	CONSTANT_Float
    // I	int	    const_value_index	CONSTANT_Integer
    // J	long	const_value_index	CONSTANT_Long
    // S	short	const_value_index	CONSTANT_Integer
    // Z	boolean	const_value_index	CONSTANT_Integer
    // s	String	const_value_index	CONSTANT_Utf8

    _BYTE(66, U2::readToCPInfo),
    _CHAR(67, U2::readToCPInfo),
    _DOUBLE(68, U2::readToCPInfo),
    _FLOAT(70, U2::readToCPInfo),
    _INT(73, U2::readToCPInfo),
    _LONG(74, U2::readToCPInfo),
    _SHORT(83, U2::readToCPInfo),
    _BOOLEAN(90, U2::readToCPInfo),
    _STRING(115, U2::readToCPInfo),
    // c	Class	              class_info_index	Not applicable
    _CLASS(99, U2::readToCPInfo),
    // e	Enum class	          enum_const_value	Not applicable  101
    _ENUM(101, EnumConstValue::new),
    // @	Annotation interface  annotation_value	Not applicable
    _ANNOTATION(64, AnnotationEntity::new),
    // [	Array type	          array_value	    Not applicable  91
    _ARRAY(91, ArrayValue::new);


    /**
     * 标记
     */
    private int tag;

    /**
     * C语言中联合的结构与值
     */
    private Function<ByteReader, ComponentInfo> byteToComponent;


    /**
     * 得到枚举
     *
     * @param tag
     * @return
     */
    public static ElementItemEnum valueOf(int tag) {
        return Stream.of(values()).filter(item -> item.tag == tag).findFirst().get();
    }
}
