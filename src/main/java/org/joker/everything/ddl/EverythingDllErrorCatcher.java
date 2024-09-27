package org.joker.everything.ddl;

import org.joker.everything.ddl.constant.EverythingReplyCode;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

/**
 * 类EverythingDllErrorCatcher用于处理EverythingLibrary可能抛出的DLL错误。
 * 它通过捕获和解析DLL错误代码，并在必要时抛出异常来执行操作。
 *
 * @auther joker
 * @date 2024/9/27 10:19
 */
public class EverythingDllErrorCatcher {
    // 保护性的EverythingLibrary实例，用于调用Everything相关的函数
    protected final EverythingLibrary instance;

    /**
     * 默认构造函数，使用默认路径初始化EverythingLibrary实例。
     */
    public EverythingDllErrorCatcher() {
        this("");
    }

    /**
     * 构造函数，允许指定EverythingLibrary的路径。
     *
     * @param path EverythingLibrary的路径。
     */
    public EverythingDllErrorCatcher(String path) {
        instance = EverythingImportFactory.getInstance(path);
    }

    /**
     * 获取上一次Everything函数调用的错误代码。
     *
     * @return 上一次函数调用的错误代码。
     * @see EverythingLibrary#Everything_GetLastError()
     */
    private int getLastError() {
        return instance.Everything_GetLastError().intValue();
    }

    /**
     * 执行给定的Callable操作，并根据错误预测处理可能的错误。
     * 如果检测到错误，根据EverythingReplyCode抛出异常。
     *
     * @param callable 要执行的Callable操作。
     * @param isError  判断Callable操作返回值是否表示错误的预测函数。
     * @param <R>      操作返回的类型。
     * @return Callable操作的返回值。
     * @throws IllegalStateException 如果检测到错误或在执行过程中遇到异常。
     */
    protected <R> R doWithThrow(Callable<R> callable, Predicate<R> isError) {
        try {
            R call = callable.call();
            if (isError.test(call)) {
                int errorCode = getLastError();
                EverythingReplyCode error = EverythingReplyCode.parse(errorCode);
                if (!EverythingReplyCode.EVERYTHING_OK.equals(error)) {
                    throw new IllegalStateException(error.getMsg());
                }
            }
            return call;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}

