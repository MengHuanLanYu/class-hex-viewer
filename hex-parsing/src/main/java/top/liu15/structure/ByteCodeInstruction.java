package top.liu15.structure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.liu15.exception.ParameterException;

import java.nio.ByteBuffer;
import java.util.function.Function;

import static top.liu15.structure.CodeInstructionConversion.TO_POSITION_JUMP_STRING;

/**
 * 字节码指令
 * 深入理解jvm虚拟机 周志明老师的 附录C
 * oracle虚拟机规范文档
 * https://docs.oracle.com/javase/specs/jvms/se8/html/index.html
 * https://docs.oracle.com/javase/specs/jvms/se8/jvms8.pdf
 *
 * @author lhy
 * @version 1.0
 * @date 2021/6/8 13:16
 */
@Getter
@AllArgsConstructor
public enum ByteCodeInstruction {

    nop(0x00, 0, "什么都不做"),

    aconst_null(0x01, 0, "将null推动到栈顶"),

    iconst_m1(0x02, 0, "将int型-1推送至栈顶"),

    iconst_0(0x03, 0, "将int型0推送至栈顶"),
    iconst_1(0x04, 0, "将int型1推送至栈顶"),
    iconst_2(0x05, 0, "将int型2推送至栈顶"),
    iconst_3(0x06, 0, "将int型3推送至栈顶"),
    iconst_4(0x07, 0, "将int型4推送至栈顶"),
    iconst_5(0x08, 0, "将int型5推送至栈顶"),

    lconst_0(0x09, 0, "将long型0推送至栈顶"),
    lconst_1(0x0a, 0, "将long型1推送至栈顶"),

    fconst_0(0x0b, 0, "将float型0推送至栈顶"),
    fconst_1(0x0c, 0, "将float型1推送至栈顶"),
    fconst_2(0x0d, 0, "将float型2推送至栈顶"),

    dconst_0(0x0e, 0, "将double型0推送至栈顶"),
    dconst_1(0x0f, 0, "将double型1推送至栈顶"),

    bipush(0x10, 1, CodeInstructionConversion.TO_BYTE_CONST_STRING, "将单字节的常量值(-128~127)推送至栈顶"),
    sipush(0x11, 2, CodeInstructionConversion.TO_SHORT_CONST_STRING, "将一个短整型常量值(-32768~32767)推送至栈顶"),

    ldc(0x12, 1, CodeInstructionConversion.TO_BYTE_CP_INFO_STRING, "将int、float或String型常量值从常量池中推送至栈顶"),
    ldc_w(0x13, 2, CodeInstructionConversion.TO_SHORT_CP_INFO_STRING, "将int、float或String型常量值从常量池中推送至栈顶(宽索引)"),
    ldc2_w(0x14, 2, CodeInstructionConversion.TO_SHORT_CP_INFO_STRING, "将long或double型常量值从常量池中推送至栈顶(宽索引)"),

    iload(0x15, 1, CodeInstructionConversion.TO_BYTE_CONST_STRING, "将指定的int型本地变量推送至栈顶"),
    lload(0x16, 1, CodeInstructionConversion.TO_BYTE_CONST_STRING, "将指定的long型本地变量推送至栈顶"),
    fload(0x17, 1, CodeInstructionConversion.TO_BYTE_CONST_STRING, "将指定的float型本地变量推送至栈顶"),
    dload(0x18, 1, CodeInstructionConversion.TO_BYTE_CONST_STRING, "将指定的double型本地变量推送至栈顶"),
    aload(0x19, 1, CodeInstructionConversion.TO_BYTE_CONST_STRING, "将指定的索引类型本地变量推送至栈顶"),

    iload_0(0x1a, 0, "将第一个int型本地变量推送至栈顶"),
    iload_1(0x1b, 0, "将第二个int型本地变量推送至栈顶"),
    iload_2(0x1c, 0, "将第三个int型本地变量推送至栈顶"),
    iload_3(0x1d, 0, "将第四个int型本地变量推送至栈顶"),

