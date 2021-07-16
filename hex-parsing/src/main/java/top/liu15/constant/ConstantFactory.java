package top.liu15.constant;

import top.liu15.exception.ParameterException;

/**
 * 工厂
 *
 * @author lhy
 * @version 1.0
 * @date 2021/6/3 17:09
 */
public class ConstantFactory {

    public static String getDescriptionName(int tag){
        switch (tag) {
            case 1:
                return "constant_utf8_info";
            case 3:
                // integer_info
                return "constant_integer_info";
            case 4:
                // float_info
                return "constant_float_info";
            case 5:
                // long_info
                return "constant_long_info";
            case 6:
                // double_info
                return "constant_double_info";
            case 7:
                // class_info
                return "constant_class_info";
            case 8:
                // string_info
                return "constant_string_info";
            case 9:
                // fieldref_info
                return "constant_fieldref_info";
            case 10:
                // methodref_info
                return "constant_methodref_info";
            case 11:
                // interface_methodref_info
                return "constant_interface_methodref_info";
            case 12:
                // name_and_type_info
                return "constant_name_and_type_info";
            case 15:
                // method_handle_info
                return "constant_method_handle_info";
            case 16:
                // method_type_info
                return "constant_method_type_info";
            case 17:
                // dynamic_info
                return "constant_dynamic_info";
            case 18:
                // invoke_dynamic_info
                return "constant_invoke_dynamic_info";
            case 19:
                // module_info
                return "constant_module_info";
            case 20:
                // package_info
                return "constant_package_info";
            default:
                throw new ParameterException("tag获取错误");
        }
    }

    /**
     * 创建常量信息
     *
     * @param tag
     * @return
     */
    public static ConstantInfo create(int tag) {
        switch (tag) {
            case 1:
                // utf8_info
                return new Utf8Info();
            case 3:
                // integer_info
                return new IntegerInfo();
            case 4:
                // float_info
                return new FloatInfo();
            case 5:
                // long_info
                return new LongInfo();
            case 6:
                // double_info
                return new DoubleInfo();
            case 7:
                // class_info
                return new ClassInfo();
            case 8:
                // string_info
                return new StringInfo();
            case 9:
                // fieldref_info
                return new FieldRefInfo();
            case 10:
                // methodref_info
                return new MethodRefInfo();
            case 11:
                // interface_methodref_info
                return new InterfaceMethodRefInfo();
            case 12:
                // name_and_type_info
                return new NameAndTypeInfo();
            case 15:
                // method_handle_info
                return new MethodHandleInfo();
            case 16:
                // method_type_info
                return new MethodTypeInfo();
            case 17:
                // dynamic_info
                return new DynamicInfo();
            case 18:
                // invoke_dynamic_info
                return new InvokeDynamicInfo();
            case 19:
                // module_info
                return new ModuleInfo();
            case 20:
                // package_info
                return new PackageInfo();
            default:
                throw new ParameterException("tag获取错误");
        }
    }
}
