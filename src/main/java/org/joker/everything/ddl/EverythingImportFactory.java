package org.joker.everything.ddl;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import com.sun.jna.Native;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.File;

/**
 * EverythingImportFactory 类用于动态加载 Everything 搜索工具的 DLL 文件。
 * 它提供了一种获取 EverythingLibrary 实例的方法，该实例可以用于执行 Everything 搜索功能。
 *
 * @auther joker
 * @date 2024/9/26 22:22
 */
public class EverythingImportFactory {
    // 初始化阶段设置 JNA 编码为 UTF-8，确保字符编码的一致性
    static {
        System.setProperty("jna.encoding", "UTF-8");
    }

    // 使用 Logback 记录日志
    private static final Logger logger = LoggerFactory.getLogger(EverythingImportFactory.class);

    // 32 位 DLL 文件名常量
    private static final String EVERYTHING_32_DLL_NAME = "Everything32";

    // 64 位 DLL 文件名常量
    private static final String EVERYTHING_64_DLL_NAME = "Everything64";

    // 使用缓存存储加载的 EverythingLibrary 实例，减少重复加载
    private static final Cache<String, EverythingLibrary> cache = CacheUtil.newWeakCache(60);

    /**
     * 根据给定的路径获取 EverythingLibrary 的实例。
     * 此方法首先检查缓存中是否已存在对应的实例，如果不存在，则尝试从指定路径中加载 32 位或 64 位的 DLL 文件。
     *
     * @param path Everything DLL 文件所在的目录路径。
     * @return EverythingLibrary 的实例。
     * @throws IllegalStateException 如果指定的路径不存在或加载 DLL 文件失败。
     */
    public static EverythingLibrary getInstance(String path) {
        return cache.get(path, () -> {
            // 存储两个不同位数的 DLL 文件路径
            String[] difDlls = new String[2];
            File parent = new File(path);
            // 确保路径有效性
            if (!parent.exists()) {
                throw new IllegalStateException(path + " does not exist");
            }
            String parentPath = parent.getAbsolutePath();
            // 构造 32 位和 64 位 DLL 的完整路径
            difDlls[0] = parentPath + '\\' + EVERYTHING_32_DLL_NAME;
            difDlls[1] = parentPath + '\\' + EVERYTHING_64_DLL_NAME;
            // 尝试加载其中一个 DLL 文件
            for (String dll : difDlls) {
                try {
                    return Native.load(dll, EverythingLibrary.class);
                } catch (Throwable e) {
                    // 记录加载失败的信息
                    logger.debug(dll + " error: " + e.getMessage());
                }
            }
            // 如果两个 DLL 文件都加载失败，则抛出异常
            throw new IllegalStateException("load everything dll failed");
        });
    }
}

