package org.joker.everything.ddl;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.Getter;

/**
 * 获取Everything库实例并处理错误的控制器类
 *
 * @auther joker
 * @date 2024/9/27 10:13
 */
@Getter
public class EverythingDllController extends EverythingDllErrorCatcher {
    // 日志记录器，用于记录EverythingDllFinder类的事件
    private static final Logger logger = LoggerFactory.getLogger(EverythingDllFinder.class);
    // Everything库的实例
    private final EverythingLibrary instance;

    /**
     * 默认构造函数，使用空字符串初始化Everything库实例
     */
    public EverythingDllController() {
        this("");
    }

    /**
     * 带路径参数的构造函数，根据给定路径初始化Everything库实例
     *
     * @param path dll所在路径参数
     */
    public EverythingDllController(String path) {
        instance = EverythingImportFactory.getInstance(path);
    }


    /**
     * 清理资源的方法，调用Everything库的清理方法
     *
     * @see EverythingLibrary#Everything_CleanUp()
     */
    public void cleanUp() {
        instance.Everything_CleanUp();
    }

    /**
     * 删除运行历史记录的方法，调用Everything库的删除运行历史记录方法
     *
     * @see EverythingLibrary#Everything_DeleteRunHistory()
     */
    public void deleteRunHistory() {
        doWithThrow(instance::Everything_DeleteRunHistory, r -> r);
    }

    /**
     * 退出Everything的方法，调用Everything库的退出方法
     *
     * @see EverythingLibrary#Everything_Exit()
     */
    public void exit() {
        doWithThrow(instance::Everything_Exit, r -> r);
    }

    /**
     * 重建数据库的方法，调用Everything库的重建数据库方法
     *
     * @see EverythingLibrary#Everything_RebuildDB()
     */
    public void rebuildDB() {
        doWithThrow(instance::Everything_RebuildDB, r -> r);
    }

    /**
     * 保存数据库的方法，调用Everything库的保存数据库方法
     *
     * @see EverythingLibrary#Everything_SaveDB()
     */
    public void saveDB() {
        doWithThrow(instance::Everything_SaveDB, r -> r);
    }

    /**
     * 保存运行历史记录的方法，调用Everything库的保存运行历史记录方法
     *
     * @see EverythingLibrary#Everything_SaveRunHistory()
     */
    public void saveRunHistory() {
        doWithThrow(instance::Everything_SaveRunHistory, r -> r);
    }

    /**
     * 更新所有文件夹索引的方法，调用Everything库的更新所有文件夹索引方法
     *
     * @see EverythingLibrary#Everything_UpdateAllFolderIndexes()
     */
    public void updateAllFolderIndexes() {
        doWithThrow(instance::Everything_UpdateAllFolderIndexes, r -> r);
    }
}
