本项目提供 JAVA 平台下调用 Everything 搜索引擎的能力。

1. 前置准备
    1. 下载 安装并启动 Everything 搜索引擎，
2. 正式使用
    - dll方式调用
        1. 下载 Everything-SDK并解压到自己喜欢的目录中

           [Everything下载页面](https://www.voidtools.com/zh-cn/downloads/)
        2. 依据sdk中dll的文件地址(一般为：EverythingSDK/dll)，新建查询类或控制类使用

            ```java
            new EverythingDllFinder("SDK中的dll目录")//用于运行查询
            new EverythingDllController("SDK中的dll目录")//用于控制 Everything数据库
            ```
    - http方式调用
        1. 参照[Everything官方文档](https://www.voidtools.com/zh-cn/support/everything/http/)开启Everything的http服务
        2. 依据http地址创建查询类使用
           ```java
           new EverythingHttpFinder("http地址")
           ```