package org.joker.everything.ddl.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 枚举类，表示目标计算机的机器类型
 *
 * @auther joker
 * @date 2024/9/26 10:08
 */
@Getter
@AllArgsConstructor
public enum EverythingTargetMachineCode {
    //目标计算机为 x86（32 位）。
    EVERYTHING_TARGET_MACHINE_X86(1),
    //目标计算机是 x64 （64 位） 。
    EVERYTHING_TARGET_MACHINE_X64(2),
    //目标计算机是 ARM。
    EVERYTHING_TARGET_MACHINE_ARM(3),
    //目标计算机是 ARM64。
    EVERYTHING_TARGET_MACHINE_ARM64(4);

    private final int value;

    /**
     * 用于快速查找枚举实例的映射，将整数值映射到对应的枚举常量
     */
    private static final Map<Integer, EverythingTargetMachineCode> targetMachineValueMap;

    // 静态初始化块，在类加载时初始化映射表
    static {
        targetMachineValueMap = Arrays.stream(EverythingTargetMachineCode.values())
                .collect(Collectors.toMap(EverythingTargetMachineCode::getValue, everythingTargetMachineCode -> everythingTargetMachineCode));
    }

    /**
     * 根据整数值解析对应的枚举常量
     *
     * @param value 整数值
     * @return 对应的枚举常量，如果找不到则返回null
     */
    public static EverythingTargetMachineCode parse(int value) {
        return targetMachineValueMap.get(value);
    }
}