    lload_0(0x1e, 0, "将第一个long型本地变量推送至栈顶"),
    lload_1(0x1f, 0, "将第二个long型本地变量推送至栈顶"),
    lload_2(0x20, 0, "将第三个long型本地变量推送至栈顶"),
    lload_3(0x21, 0, "将第四个long型本地变量推送至栈顶"),

    fload_0(0x22, 0, "将第一个float型本地变量推送至栈顶"),
    fload_1(0x23, 0, "将第二个float型本地变量推送至栈顶"),
    fload_2(0x24, 0, "将第三个float型本地变量推送至栈顶"),
    fload_3(0x25, 0, "将第四个float型本地变量推送至栈顶"),

    dload_0(0x26, 0, "将第一个double型本地变量推送至栈顶"),
    dload_1(0x27, 0, "将第二个double型本地变量推送至栈顶"),
    dload_2(0x28, 0, "将第三个double型本地变量推送至栈顶"),
    dload_3(0x29, 0, "将第四个double型本地变量推送至栈顶"),

    aload_0(0x2a, 0, "将第一个引用类型本地变量推送至栈顶"),
    aload_1(0x2b, 0, "将第二个引用类型本地变量推送至栈顶"),
    aload_2(0x2c, 0, "将第三个引用类型本地变量推送至栈顶"),
    aload_3(0x2d, 0, "将第四个引用类型本地变量推送至栈顶"),

    iaload(0x2e, 0, "将int型数组指定索引的值推送至栈顶"),
    laload(0x2f, 0, "将long型数组指定索引的值推送至栈顶"),
    faload(0x30, 0, "将float型数组指定索引的值推送至栈顶"),
    daload(0x31, 0, "将double型数组指定索引的值推送至栈顶"),
    aaload(0x32, 0, "将引用型数组指定索引的值推送至栈顶"),
    baload(0x33, 0, "将boolean或byte型数组指定索引的值推送至栈顶"),
    caload(0x34, 0, "将char型数组指定索引的值推送至栈顶"),
    saload(0x35, 0, "将short型数组指定索引的值推送至栈顶"),

    istore(0x36, 1, CodeInstructionConversion.TO_BYTE_CONST_STRING, "将栈顶int型数值存入指定本地变量"),
    lstore(0x37, 1, CodeInstructionConversion.TO_BYTE_CONST_STRING, "将栈顶long型数值存入指定本地变量"),
    fstore(0x38, 1, CodeInstructionConversion.TO_BYTE_CONST_STRING, "将栈顶float型数值存入指定本地变量"),
    dstore(0x39, 1, CodeInstructionConversion.TO_BYTE_CONST_STRING, "将栈顶double型数值存入指定本地变量"),
    astore(0x3a, 1, CodeInstructionConversion.TO_BYTE_CONST_STRING, "将栈顶引用型数值存入指定本地变量"),

    istore_0(0x3b, 0, "将栈顶int型数值存入第一个本地变量"),
    istore_1(0x3c, 0, "将栈顶int型数值存入第二个本地变量"),
    istore_2(0x3d, 0, "将栈顶int型数值存入第三个本地变量"),
    istore_3(0x3e, 0, "将栈顶int型数值存入第四个本地变量"),

    lstore_0(0x3f, 0, "将栈顶long型数值存入第一个本地变量"),
    lstore_1(0x40, 0, "将栈顶long型数值存入第二个本地变量"),
    lstore_2(0x41, 0, "将栈顶long型数值存入第三个本地变量"),
    lstore_3(0x42, 0, "将栈顶long型数值存入第四个本地变量"),

    fstore_0(0x43, 0, "将栈顶float型数值存入第一个本地变量"),
    fstore_1(0x44, 0, "将栈顶float型数值存入第二个本地变量"),
    fstore_2(0x45, 0, "将栈顶float型数值存入第三个本地变量"),
    fstore_3(0x46, 0, "将栈顶float型数值存入第四个本地变量"),

