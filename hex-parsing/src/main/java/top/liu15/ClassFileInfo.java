package top.liu15;

import lombok.Getter;
import lombok.ToString;
import top.liu15.attribute.AttributeTable;
import top.liu15.constant.ConstantPool;
import top.liu15.datatype.*;
import top.liu15.exception.ByteCodeParsingException;
import top.liu15.structure.AccessFlags;
import top.liu15.structure.FieldInfo;
import top.liu15.structure.InterfacesInfo;
import top.liu15.structure.MethodInfo;

import java.io.InputStream;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/5/27 14:40
 * @Description class文件结构
 * class_info {
 * &nbsp;&nbsp; magic                 u4               魔数,数量1
 * &nbsp;&nbsp; minor_version         u2               小版本号,数量1
 * &nbsp;&nbsp; major_version         u2               大版本号,数量1
 * &nbsp;&nbsp; constant_pool_count   u2               常量个数,数量1
 * &nbsp;&nbsp; constant_pool         cp_info          常量池,数量constant_pool_count - 1
 * &nbsp;&nbsp; access_flags          u2               访问标志,数量1
 * &nbsp;&nbsp; this_class            u2               类索引,数量1
 * &nbsp;&nbsp; super_class           u2               父类索引,数量1
 * &nbsp;&nbsp; interfaces_count      u2               接口计数器,数量1
 * &nbsp;&nbsp; interfaces            u2               接口索引集合,数量interfaces_count
 * &nbsp;&nbsp; fields_count          u2               字段数量,数量1
 * &nbsp;&nbsp; fields                field_info       字段集合,数量fields_count
 * &nbsp;&nbsp; methods_count         u2               方法数量,数量1
 * &nbsp;&nbsp; methods               method_info      方法集合,数量methods_count
 * &nbsp;&nbsp; attributes_count      u2               属性表数量,数量1
 * &nbsp;&nbsp; attributes            attribute_info   属性表集合,attributes_count
 * }
 */
@Getter
@ToString
public final class ClassFileInfo extends ComponentInfo {

    /**
     * 魔数
     */
    private U4 magicNumber;

    /**
     * 小版本号
     */
    private U2 minorVersion;

    /**
     * 大版本号
     */
    private U2 majorVersion;

    /**
     * 常量池个数
     */
    private U2 constantPoolCount;

    /**
     * 常量池
     */
    private ConstantPool constantPool;

    /**
     * 访问标志
     */
    private AccessFlags accessFlags;

    /**
     * 类索引
     */
    private U2 thisClass;

    /**
     * 夫类索引
     */
    private U2 superClass;

    /**
     * 接口计数器
     */
    private U2 interfacesCount;

    /**
     * 接口集合
     */
    private InterfacesInfo interfaces;

    /**
     * 字段数量
     */
    private U2 fieldsCount;

    /**
     * 字段集合
     */
    private FieldInfo fieldInfos;


    /**
     * 方法数量
     */
    private U2 methodCount;

    /**
     * 方法集合
     */
    private MethodInfo methodInfos;

    /**
     * 属性
     */
    private AttributeTable attributes;


    /**
     * 创建class文件实例
     *
     * @param inputStream
     */
    public ClassFileInfo(InputStream inputStream) {
        ByteReader byteReader = new ByteReader(inputStream);
        read(byteReader);
    }

    @Override
    public void read(ByteReader reader) {
        // 读取前
        readBefore(reader);
        // 读取魔数
        readMagicNumber(reader);
        // 读取小版本号
        readMinorVersion(reader);
        // 读取大版本号
        readMajorVersion(reader);
        // 读取常量池内容
        readConstantPool(reader);
        // 读取访问标志
        readAccessFlags(reader);
        // 读取类索引
        readThisClass(reader);
        // 读取夫类索引
        readSuperClass(reader);
        // 读取接口集合
        readInterfaces(reader);
        // 读取字段集合
        readFields(reader);
        // 读取方法集合
        readMethods(reader);
        // 属性集合
        this.attributes = new AttributeTable(reader);
        // 读取后
        readAfter(reader);
    }


    /**
     * 读取魔数
     *
     * @param reader
     */
    private void readMagicNumber(ByteReader reader) {
        U4 u4 = new U4(reader, UnsignedNumber.LONG_TO_HEX);
        if (u4.getValue().intValue() != MAGIC_NUMBER) {
            throw new ByteCodeParsingException();
        }
        this.magicNumber = u4;
    }

    /**
     * 读取小版本号
     *
     * @param reader
     */
    private void readMinorVersion(ByteReader reader) {
        this.minorVersion = new U2(reader);
    }

    /**
     * 读取大版本号
     *
     * @param reader
     */
    private void readMajorVersion(ByteReader reader) {
        this.majorVersion = new U2(reader, v -> {
            switch (v) {
                case 45:
                    return "1.1";
                case 46:
                    return "1.2";
                case 47:
                    return "1.3";
                case 48:
                    return "1.4";
                case 49:
                    return "1.5";
                case 50:
                    return "1.6";
                case 51:
                    return "1.7";
                case 52:
                    return "1.8";
                case 53:
                    return "9";
                case 54:
                    return "10";
                case 55:
                    return "11";
                case 56:
                    return "12";
                case 57:
                    return "13";
                case 58:
                    return "14";
                case 59:
                    return "15";
                case 60:
                    return "16";
                case 61:
                    return "17";
                default:
                    throw new ByteCodeParsingException("attribute 'majorVersion' error,value is " + v);
            }
        });
    }

    /**
     * 读取常量池
     *
     * @param reader
     */
    private void readConstantPool(ByteReader reader) {
        // 读取常量池个数
        this.constantPoolCount = new U2(reader);
        this.constantPool = new ConstantPool(this.constantPoolCount, reader);
        // 把常量池内容放进byteReader中,后面要用
        reader.setConstantInfoList(this.constantPool.getConstantInfoList());
    }

    /**
     * 读取访问标志
     *
     * @param reader
     */
    private void readAccessFlags(ByteReader reader) {
        this.accessFlags = new AccessFlags(ComponentType.T_CLASS, reader);
    }


    /**
     * 读取类索引
     *
     * @param reader
     */
    private void readThisClass(ByteReader reader) {
        this.thisClass = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }

    /**
     * 读取父类索引
     *
     * @param reader
     */
    private void readSuperClass(ByteReader reader) {
        this.superClass = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
    }

    /**
     * 读取接口集合
     *
     * @param reader
     */
    private void readInterfaces(ByteReader reader) {
        // 读取接口数量
        this.interfacesCount = new U2(reader);
        if (this.interfacesCount.getValue().intValue() > 0) {
            this.interfaces = new InterfacesInfo(this.interfacesCount, reader);
        }
    }


    /**
     * 读取字段集合
     *
     * @param reader
     */
    private void readFields(ByteReader reader) {
        // 读取字段数量
        this.fieldsCount = new U2(reader);
        if (this.fieldsCount.getValue().intValue() > 0) {
            this.fieldInfos = new FieldInfo(reader, this.fieldsCount);
        }
    }

    /**
     * 读取方法集合
     *
     * @param reader
     */
    private void readMethods(ByteReader reader) {
        // 读取方法数量
        this.methodCount = new U2(reader);
        if (this.methodCount.getValue().intValue() > 0) {
            this.methodInfos = new MethodInfo(reader, this.methodCount);
        }
    }
}
