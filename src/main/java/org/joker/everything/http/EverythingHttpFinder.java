package org.joker.everything.http;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import org.joker.everything.entity.EverythingRequest;
import org.joker.everything.entity.EverythingResponse;

import java.nio.charset.StandardCharsets;

/**
 * EverythingHttpFinder 类用于通过HTTP协议查询Everything服务
 *
 * @auther joker
 * @date 2024/9/26 13:19
 */
public class EverythingHttpFinder {

    // 存储Everything服务的URL路径
    private final String path;

    /**
     * 默认构造函数，初始化Everything服务的URL为本地主机的HTTP地址
     */
    public EverythingHttpFinder() {
        this("http://localhost");
    }

    /**
     * 构造函数，初始化Everything服务的URL
     *
     * @param httpUrl Everything服务的HTTP URL地址
     */
    public EverythingHttpFinder(String httpUrl) {
        this.path = httpUrl;
    }

    /**
     * 向Everything服务发送查询请求
     *
     * @param request 查询请求对象，包含查询参数等信息
     * @return 返回查询结果对象，包含Everything服务的响应信息
     */
    public EverythingResponse query(EverythingRequest request) {
        // 将请求对象转换为JSON字符串
        String jsonString = JSONObject.toJSONString(request);
        // 将JSON字符串解析为JSONObject对象，以便后续使用
        JSONObject params = JSONObject.parse(jsonString);
        // 构建包含查询参数的HTTP请求URL
        String url = HttpUtil.urlWithForm(this.path, params, StandardCharsets.UTF_8, false);
        // 发送GET请求并获取响应
        try (HttpResponse response = HttpUtil.createGet(url).execute()) {
            // 将响应体解析为EverythingResponse对象并返回
            return JSONObject.parseObject(response.body(), EverythingResponse.class);
        }
    }
}