    dstore_0(0x47, 0, "将栈顶double型数值存入第一个本地变量"),
    dstore_1(0x48, 0, "将栈顶double型数值存入第二个本地变量"),
    dstore_2(0x49, 0, "将栈顶double型数值存入第三个本地变量"),
    dstore_3(0x4a, 0, "将栈顶double型数值存入第四个本地变量"),

    astore_0(0x4b, 0, "将栈顶引用型数值存入第一个本地变量"),
    astore_1(0x4c, 0, "将栈顶引用型数值存入第二个本地变量"),
    astore_2(0x4d, 0, "将栈顶引用型数值存入第三个本地变量"),
    astore_3(0x4e, 0, "将栈顶引用型数值存入第四个本地变量"),

    iastore(0x4f, 0, "将栈顶int型数值存入指定数组的指定索引位置"),
    lastore(0x50, 0, "将栈顶long型数值存入指定数组的指定索引位置"),
    fastore(0x51, 0, "将栈顶float型数值存入指定数组的指定索引位置"),
    dastore(0x52, 0, "将栈顶double型数值存入指定数组的指定索引位置"),
    aastore(0x53, 0, "将栈顶引用型数值存入指定数组的指定索引位置"),
    bastore(0x54, 0, "将栈顶boolean或byte型数值存入指定数组的指定索引位置"),
    castore(0x55, 0, "将栈顶char型数值存入指定数组的指定索引位置"),
    sastore(0x56, 0, "将栈顶short型数值存入指定数组的指定索引位置"),

    pop(0x57, 0, "将栈顶数值弹出(数值不能是long或double类型的)"),
    pop2(0x58, 0, "将栈顶的一个(对于long或double类型)或两个数值(对于非long或double类型的)弹出"),

    dup(0x59, 0, "复制栈顶数值并将复制的值压入栈顶"),
    dup_x1(0x5a, 0, "复制栈顶的数值并将两个赋值的值压入栈顶"),
    dup_x2(0x5b, 0, "复制栈顶的数值并将三个(或两个)赋值的值压入栈顶"),
    dup2(0x5c, 0, "复制栈顶一个(对于long或double类型)或两个(对于非long或double类型的)数值并将复制的值压入栈顶"),
    dup2_x1(0x5d, 0, "dup_x1指定的双倍版本"),
    dup2_x2(0x5e, 0, "dup_x2指定的双倍版本"),

    swap(0x5f, 0, "将栈最顶端的两个数值互换(数值不能是long或double类型)"),

    iadd(0x60, 0, "将栈顶两个int型数值相加并将结果压入栈顶"),
    ladd(0x61, 0, "将栈顶两个long型数值相加并将结果压入栈顶"),
    fadd(0x62, 0, "将栈顶两个float型数值相加并将结果压入栈顶"),
    dadd(0x63, 0, "将栈顶两个double型数值相加并将结果压入栈顶"),

    isub(0x64, 0, "将栈顶两个int型数值相减并将结果压入栈顶"),
    lsub(0x65, 0, "将栈顶两个long型数值相减并将结果压入栈顶"),
    fsub(0x66, 0, "将栈顶两个float型数值相减并将结果压入栈顶"),
    dsub(0x67, 0, "将栈顶两个double型数值相减并将结果压入栈顶"),

    imul(0x68, 0, "将栈顶两个int型数值相乘并将结果压入栈顶"),
    lmul(0x69, 0, "将栈顶两个long型数值相乘并将结果压入栈顶"),
    fmul(0x6a, 0, "将栈顶两个float型数值相乘并将结果压入栈顶"),
    dmul(0x6b, 0, "将栈顶两个double型数值相乘并将结果压入栈顶"),

    idiv(0x6c, 0, "将栈顶两个int型数值相除并将结果压入栈顶"),
    ldiv(0x6d, 0, "将栈顶两个long型数值相除并将结果压入栈顶"),
    fdiv(0x6e, 0, "将栈顶两个float型数值相除并将结果压入栈顶"),
    ddiv(0x6f, 0, "将栈顶两个double型数值相除并将结果压入栈顶"),

