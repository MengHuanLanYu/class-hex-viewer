package top.liu15.datatype;

import lombok.Getter;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/4 10:44
 */
@Getter
public enum AccessFlag {
    // field
    ACC_PRIVATE(0x0002, "private", String.format("%s,%s,%s", ComponentType.T_FILED, ComponentType.T_METHOD, ComponentType.T_INTERNAL_INTERFACE)),
    ACC_PROTECTED(0x0004, "protected", String.format("%s,%s,%s", ComponentType.T_FILED, ComponentType.T_METHOD, ComponentType.T_INTERNAL_INTERFACE)),
    ACC_STATIC(0x0008, "static", String.format("%s,%s,%s", ComponentType.T_FILED, ComponentType.T_METHOD, ComponentType.T_INTERNAL_INTERFACE)),
    ACC_VOLATILE(0x0040, "volatile", String.format("%s", ComponentType.T_FILED)),
    ACC_TRANSIENT(0x0080, "transient", String.format("%s", ComponentType.T_FILED)),
    // class
    ACC_PUBLIC(0x0001, "public", String.format("%s,%s,%s,%s", ComponentType.T_CLASS, ComponentType.T_FILED, ComponentType.T_METHOD, ComponentType.T_INTERNAL_INTERFACE)),
    ACC_FINAL(0x0010, "final", String.format("%s,%s,%s,%s", ComponentType.T_CLASS, ComponentType.T_FILED, ComponentType.T_METHOD, ComponentType.T_INTERNAL_INTERFACE)),
    ACC_SUPER(0x0020, "super", String.format("%s", ComponentType.T_CLASS)),
    ACC_INTERFACE(0x0200, "interface", String.format("%s", ComponentType.T_CLASS)),
    ACC_ABSTRACT(0x0400, "abstract", String.format("%s,%s,%s", ComponentType.T_CLASS, ComponentType.T_METHOD, ComponentType.T_INTERNAL_INTERFACE)),
    ACC_SYNTHETIC(0x1000, "synthetic", String.format("%s,%s,%s,%s,%s,%s", ComponentType.T_CLASS, ComponentType.T_FILED, ComponentType.T_METHOD, ComponentType.T_INTERNAL_INTERFACE, ComponentType.T_MODULE, ComponentType.T_INTERNAL_INTERFACE)),
    ACC_ANNOTATION(0x2000, "annotation", String.format("%s,%s", ComponentType.T_CLASS, ComponentType.T_INTERNAL_INTERFACE)),
    ACC_ENUM(0x4000, "menu", String.format("%s,%s,%s", ComponentType.T_CLASS, ComponentType.T_FILED, ComponentType.T_INTERNAL_INTERFACE)),
    ACC_MODULE(0x8000, "module", String.format("%s", ComponentType.T_CLASS)),
    // method
    ACC_SYNCHRONIZED(0x0020, "synchronized", String.format("%s", ComponentType.T_METHOD)),
    ACC_BRIDGE(0x0040, "bridge", String.format("%s", ComponentType.T_METHOD)),
    ACC_VARARGS(0x0080, "varargs", String.format("%s", ComponentType.T_METHOD)),
    ACC_NATIVE(0x0100, "native", String.format("%s", ComponentType.T_METHOD)),
    ACC_STRICT(0x0800, "strictfp", String.format("%s", ComponentType.T_METHOD)),

    // internal_class
    ACC_INTERNAL_INTERFACE(0x0020, "interface", String.format("%s", ComponentType.T_INTERNAL_INTERFACE)),

    // module
    ACC_OPEN(0x0020, "open", String.format("%s", ComponentType.T_MODULE)),
    ACC_MANDATE(0x8000, "mandated", String.format("%s,%s", ComponentType.T_MODULE, ComponentType.T_INTERNAL_INTERFACE)),

    // module-requires
    ACC_TRANSITIVE(0x0020, "transitive", String.format("%s", ComponentType.T_MODULE_REQUIRES)),
    ACC_STATIC_PHASE(0x0040, "static_phase", String.format("%s", ComponentType.T_MODULE_REQUIRES));

    private int flagValue;

    private String flagName;

    private String type;

    AccessFlag(int flagValue, String flagName, String type) {
        this.flagValue = flagValue;
        this.flagName = flagName;
        this.type = type;
    }
}
