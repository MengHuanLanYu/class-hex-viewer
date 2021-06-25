package top.liu15.attribute;

import lombok.Getter;
import top.liu15.datatype.*;
import top.liu15.structure.AccessFlags;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/25 15:21
 * https://docs.oracle.com/javase/specs/jvms/se10/html/jvms-4.html#jvms-4.7.25
 */
@Getter
public final class Module extends AttributeInfo {

    private U2 moduleNameIndex;

    private AccessFlags moduleFlags;

    private U2 moduleVersionIndex;

    private U2 requiresCount;

    private List<RequireEntity> requires;

    private U2 exportsCount;

    private List<ExportEntity> exports;

    private U2 opensCount;

    private List<OpenEntity> opens;

    private U2 usesCount;

    /**
     * representing a service interface which the current module may discover via java.util.ServiceLoader.
     * 当前模块可以通过java.util.ServiceLoader发现的服务接口
     */
    private List<U2> usesIndex;

    private U2 providesCount;

    private List<ProvideEntity> provides;

    public Module(String name) {
        super(name);
    }

    @Override
    public void readDescription(ByteReader reader) {
        this.moduleNameIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
        this.moduleFlags = new AccessFlags(ComponentType.T_MODULE, reader);
        this.moduleVersionIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
        // 模块的依赖关系数量
        this.requiresCount = new U2(reader);
        int requiresLen = this.requiresCount.getValue().intValue();
        if (requiresLen > 0) {
            this.requires = new ArrayList<>(requiresLen);
            for (int i = 0; i < requiresLen; i++) {
                this.requires.add(new RequireEntity(reader));
            }
        }
        // 模块导出的包数量
        this.exportsCount = new U2(reader);
        int exportsLen = this.exportsCount.getValue().intValue();
        if (exportsLen > 0) {
            this.exports = new ArrayList<>(exportsLen);
            for (int i = 0; i < exportsLen; i++) {
                this.exports.add(new ExportEntity(reader));
            }
        }
        // 模块打开的包数量
        this.opensCount = new U2(reader);
        int opensLen = this.opensCount.getValue().intValue();
        if (opensLen > 0) {
            this.opens = new ArrayList<>(opensLen);
            for (int i = 0; i < opensLen; i++) {
                this.opens.add(new OpenEntity(reader));
            }
        }
        // 前模块可以通过java.util.ServiceLoader发现的服务接口数量
        this.usesCount = new U2(reader);
        int usesLen = this.usesCount.getValue().intValue();
        if (usesLen > 0) {
            this.usesIndex = new ArrayList<>(usesLen);
            for (int i = 0; i < usesLen; i++) {
                this.usesIndex.add(new U2(reader, UnsignedNumber.INT_TO_CP_INFO));
            }
        }
        // 表示由provides_index指定的服务接口的服务实现数量
        this.providesCount = new U2(reader);
        int providesLen = this.providesCount.getValue().intValue();
        if (providesLen > 0) {
            this.provides = new ArrayList<>(providesLen);
            for (int i = 0; i < providesLen; i++) {
                this.provides.add(new ProvideEntity(reader));
            }
        }
    }


    /**
     * requires table specifies a dependence of the current module
     * require表指定当前模块的依赖关系
     */
    @Getter
    public static class RequireEntity extends ComponentInfo {

        private U2 requiresIndex;
        private AccessFlags requiresFlags;
        private U2 requiresVersionIndex;

        public RequireEntity(ByteReader reader) {
            read(reader);
        }

        @Override
        public void read(ByteReader reader) {
            this.requiresIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.requiresFlags = new AccessFlags(ComponentType.T_MODULE_REQUIRES, reader);
            this.requiresVersionIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
        }
    }


    /**
     * exports table specifies a package exported by the current module,
     * such that public and protected types in the package,
     * and their public and protected members,
     * may be accessed from outside the current module, possibly from a limited set of "friend" modules.
     * <p>
     * Exports表指定了一个由当前模块导出的包，
     * 这样包中的public和protected类型，
     * 以及它们的public和protected成员，
     * 可以从当前模块外部访问，可能是从有限的一组“友元”模块中访问。
     */
    @Getter
    public static class ExportEntity extends ComponentInfo {

        private U2 exportsIndex;
        private AccessFlags exportsFlags;
        private U2 exportsToCount;
        private List<U2> exportsToIndex;

        public ExportEntity(ByteReader reader) {
            read(reader);
        }

        @Override
        public void read(ByteReader reader) {
            this.exportsIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.exportsFlags = new AccessFlags(ComponentType.T_MODULE, reader);
            this.exportsToCount = new U2(reader);
            int len = this.exportsToCount.getValue().intValue();
            if (len > 0) {
                this.exportsToIndex = new ArrayList<>(len);
                for (int i = 0; i < len; i++) {
                    this.exportsToIndex.add(new U2(reader, UnsignedNumber.INT_TO_CP_INFO));
                }
            }
        }
    }

    /**
     * opens table specifies a package opened by the current module,
     * such that all types in the package, and all their members,
     * may be accessed from outside the current module via the reflection libraries of the Java SE Platform,
     * possibly from a limited set of "friend" modules.
     * <p>
     * open表指定由当前模块打开的包，
     * 这样包中的所有类型及其所有成员都可以通过Java SE平台的反射库从当前模块外部访问，
     * 可能来自有限的一组“朋友”模块。
     */
    @Getter
    public static class OpenEntity extends ComponentInfo {

        private U2 opensIndex;
        private AccessFlags opensFlags;
        private U2 opensToCount;
        private List<U2> opensToIndex;

        public OpenEntity(ByteReader reader) {
            read(reader);
        }

        @Override
        public void read(ByteReader reader) {
            this.opensIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.opensFlags = new AccessFlags(ComponentType.T_MODULE, reader);
            this.opensToCount = new U2(reader);
            int len = this.opensToCount.getValue().intValue();
            if (len > 0) {
                this.opensToIndex = new ArrayList<>(len);
                for (int i = 0; i < len; i++) {
                    this.opensToIndex.add(new U2(reader, UnsignedNumber.INT_TO_CP_INFO));
                }
            }
        }
    }


    /**
     * representing a service implementation for the service interface specified by provides_index.
     * <p>
     * 表示由provides_index指定的服务接口的服务实现。
     */
    @Getter
    public static class ProvideEntity extends ComponentInfo {

        private U2 providesIndex;
        private U2 providesWithCount;
        private List<U2> providesWithIndex;

        public ProvideEntity(ByteReader reader) {
            read(reader);
        }

        @Override
        public void read(ByteReader reader) {
            this.providesIndex = new U2(reader, UnsignedNumber.INT_TO_CP_INFO);
            this.providesWithCount = new U2(reader);
            int len = this.providesWithCount.getValue().intValue();
            if (len > 0) {
                this.providesWithIndex = new ArrayList<>(len);
                for (int i = 0; i < len; i++) {
                    this.providesWithIndex.add(new U2(reader, UnsignedNumber.INT_TO_CP_INFO));
                }
            }
        }
    }
}