    irem(0x70, 0, "将栈顶两个int型数值进行取模运算并将结果压入栈顶"),
    lrem(0x71, 0, "将栈顶两个long型数值进行取模运算并将结果压入栈顶"),
    frem(0x72, 0, "将栈顶两个float型数值进行取模运算并将结果压入栈顶"),
    drem(0x73, 0, "将栈顶两个double型数值进行取模运算并将结果压入栈顶"),

    ineg(0x74, 0, "将栈顶两个int型数值取负运算并将结果压入栈顶"),
    lneg(0x75, 0, "将栈顶两个long型数值取负运算并将结果压入栈顶"),
    fneg(0x76, 0, "将栈顶两个float型数值取负运算并将结果压入栈顶"),
    dneg(0x77, 0, "将栈顶两个double型数值取负运算并将结果压入栈顶"),

    ishl(0x78, 0, "将int型数值左移指定位数并将结果压入栈顶"),
    lshl(0x79, 0, "将long型数值左移指定位数并将结果压入栈顶"),

    ishr(0x7a, 0, "将int型数值右移(带符号)指定位数并将结果压入栈顶"),
    lshr(0x7b, 0, "将long型数值右移(带符号)指定位数并将结果压入栈顶"),

    iushr(0x7c, 0, "将int型数值右移(无符号)指定位数并将结果压入栈顶"),
    lushr(0x7d, 0, "将long型数值右移(无符号)指定位数并将结果压入栈顶"),

    iand(0x7e, 0, "将栈顶两个int数值进行'按位与'预算并将结果压入栈顶"),
    land(0x7f, 0, "将栈顶两个long数值进行'按位与'预算并将结果压入栈顶"),

    ior(0x80, 0, "将栈顶两个int数值进行'按位或'预算并将结果压入栈顶"),
    lor(0x81, 0, "将栈顶两个long数值进行'按位或'预算并将结果压入栈顶"),

    ixor(0x82, 0, "将栈顶两个int数值进行'按位异或'预算并将结果压入栈顶"),
    lxor(0x83, 0, "将栈顶两个long数值进行'按位异或'预算并将结果压入栈顶"),

    iinc(0x84, 2, CodeInstructionConversion.TO_INCREMENT_STRING, "将指定int型变量增加指定值(如i++、i--、i+=2等)"),

    i2l(0x85, 0, "将栈顶int数值强制转换成long型数值并将结果压入栈顶"),
    i2f(0x86, 0, "将栈顶int数值强制转换成float型数值并将结果压入栈顶"),
    i2d(0x87, 0, "将栈顶int数值强制转换成double型数值并将结果压入栈顶"),

    l2i(0x88, 0, "将栈顶long数值强制转换成int型数值并将结果压入栈顶"),
    l2f(0x89, 0, "将栈顶long数值强制转换成float型数值并将结果压入栈顶"),
    l2d(0x8a, 0, "将栈顶long数值强制转换成double型数值并将结果压入栈顶"),

    f2i(0x8b, 0, "将栈顶float数值强制转换成int型数值并将结果压入栈顶"),
    f2l(0x8c, 0, "将栈顶float数值强制转换成long型数值并将结果压入栈顶"),
    f2d(0x8d, 0, "将栈顶float数值强制转换成double型数值并将结果压入栈顶"),

    d2i(0x8e, 0, "将栈顶double数值强制转换成int型数值并将结果压入栈顶"),
    d2l(0x8f, 0, "将栈顶double数值强制转换成long型数值并将结果压入栈顶"),
    d2f(0x90, 0, "将栈顶double数值强制转换成float型数值并将结果压入栈顶"),

    i2b(0x91, 0, "将栈顶int数值强制转换成byte型数值并将结果压入栈顶"),
    i2c(0x92, 0, "将栈顶int数值强制转换成char型数值并将结果压入栈顶"),
    i2s(0x93, 0, "将栈顶int数值强制转换成short型数值并将结果压入栈顶"),

