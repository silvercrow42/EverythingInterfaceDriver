package org.joker.everything.ddl.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Everything回复码枚举类
 * 该枚举类用于定义Everything搜索操作完成后可能返回的各种状态码及其描述
 *
 * @auther joker
 * @date 2024/9/26 9:23
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EverythingReplyCode {
    // 操作已成功完成
    EVERYTHING_OK(0, "The operation completed successfully."),
    // 无法为搜索查询分配内存
    EVERYTHING_ERROR_MEMORY(1, "Failed to allocate memory for the search query."),
    // IPC 不可用
    EVERYTHING_ERROR_IPC(2, "IPC is not available."),
    // 无法注册搜索查询窗口类
    EVERYTHING_ERROR_REGISTERCLASSEX(3, "Failed to register the search query window class."),
    // 无法创建搜索查询窗口
    EVERYTHING_ERROR_CREATEWINDOW(4, "Failed to create the search query window."),
    // 无法创建搜索查询线程
    EVERYTHING_ERROR_CREATETHREAD(5, "Failed to create the search query thread."),
    // 索引无效 索引必须大于或等于 0 且小于可见结果的数量
    EVERYTHING_ERROR_INVALIDINDEX(6, "Invalid index. The index must be greater or equal to 0 and less than the number of visible results."),
    // 无效的调用
    EVERYTHING_ERROR_INVALIDCALL(7, "Invalid call.");

    /**
     * Everything回复码的值
     */
    private final int value;

    /**
     * Everything回复码的描述信息
     */
    private final String msg;

    /**
     * 用于快速查找EverythingReplyCode的静态映射表
     */
    private static final Map<Integer, EverythingReplyCode> replyValueMap;

    // 静态初始化块，初始化replyValueMap
    static {
        replyValueMap = Arrays.stream(EverythingReplyCode.values()).collect(Collectors.toMap(EverythingReplyCode::getValue, e -> e));
    }

    /**
     * 根据给定的值解析EverythingReplyCode枚举实例
     *
     * @param value Everything回复码的值
     * @return 对应的EverythingReplyCode枚举实例，如果找不到则返回null
     */
    public static EverythingReplyCode parse(int value) {
        return replyValueMap.get(value);
    }
}

