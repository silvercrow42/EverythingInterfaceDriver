package org.joker.everything.ddl.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joker.everything.http.EverythingSortType;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 该枚举类定义了文件排序的各类代码，用于指示文件按照何种属性进行升序或降序排列
 *
 * @auther joker
 * @date 2024/9/26 9:48
 */
@Getter
@AllArgsConstructor
public enum EverythingSortCode {
    // 以下枚举值定义了各种排序方式，包括按名称、路径、大小、扩展名等属性的升序和降序排列
    EVERYTHING_SORT_NAME_ASCENDING(1),
    EVERYTHING_SORT_NAME_DESCENDING(2),
    EVERYTHING_SORT_PATH_ASCENDING(3),
    EVERYTHING_SORT_PATH_DESCENDING(4),
    EVERYTHING_SORT_SIZE_ASCENDING(5),
    EVERYTHING_SORT_SIZE_DESCENDING(6),
    EVERYTHING_SORT_EXTENSION_ASCENDING(7),
    EVERYTHING_SORT_EXTENSION_DESCENDING(8),
    EVERYTHING_SORT_TYPE_NAME_ASCENDING(9),
    EVERYTHING_SORT_TYPE_NAME_DESCENDING(10),
    EVERYTHING_SORT_DATE_CREATED_ASCENDING(11),
    EVERYTHING_SORT_DATE_CREATED_DESCENDING(12),
    EVERYTHING_SORT_DATE_MODIFIED_ASCENDING(13),
    EVERYTHING_SORT_DATE_MODIFIED_DESCENDING(14),
    EVERYTHING_SORT_ATTRIBUTES_ASCENDING(15),
    EVERYTHING_SORT_ATTRIBUTES_DESCENDING(16),
    EVERYTHING_SORT_FILE_LIST_FILENAME_ASCENDING(17),
    EVERYTHING_SORT_FILE_LIST_FILENAME_DESCENDING(18),
    EVERYTHING_SORT_RUN_COUNT_ASCENDING(19),
    EVERYTHING_SORT_RUN_COUNT_DESCENDING(20),
    EVERYTHING_SORT_DATE_RECENTLY_CHANGED_ASCENDING(21),
    EVERYTHING_SORT_DATE_RECENTLY_CHANGED_DESCENDING(22),
    EVERYTHING_SORT_DATE_ACCESSED_ASCENDING(23),
    EVERYTHING_SORT_DATE_ACCESSED_DESCENDING(24),
    EVERYTHING_SORT_DATE_RUN_ASCENDING(25),
    EVERYTHING_SORT_DATE_RUN_DESCENDING(26);

    // 定义枚举实例的值
    private final int value;

    // 定义一个映射，用于根据值快速查找对应的枚举实例
    private static final Map<Integer, EverythingSortCode> requestValueMap;

    // 静态初始化块，用于初始化映射
    static {
        requestValueMap = Arrays.stream(EverythingSortCode.values()).collect(Collectors.toMap(EverythingSortCode::getValue, e -> e));
    }

    /**
     * 根据给定的值解析并返回对应的枚举实例
     *
     * @param value 需要解析的值
     * @return 对应的枚举实例，如果找不到则返回null
     */
    public static EverythingSortCode parse(int value) {
        return requestValueMap.get(value);
    }

    /**
     * 根据排序类型和排序方向解析并返回对应的枚举实例
     *
     * @param type      排序类型
     * @param ascending 是否升序
     * @return 对应的枚举实例
     */
    public static EverythingSortCode parse(EverythingSortType type, boolean ascending) {
        // 根据排序类型和是否升序计算出需要的枚举值，实现动态排序逻辑
        return EverythingSortCode.parse(type.getMapValue() + (ascending ? 0 : 1));
    }
}