    lcmp(0x94, 0, "比较栈顶两个long型数值的大小,并将结果(1、0或-1)压入栈顶"),
    fcmpl(0x95, 0, "比较栈顶两个float型数值的大小,并将结果(1、0或-1)压入栈顶;当其中一个数值位'NaN'时,将-1压入栈顶"),
    fcmpg(0x96, 0, "比较栈顶两个float型数值的大小,并将结果(1、0或-1)压入栈顶;当其中一个数值位'NaN'时,将1压入栈顶"),
    dcmpl(0x97, 0, "比较栈顶两个double型数值的大小,并将结果(1、0或-1)压入栈顶;当其中一个数值位'NaN'时,将-1压入栈顶"),
    dcmpg(0x98, 0, "比较栈顶两个double型数值的大小,并将结果(1、0或-1)压入栈顶;当其中一个数值位'NaN'时,将1压入栈顶"),

    ifeq(0x99, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "当栈顶int型数值等于0时跳转"),
    ifne(0x9a, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "当栈顶int型数值不等于0时跳转"),
    iflt(0x9b, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "当栈顶int型数值小于0时跳转"),
    ifge(0x9c, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "当栈顶int型数值大于或等于0时跳转"),
    ifgt(0x9d, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "当栈顶int型数值大于0时跳转"),
    ifle(0x9e, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "当栈顶int型数值小于或等于0时跳转"),

    if_icmpeq(0x9f, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "比较栈顶两个int型数值的大小,当结果等于0时跳转"),
    if_icmpne(0xa0, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "比较栈顶两个int型数值的大小,当结果不等于0时跳转"),
    if_icmplt(0xa1, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "比较栈顶两个int型数值的大小,当结果小于0时跳转"),
    if_icmpge(0xa2, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "比较栈顶两个int型数值的大小,当结果大于或等于0时跳转"),
    if_icmpgt(0xa3, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "比较栈顶两个int型数值的大小,当结果大于0时跳转"),
    if_icmple(0xa4, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "比较栈顶两个int型数值的大小,当结果小于或等于0时跳转"),

    if_acmpeq(0xa5, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "比较栈顶两个引用型数值,当结果相等时跳转"),
    if_acmpne(0xa6, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "比较栈顶两个引用型数值,当结果不相等时跳转"),

    _goto(0xa7, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "无条件跳转"),
    jsr(0xa8, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "跳转至指定的16位offset位置,并将jsr的下一条指定地址压入栈顶"),

    ret(0xa9, 1, CodeInstructionConversion.TO_BYTE_CONST_STRING, "返回至本地变量指定的index的指定位置(一般与jsr或jsr_w联合使用)"),

    tableswitch(0xaa, 0, "用于switch条件跳转,case值连续(可变长度指令)"),
    lookupswitch(0xab, 0, "用于switch条件跳转,case值不连续(可变长度指令)"),

    ireturn(0xac, 0, "从当前方法返回int"),
    lreturn(0xad, 0, "从当前方法返回long"),
    freturn(0xae, 0, "从当前方法返回float"),
    dreturn(0xaf, 0, "从当前方法返回double"),
    areturn(0xb0, 0, "从当前方法返回对象引用"),
    _return(0xb1, 0, "从当前方法返回void"),

    getstatic(0xb2, 2, CodeInstructionConversion.TO_SHORT_CP_INFO_STRING, "获取指定类的静态域,并将其值压入栈顶"),
    putstatic(0xb3, 2, CodeInstructionConversion.TO_SHORT_CP_INFO_STRING, "为指定类的静态域赋值"),

    getfield(0xb4, 2, CodeInstructionConversion.TO_SHORT_CP_INFO_STRING, "获取指定类的实例域,并将其值压入栈顶"),
    putfield(0xb5, 2, CodeInstructionConversion.TO_SHORT_CP_INFO_STRING, "为指定类的实例域赋值"),

    invokevirtual(0xb6, 2, CodeInstructionConversion.TO_SHORT_CP_INFO_STRING, "调用实例方法"),
    invokespecial(0xb7, 2, CodeInstructionConversion.TO_SHORT_CP_INFO_STRING, "调用超类构造方法,实例初始化方法，私有方法"),
    invokestatic(0xb8, 2, CodeInstructionConversion.TO_SHORT_CP_INFO_STRING, "调用静态方法"),

