package org.joker.everything.ddl.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 枚举类，定义了搜索请求的各种参数代码
 * 用于指定搜索文件时所需的不同类型的信息
 *
 * @auther joker
 * @date 2024/9/26 9:31
 */
@Getter
@AllArgsConstructor
public enum EverythingRequestCode {
    // 搜索参数代码，每个代码代表需要返回的文件信息类型
    EVERYTHING_REQUEST_FILE_NAME(0x00000001),
    EVERYTHING_REQUEST_FILE_PATH(0x00000002),
    EVERYTHING_REQUEST_FULL_PATH_AND_FILE_NAME(0x00000004),
    EVERYTHING_REQUEST_FILE_EXTENSION(0x00000008),
    EVERYTHING_REQUEST_FILE_SIZE(0x00000010),
    EVERYTHING_REQUEST_FILE_DATE_CREATED(0x00000020),
    EVERYTHING_REQUEST_FILE_DATE_MODIFIED(0x00000040),
    EVERYTHING_REQUEST_FILE_DATE_ACCESSED(0x00000080),
    EVERYTHING_REQUEST_FILE_ATTRIBUTES(0x00000100),
    EVERYTHING_REQUEST_FILE_LIST_FILE_NAME(0x00000200),
    EVERYTHING_REQUEST_RUN_COUNT(0x00000400),
    EVERYTHING_REQUEST_DATE_RUN(0x00000800),
    EVERYTHING_REQUEST_FILE_DATE_RECENTLY_CHANGED(0x00001000),
    EVERYTHING_REQUEST_DATE_RECENTLY_CHANGED(0x00002000),
    EVERYTHING_REQUEST_HIGHLIGHTED_PATH(0x00004000),
    EVERYTHING_REQUEST_HIGHLIGHTED_FULL_PATH_AND_FILE_NAME(0x00008000);

    // 定义枚举实例的值
    private final int value;

    // 用于快速查找枚举实例的映射表
    private static final Map<Integer, EverythingRequestCode> requestValueMap;

    // 静态初始化块，初始化映射表
    static {
        requestValueMap = Arrays.stream(EverythingRequestCode.values()).collect(Collectors.toMap(EverythingRequestCode::getValue, e -> e));
    }

    /**
     * 根据给定的标志解析并返回相应的搜索参数代码集合
     *
     * @param flags 搜索参数的标志位，用于指定需要哪些类型的文件信息
     * @return 包含所有匹配给定标志的搜索参数代码的集合
     */
    public static Collection<EverythingRequestCode> parse(int flags) {
        Set<EverythingRequestCode> result = new HashSet<>();
        for (EverythingRequestCode requestCode : EverythingRequestCode.values()) {
            if ((flags & requestCode.getValue()) != 0) {
                result.add(requestCode);
            }
        }
        return result;
    }
}

