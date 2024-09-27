package org.joker.everything.http;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.writer.ObjectWriter;

import java.lang.reflect.Type;

/**
 * 该类实现了ObjectWriter接口，专门用于将Boolean类型的对象写入JSON
 *
 * @auther joker
 * @date 2024/9/26 14:42
 */
public class EverythingBooleanWriter implements ObjectWriter<Boolean> {

    /**
     * 将Boolean对象写入JSON
     *
     * @param jsonWriter JSON写入器
     * @param o          要写入的Boolean对象
     * @param o1         未使用的参数，保留以符合方法签名
     * @param type       Boolean对象的类型信息，未使用
     * @param l          未使用的参数，保留以符合方法签名
     */
    @Override
    public void write(JSONWriter jsonWriter, Object o, Object o1, Type type, long l) {
        // 当输入对象o为null时，直接写入null到JSON
        if (o == null) {
            jsonWriter.writeNull();
            return;
        }

        // 将输入对象o强制转换为Boolean类型，并以此判断后续写入的值
        boolean isTrue = (Boolean) o;
        // 优先使用name作为判断标准，将Boolean值转换为int（true为1，false为0）并写入JSON
        jsonWriter.writeInt32(isTrue ? 1 : 0);
    }
}

