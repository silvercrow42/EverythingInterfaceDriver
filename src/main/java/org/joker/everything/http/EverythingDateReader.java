package org.joker.everything.http;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.reader.ObjectReader;

import java.lang.reflect.Type;
import java.math.BigInteger;

/**
 * 类EverythingDateReader实现了ObjectReader接口，用于读取和转换日期字符串
 * 它主要负责将Windows FILETIME时间格式转换为Unix时间戳
 *
 * @auther joker
 * @date 2024/9/26 16:59
 */
public class EverythingDateReader implements ObjectReader<String> {

    // Windows TICK表示每秒的10000000个100纳秒间隔
    private static final int WINDOWS_TICK = 10000000; //10的7次方

    // TICK_DIFF定义了Windows TICK到Unix时间戳的转换因子
    private static final int TICK_DIFF = 10000;
    // SEC_TO_UNIX_EPOCH表示1970年1月1日（Unix纪元）到1601年1月1日（Windows纪元）的秒数差
    private static final long SEC_TO_UNIX_EPOCH = 11644473600L; //1601与1970的时间间隔

    // FILETIME_TO_UNIX_EPOCH表示Windows FILETIME时间纪元到Unix时间纪元的纳秒间隔
    private static final BigInteger FILETIME_TO_UNIX_EPOCH = BigInteger.valueOf(SEC_TO_UNIX_EPOCH).multiply(BigInteger.valueOf(WINDOWS_TICK));

    /**
     * 从JSON Reader中读取日期字符串并转换为Unix时间戳
     *
     * @param jsonReader JSON Reader对象，用于读取JSON数据
     * @param fieldType  目标字段的类型
     * @param fieldName  字段名对象，传递字段名称
     * @param features   读取过程中的特性标志
     * @return 转换后的Unix时间戳字符串或原始日期字符串
     */
    @Override
    public String readObject(JSONReader jsonReader, Type fieldType, Object fieldName, long features) {
        // 读取JSON中的日期字符串
        String dateStr = jsonReader.readString();
        // 将日期字符串转换为BigInteger类型的时间戳
        BigInteger dateTimestamp = new BigInteger(dateStr);

        // 如果日期时间戳大于FILETIME到Unix纪元的转换值
        if (dateTimestamp.compareTo(FILETIME_TO_UNIX_EPOCH) > 0) {
            // 减去时间纪元差并除以TICK_DIFF得到Unix时间戳，并转换为字符串返回
            return dateTimestamp.subtract(FILETIME_TO_UNIX_EPOCH).divide(BigInteger.valueOf(TICK_DIFF)).toString();
        }
        // 如果日期时间戳不在有效范围内，直接返回原始日期字符串
        return dateStr;
    }
}