    invokeinterface(0xb9, 4, CodeInstructionConversion.TO_INVOKE_STRING, "调用接口方法"),
    invokedynamic(0xba, 4, CodeInstructionConversion.TO_INVOKE_STRING, "调用动态方法"),

    _new(0xbb, 2, CodeInstructionConversion.TO_SHORT_CP_INFO_STRING, "创建一个对象,并将其引用压入栈顶"),
    newarray(0xbc, 1, CodeInstructionConversion.TO_ARRAY_TYPE_STRING, "创建一个指定的原始类型(如int、float、char等)的素组、并将其引用值压入栈顶"),
    anewarray(0xbd, 2, CodeInstructionConversion.TO_SHORT_CP_INFO_STRING, "创建一个引用类型(如类、接口、数组等)的素组、并将其引用值压入栈顶"),

    arraylength(0xbe, 0, "获得数组的长度值并压入栈顶"),

    athrow(0xbf, 0, "将栈顶的异常抛出"),

    checkcast(0xc0, 2, CodeInstructionConversion.TO_SHORT_CP_INFO_STRING, "检验类型转换,检验未通过将抛出ClassCastException"),

    _instanceof(0xc1, 2, CodeInstructionConversion.TO_SHORT_CP_INFO_STRING, "检验对象是否时指定类的实例,如果是将1压入栈顶,否则将0压入栈顶"),

    monitorenter(0xc2, 0, "获得对象的锁,用于同步方法或同步块"),
    monitorexit(0xc3, 0, "释放对象的锁,用于同步方法或同步块"),

    wide(0xc4, 0, "扩展本地变量的宽度"),

    multianewarray(0xc5, 3, CodeInstructionConversion.TO_MULTIDIMENSIONAL_STRING, "创建指定类型的指定维度的多维度数组(指定该命令时,操作栈中必须包含各维度的长度值),并将其引用值压入栈顶"),

    ifnull(0xc6, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "为null时跳转"),
    ifnonnull(0xc7, 2, CodeInstructionConversion.TO_POSITION_JUMP_STRING, "不为null时跳转"),

    goto_w(0xc8, 4, CodeInstructionConversion.TO_GOTO_WIDE_STRING, "无条件跳转(宽索引)"),

    jsr_w(0xc9, 4, CodeInstructionConversion.TO_GOTO_WIDE_STRING, "跳转至指定的32位offset位置,并将jsr_w的下一条指定地址压入栈顶"),


    /**
     * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html
     * In addition to the opcodes of the instructions specified later in this chapter, which are used in class files (§4 (The class File Format)), three opcodes are reserved for internal use by a Java Virtual Machine implementation. If the instruction set of the Java Virtual Machine is extended in the future, these reserved opcodes are guaranteed not to be used.
     * Two of the reserved opcodes, numbers 254 (0xfe) and 255 (0xff), have the mnemonics impdep1 and impdep2, respectively. These instructions are intended to provide "back doors" or traps to implementation-specific functionality implemented in software and hardware, respectively. The third reserved opcode, number 202 (0xca), has the mnemonic breakpoint and is intended to be used by debuggers to implement breakpoints.
     */
    impdep1(0xfe, 0, "软件中实现特定功能的后门或者陷阱"),
    impdep2(0xff, 0, "硬件中实现特定功能的后门或者陷阱"),
    breakpoint(0xca, 0, "实现断点");


    private int code;

    private int paramsLength;

    private Function<ByteBuffer, String> format;

    private String desc;


    ByteCodeInstruction(int code, int paramsLength, String desc) {
        this.code = code;
        this.paramsLength = paramsLength;
        this.desc = desc;
    }

    public static ByteCodeInstruction getValue(int code) {
        if (code < 0 || code > values().length) {
            throw new ParameterException("字节码指令错误");
        }
        return values()[code];
    }

}
