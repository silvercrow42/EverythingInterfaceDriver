package org.joker.everything.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 对各种数据进行排序类型枚举。
 * 此枚举定义了不同的排序标准及其映射值
 * 可用于根据名称、路径、修改日期或大小对数据进行排序。
 *
 * @auther joker
 * @date 2024/9/26 11:17
 */
@Getter
@AllArgsConstructor
public enum EverythingSortType {
    // 按名称排序，映射值为 1
    NAME("name", 1),
    // 按路径排序，映射值为 3
    PATH("path", 3),
    // 按修改日期排序，映射值为 13
    DATE_MODIFIED("date_modified", 13),
    // 按大小排序，映射值为 5
    SIZE("size", 5);

    // 实际的排序标准，例如 “name”、“path” 等。
    private final String value;

    // 与排序标准相对应的映射值，用于内部处理或传输。
    private final int mapValue;
}

