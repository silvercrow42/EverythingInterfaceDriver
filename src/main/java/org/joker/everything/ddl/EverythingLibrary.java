package org.joker.everything.ddl;

import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.StdCallLibrary;
import org.joker.everything.ddl.constant.EverythingRequestCode;
import org.joker.everything.ddl.constant.EverythingSortCode;

/**
 * 单线程运行，需要注意线程安全
 *
 * @author joker
 * @date 2024/9/26 22:15
 */
public interface EverythingLibrary extends StdCallLibrary {
    /**
     * Everything_CleanUp 函数重置结果列表和搜索状态，从而释放库分配的任何内存。
     */
    void Everything_CleanUp();

    /**
     * Everything_DeleteRunHistory 函数将删除所有运行历史记录。
     *
     * @return 如果清除了 run history （运行历史记录），则函数返回非零值。<br>
     * 如果发生错误，该函数将返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}
     */
    boolean Everything_DeleteRunHistory();

    /**
     * Everything_Exit 函数请求 Everything 退出。
     *
     * @return 如果退出请求成功，该函数将返回非零值。<br>
     * 如果请求失败，该函数返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}
     */
    boolean Everything_Exit();

    /**
     * Everything_GetBuildNumber 函数返回当前 Everything 的构建号。
     *
     * @return 构建号。如果生成信息不可用，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError}
     */
    WinDef.DWORD Everything_GetBuildNumber();

    /**
     * Everything_GetLastError 函数返回上次调用失败的函数的错误代码。
     *
     * @return 如果上一个函数调用成功，则函数返回 Everything_OK。<br>
     * 如果上一个函数调用失败，则函数返回错误代码。
     */
    WinDef.DWORD Everything_GetLastError();

    /**
     * Everything_GetMajorVersion 函数返回当前 Everything 的主要版本号。
     *
     * @return 主要版本号。如果生成信息不可用，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError}
     */
    WinDef.DWORD Everything_GetMajorVersion();

    /**
     * Everything_GetMatchCase 函数返回 匹配大小写 的开关状态。
     *
     * @return 返回值是 匹配大小写 状态。<br>
     * 如果启用了 匹配大小写，则函数返回 TRUE。<br>
     * 如果禁用了 匹配大小写，则函数返回 FALSE。
     */
    boolean Everything_GetMatchCase();

    /**
     * Everything_GetMatchPath 函数返回 全路径匹配 的开关状态。
     *
     * @return 返回值是 全路径匹配 状态。<br>
     * 如果启用了 全路径匹配，则函数返回 TRUE。<br>
     * 如果禁用了 全路径匹配，则函数返回 FALSE。
     */
    boolean Everything_GetMatchPath();

    /**
     * Everything_GetMatchWholeWord 函数返回 全词匹配 的开关状态。
     *
     * @return 返回值是 全词匹配 状态。<br>
     * 如果启用了 全词匹配，则函数返回 TRUE。<br>
     * 如果禁用了 全词匹配，则函数返回 FALSE。
     */
    boolean Everything_GetMatchWholeWord();

    /**
     * Everything_GetMax 函数返回 最大结果数 的值。
     *
     * @return 最大结果数。如果最大结果数不可用，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError}
     */
    WinDef.DWORD Everything_GetMax();

    /**
     * Everything_GetMinorVersion 函数返回当前 Everything 的次版本号。
     *
     * @return 次版本号。如果生成信息不可用，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError}
     */
    WinDef.DWORD Everything_GetMinorVersion();

    /**
     * Everything_GetNumFileResults 函数返回当前文件结果数。
     *
     * @return 文件结果数。如果文件结果数不可用，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError}
     */
    WinDef.DWORD Everything_GetNumFileResults();

    /**
     * Everything_GetNumFolderResults 函数返回当前文件夹结果数。
     *
     * @return 文件夹结果数。如果文件夹结果数不可用，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError}
     */
    WinDef.DWORD Everything_GetNumFolderResults();

    /**
     * Everything_GetNumResults 函数返回当前结果数。
     *
     * @return 结果数。如果结果数不可用，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError}
     */
    WinDef.DWORD Everything_GetNumResults();

    default int Everything_GetIntNumResults() {
        return Everything_GetNumResults().intValue();
    }

    /**
     * Everything_GetOffset 函数返回当前偏移量。
     *
     * @return 偏移量。如果偏移量不可用，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError}
     */
    WinDef.DWORD Everything_GetOffset();

    /**
     * Everything_GetRegex 函数返回 正则表达式 搜索 的开关状态。
     *
     * @return 返回值是 正则表达式 搜索 状态。<br>
     * 如果启用了 正则表达式 搜索，则函数返回 TRUE。<br>
     * 如果禁用了 正则表达式 搜索，则函数返回 FALSE。
     */
    boolean Everything_GetRegex();

    /**
     * Everything_GetReplyID 函数返回 IPC 查询回复的当前回复标识符。
     *
     * @return 当前回复标识符 (默认回复标识符为 0)
     */
    WinDef.DWORD Everything_GetReplyID();

    /**
     * Everything_GetReplyWindow 函数返回 IPC 查询回复的当前回复窗口句柄。
     *
     * @return 返回值是当前回复窗口。(默认回复窗口为 0 或无回复窗口。)
     */
    WinDef.HWND Everything_GetReplyWindow();

    /**
     * Everything_GetRequestFlags 函数返回当前查询请求标志。
     *
     * @return 返回零个或多个以下请求标志，默认请求标志为 EVERYTHING_REQUEST_FILE_NAME | EVERYTHING_REQUEST_PATH （0x00000003）
     * @see EverythingRequestCode
     */
    WinDef.DWORD Everything_GetRequestFlags();

    /**
     * Everything_GetResultAttributes 函数检索可见结果的属性。<br>
     * dwIndex 必须是有效的可见结果索引。要确定结果索引是否可见，请使用
     * {@link EverythingLibrary#Everything_GetNumResults} 函数。
     *
     * @param dwIndex 可见结果的从零开始的索引。
     * @return 该函数返回零个或多个 FILE_ATTRIBUTE_* 标志。
     * 如果属性信息不可用，该函数将返回 INVALID_FILE_ATTRIBUTES。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError} <br>
     */
    WinDef.DWORD Everything_GetResultAttributes(WinDef.DWORD dwIndex);

    /**
     * Everything_GetResultDateAccessed 函数检索可见结果的创建日期。<br>
     * dwIndex 必须是有效的可见结果索引。要确定结果索引是否可见，请使用
     * {@link EverythingLibrary#Everything_GetNumResults} 函数。
     *
     * @param dwIndex        可见结果的从零开始的索引。
     * @param lpDateAccessed 指向 FILETIME 的指针，用于保存结果的访问日期。
     * @return 如果成功，该函数将返回非零值。<br>
     * 如果访问日期信息不可用，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError} <br>
     */
    boolean Everything_GetResultDateAccessed(WinDef.DWORD dwIndex, WinBase.FILETIME lpDateAccessed);

    /**
     * Everything_GetResultDateCreated 函数检索可见结果的创建日期。<br>
     * dwIndex 必须是有效的可见结果索引。要确定结果索引是否可见，请使用
     * {@link EverythingLibrary#Everything_GetNumResults} 函数。
     *
     * @param dwIndex       可见结果的从零开始的索引。
     * @param lpDateCreated 指向 FILETIME 的指针，用于保存结果的创建日期。
     * @return 如果成功，该函数将返回非零值。<br>
     * 如果创建日期信息不可用，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError} <br>
     */
    boolean Everything_GetResultDateCreated(WinDef.DWORD dwIndex, WinBase.FILETIME lpDateCreated);

    /**
     * Everything_GetResultDateModified 函数检索可见结果的修改日期。<br>
     * dwIndex 必须是有效的可见结果索引。要确定结果索引是否可见，请使用
     * {@link EverythingLibrary#Everything_GetNumResults} 函数。
     *
     * @param dwIndex        可见结果的从零开始的索引。
     * @param lpDateModified 指向 FILETIME 的指针，用于保存结果的修改日期。
     * @return 如果成功，该函数将返回非零值。<br>
     * 如果修改日期信息不可用，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError} <br>
     */
    boolean Everything_GetResultDateModified(WinDef.DWORD dwIndex, WinBase.FILETIME lpDateModified);

    /**
     * Everything_GetResultDateRecentlyChanged 函数检索可见结果的最近更改日期。<br>
     * dwIndex 必须是有效的可见结果索引。要确定结果索引是否可见，请使用
     * {@link EverythingLibrary#Everything_GetNumResults} 函数。
     *
     * @param dwIndex               可见结果的从零开始的索引。
     * @param lpDateRecentlyChanged 指向 FILETIME 的指针，用于保存结果的最近更改日期。
     * @return 如果成功，该函数将返回非零值。<br>
     * 如果最近更改日期信息不可用，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError} <br>
     */
    boolean Everything_GetResultDateRecentlyChanged(WinDef.DWORD dwIndex, WinBase.FILETIME lpDateRecentlyChanged);

    /**
     * Everything_GetResultDateRun 函数检索可见结果的上次运行日期。<br>
     * dwIndex 必须是有效的可见结果索引。要确定结果索引是否可见，请使用
     * {@link EverythingLibrary#Everything_GetNumResults} 函数。
     *
     * @param dwIndex   可见结果的从零开始的索引。
     * @param lpDateRun 指向 FILETIME 的指针，用于保存结果的上次运行日期。
     * @return 如果成功，该函数将返回非零值。<br>
     * 如果上次运行日期信息不可用，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError} <br>
     */
    boolean Everything_GetResultDateRun(WinDef.DWORD dwIndex, WinBase.FILETIME lpDateRun);

    /**
     * Everything_GetResultExtensionW 函数检索可见结果的扩展部分。<br>
     * 此函数的 ANSI/Unicode 版本必须与对
     * {@link EverythingLibrary#Everything_QueryW} 的调用的 ANSI/Unicode 版本匹配。<br>
     * 该函数返回一个指向内部结构的指针，该指针仅在下次调用
     * {@link EverythingLibrary#Everything_QueryW} 或 {@link EverythingLibrary#Everything_Reset} 之前有效。<br>
     * dwIndex 必须是有效的可见结果索引。要确定结果是否可见，请使用
     * {@link EverythingLibrary#Everything_GetNumFileResults} 函数。<br>
     *
     * @param dwIndex 可见结果的从零开始的索引。
     * @return 该函数返回一个指针，该指针指向以 null 结尾的 TCHAR 字符串。<br>
     * 如果函数失败，则返回值为 NULL。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError} <br>
     */
    WString Everything_GetResultExtensionW(WinDef.DWORD dwIndex);

    /**
     * Everything_GetResultFileListFileName 函数检索可见结果的文件列表完整路径和文件名。<br>
     * 此函数的 ANSI/Unicode 版本必须与对
     * {@link EverythingLibrary#Everything_QueryW} 的调用的 ANSI/Unicode 版本匹配。<br>
     * 该函数返回一个指向内部结构的指针，该指针仅在下次调用
     * {@link EverythingLibrary#Everything_QueryW} 或
     * {@link EverythingLibrary#Everything_Reset} 之前有效。<br>
     * dwIndex 必须是有效的可见结果索引。要确定结果是否可见，请使用
     * {@link EverythingLibrary#Everything_GetNumFileResults} 函数。<br>
     *
     * @param dwIndex 可见结果的从零开始的索引。
     * @return 该函数返回一个指针，该指针指向以 null 结尾的 TCHAR 字符串。<br>
     * 如果函数失败，则返回值为 NULL。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError} <br>
     */
    WString Everything_GetResultFileListFileNameW(WinDef.DWORD dwIndex);

    /**
     * Everything_GetResultFileName 函数检索可见结果的文件名。<br>
     * 此函数的 ANSI/Unicode 版本必须与对
     * {@link EverythingLibrary#Everything_QueryW} 的调用的 ANSI/Unicode 版本匹配。<br>
     * 该函数返回一个指向内部结构的指针，该指针仅在下次调用
     * {@link EverythingLibrary#Everything_QueryW} 或
     * {@link EverythingLibrary#Everything_Reset} 之前有效。<br>
     * dwIndex 必须是有效的可见结果索引。要确定结果是否可见，请使用
     * {@link EverythingLibrary#Everything_GetNumFileResults} 函数。<br>
     *
     * @param dwIndex 可见结果的从零开始的索引。
     * @return 该函数返回一个指针，该指针指向以 null 结尾的 TCHAR 字符串。<br>
     * 如果函数失败，则返回值为 NULL。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError} <br>
     */
    WString Everything_GetResultFileNameW(WinDef.DWORD dwIndex);

    /**
     * Everything_GetResultFullPathName 函数检索可见结果的完整路径和文件名。<br>
     * 您只能为可见的结果调用此函数。要确定结果是否可见，请使用
     * {@link EverythingLibrary#Everything_GetNumFileResults} 函数。<br>
     * 您可以混合使用 Everything_GetResultFullPathNameW 和 {@link EverythingLibrary#Everything_QueryW} 的 ANSI / Unicode 版本。<br>
     *
     * @param dwIndex   可见结果从零开始的索引。
     * @param lpString  (输出参数)指向将接收文本的缓冲区的指针。如果字符串与缓冲区一样长或长，则字符串将被截断并以 NULL 字符终止。
     * @param nMaxCount 指定要复制到缓冲区的最大字符数，包括 NULL 字符。如果文本超过此限制，则会截断文本。
     * @return 如果 lpString 为 NULL，则返回值是存储可见结果的完整路径和文件名所需的 TCHAR 数（不包括 null 终止符）。<br>
     * 如果 lpString 不为 NULL，则返回值是复制到 lpString 中的 TCHAR 数，不包括 null 终止符。<br>
     * 如果函数失败，则返回值为 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError} 。<br>
     */
    WinDef.DWORD Everything_GetResultFullPathNameW(WinDef.DWORD dwIndex, char[] lpString, WinDef.DWORD nMaxCount);

    /**
     * Everything_GetResultHighlightedFileName 函数检索可见结果中突出显示的文件名部分。<br>
     * 此函数的 ANSI / Unicode 版本必须与对
     * {@link EverythingLibrary#Everything_QueryW} 的调用的 ANSI / Unicode 版本匹配。<br>
     * 该函数返回一个指向内部结构的指针，该指针仅在下次调用
     * {@link EverythingLibrary#Everything_QueryW} 或
     * {@link EverythingLibrary#Everything_Reset} 之前有效。<br>
     * 您只能为可见的结果调用此函数。要确定结果是否可见，请使用
     * {@link EverythingLibrary#Everything_GetNumFileResults} 函数。<br>
     * 引号内的文本将突出显示，两个连续的 * 是单个文本 *。<br>
     * 例如，在突出显示的文本中：abc *123* 突出显示了 123 部分。<br>
     *
     * @param index 可见结果的从零开始的索引。
     * @return 该函数返回一个指针，该指针指向以 null 结尾的 TCHAR 字符串。<br>
     * 如果函数失败，则返回值为 NULL。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}。<br>
     */
    WString Everything_GetResultHighlightedFileNameW(int index);

    /**
     * Everything_GetResultHighlightedFullPathAndFileName 函数检索可见结果的高亮显示完整路径和文件名。<br>
     * 此函数的 ANSI / Unicode 版本必须与对
     * {@link EverythingLibrary#Everything_QueryW} 的调用的 ANSI / Unicode 版本匹配。<br>
     * 该函数返回一个指向内部结构的指针，该指针仅在下次调用
     * {@link EverythingLibrary#Everything_QueryW} 或
     * {@link EverythingLibrary#Everything_Reset} 之前有效。<br>
     * 您只能为可见的结果调用此函数。要确定结果是否可见，请使用
     * {@link EverythingLibrary#Everything_GetNumFileResults} 函数。<br>
     * 引号内的文本将突出显示，两个连续的 * 是单个文本 *。<br>
     * 例如，在突出显示的文本中：abc *123* 突出显示了 123 部分。<br>
     *
     * @param index 可见结果的从零开始的索引。
     * @return 该函数返回一个指针，该指针指向以 null 结尾的 TCHAR 字符串。<br>
     * 如果函数失败，则返回值为 NULL。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}。<br>
     */
    WString Everything_GetResultHighlightedFullPathAndFileNameW(int index);

    /**
     * Everything_GetResultHighlightedPath 函数检索可见结果的高亮显示路径部分。<br>
     * 此函数的 ANSI / Unicode 版本必须与对
     * {@link EverythingLibrary#Everything_QueryW} 的调用的 ANSI / Unicode 版本匹配。<br>
     * 该函数返回一个指向内部结构的指针，该指针仅在下次调用
     * {@link EverythingLibrary#Everything_QueryW} 或
     * {@link EverythingLibrary#Everything_Reset} 之前有效。<br>
     * 您只能为可见的结果调用此函数。要确定结果是否可见，请使用 {@link EverythingLibrary#Everything_GetNumFileResults} 函数。<br>
     * 引号内的文本将突出显示，两个连续的 * 是单个文本 *。<br>
     * 例如，在突出显示的文本中：abc *123* 突出显示了 123 部分。<br>
     *
     * @param index 可见结果的从零开始的索引。
     * @return 该函数返回一个指针，该指针指向以 null 结尾的 TCHAR 字符串。<br>
     * 如果函数失败，则返回值为 NULL。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}。<br>
     */
    WString Everything_GetResultHighlightedPathW(int index);

    /**
     * Everything_GetResultListRequestFlags 函数返回可用结果数据的标志。
     *
     * @return 返回零个或多个请求标志 <br>
     * 请求的结果数据可能与 {@link EverythingLibrary#Everything_SetRequestFlags} 中指定的所需结果数据不同.
     * @see EverythingRequestCode
     */
    WinDef.DWORD Everything_GetResultListRequestFlags();

    /**
     * Everything_GetResultListSort 函数返回结果的实际排序顺序.
     *
     * @return 返回排序类型<br>
     * Everything_GetResultListSort 必须在调用 {@link EverythingLibrary#Everything_QueryW} 后调用.<br>
     * 如果未指定所需的排序顺序，则结果列表将按 EVERYTHING_SORT_NAME_ASCENDING 进行排序.<br>
     * 结果列表排序可能与 {@link EverythingLibrary#Everything_SetSort} 中指定的所需排序不同.
     * @see EverythingSortCode
     */
    WinDef.DWORD Everything_GetResultListSort();

    /**
     * Everything_GetResultPath 函数检索可见结果的 path 部分。<br>
     * 此函数的 ANSI / Unicode 版本必须与对 {@link EverythingLibrary#Everything_QueryW} 的调用的 ANSI / Unicode 版本匹配。<br>
     * 该函数比 {@link EverythingLibrary#Everything_GetResultFullPathNameW} 更快，因为不会发生内存复制。<br>
     * 该函数返回一个指向内部结构的指针，该指针仅在下次调用 {@link EverythingLibrary#Everything_QueryW} 或
     * {@link EverythingLibrary#Everything_Reset} 之前有效。<br>
     * 您只能为可见的结果调用此函数。要确定结果是否可见，请使用 {@link EverythingLibrary#Everything_GetNumFileResults} 函数。
     *
     * @param index 可见结果的从零开始的索引。
     * @return 该函数返回一个指针，该指针指向以 null 结尾的 TCHAR 字符串。<br>
     * 如果函数失败，则返回值为 NULL。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}。<br>
     */
    WString Everything_GetResultPathW(int index);

    /**
     * Everything_GetResultRunCount 函数检索从 Everything 运行可见结果的次数。<br>
     * dwIndex 必须是有效的可见结果索引。要确定结果索引是否可见，请使用 {@link EverythingLibrary#Everything_GetNumResults} 函数。
     *
     * @param index 可见结果的从零开始的索引。
     * @return 该函数返回从 Everything 运行结果的次数。
     * 如果运行计数信息不可用，则函数返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}<br>
     */
    WinDef.DWORD Everything_GetResultRunCount(WinDef.DWORD index);

    /**
     * Everything_GetResultSize 函数检索可见结果的大小。<br>
     * dwIndex 必须是有效的可见结果索引。要确定结果索引是否可见，请使用 {@link EverythingLibrary#Everything_GetNumResults} 函数。
     *
     * @param dwIndex 可见结果的从零开始的索引。
     * @param lpSize  指向LARGE_INTEGER的指针，用于保存结果的大小。
     * @return 如果成功，该函数将返回非零值。<br>
     * 如果大小信息不可用，则函数返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}
     */
    boolean Everything_GetResultSize(WinDef.DWORD dwIndex, WinDef.LONGByReference lpSize);

    /**
     * Everything_GetRevision 函数检索 Everything 的修订号。<br>
     * 所有内容均使用以下版本格式：<br>
     * 主要版本号.次要版本号.修订号.构建号<br>
     * 构建部分是增量的，并且对于所有 Everything 版本都是唯一的。
     *
     * @return 该函数返回修订号。<br>
     * 如果修订信息不可用，则函数返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}
     */
    WinDef.DWORD Everything_GetRevision();

    /**
     * Everything_GetRunCountFromFileName 函数按文件名从 Everything 索引中的指定文件获取运行计数.
     *
     * @param lpFileName 指向以 null 结尾的字符串的指针，该字符串在 Everything 索引中指定完全限定的文件名.
     * @return 该函数返回文件从 Everything 运行的次数.<br>
     * 如果发生错误，该函数返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}
     */
    WinDef.DWORD Everything_GetRunCountFromFileName(WString lpFileName);

    /**
     * Everything_GetSearch 函数检索搜索文本，用于下次调用 {@link EverythingLibrary#Everything_QueryW}。<br>
     * 获取搜索文本的内部状态。<br>
     * 默认字符串为空字符串。
     *
     * @return 返回值是指向以 null 结尾的搜索字符串的指针。<br>
     * unicode 和 ansi 版本必须与对 {@link EverythingLibrary#Everything_SetSearchW} 的调用匹配。<br>
     * 如果您在调用 Everything_SetSearchW 后调用 Everything_GetSearchA 函数，则该函数将失败<br>
     * 如果您在调用 Everything_SetSearchA 后调用 Everything_GetSearchW 函数，则该函数将失败<br>
     * 如果函数失败，则返回值为 NULL。<br>
     * 要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}。
     */
    WString Everything_GetSearchW();

    /**
     * Everything_GetSort 函数返回结果所需的排序顺序。
     * 默认排序为 EVERYTHING_SORT_NAME_ASCENDING （1）
     *
     * @return 返回排序类型。<br>
     * @see EverythingSortCode
     */
    WinDef.DWORD Everything_GetSort();

    /**
     * Everything_GetTargetMachine 函数检索 Everything 的目标机器种类。<br>
     * 所有内容均使用以下版本格式：<br>
     * 主要版本号.次要版本号.修订号.构建号<br>
     * 构建部分是增量的，并且对于所有 Everything 版本都是唯一的。
     *
     * @return 该函数返回目标机器种类。<br>
     * 如果目标计算机信息不可用，则函数返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}<br>
     */
    WinDef.DWORD Everything_GetTargetMachine();

    /**
     * Everything_GetTotFileResults 函数返回文件结果的总数。<br>
     * 您必须先调用 {@link EverythingLibrary#Everything_QueryW} 再调用 Everything_GetTotFileResults。<br>
     * 使用 {@link EverythingLibrary#Everything_GetNumFileResults} 检索可见文件结果的数量。<br>
     * 使用 result offset 和 max result 值来限制可见结果的数量。<br>
     * 使用 {@link EverythingLibrary#Everything_SetRequestFlags} 时不支持 Everything_GetTotFileResults
     *
     * @return 返回文件结果的总数。<br>
     * 如果函数失败，则返回值为 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}。
     */
    WinDef.DWORD Everything_GetTotFileResults();

    /**
     * Everything_GetTotFolderResults 函数返回文件夹结果的总数。<br>
     * 您必须先调用 {@link EverythingLibrary#Everything_QueryW} 再调用 Everything_GetTotFolderResults。<br>
     * 使用 {@link EverythingLibrary#Everything_GetNumFolderResults} 检索可见文件夹结果的数量。<br>
     * 使用 result offset 和 max result 值来限制可见结果的数量。<br>
     * 使用 {@link EverythingLibrary#Everything_SetRequestFlags} 时不支持 Everything_GetTotFolderResults
     *
     * @return 返回文件夹结果的总数.<br>
     * 如果函数失败，则返回值为 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}。
     */
    WinDef.DWORD Everything_GetTotFolderResults();

    /**
     * Everything_GetTotResults 函数返回文件和文件夹结果的总数。<br>
     * 您必须先调用 {@link EverythingLibrary#Everything_QueryW} 再调用 Everything_GetTotResults。<br>
     * 使用 {@link EverythingLibrary#Everything_GetNumResults} 检索可见文件和文件夹结果的数量。<br>
     * 使用 result offset 和 max result 值来限制可见结果的数量。
     *
     * @return 返回文件和文件夹结果的总数。<br>
     * 如果函数失败，则返回值为 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}。
     */
    WinDef.DWORD Everything_GetTotResults();

    /**
     * Everything_IncRunCountFromFileName 函数将 Everything by file name 中指定文件的运行计数增加 1.<br>
     * 该文件不必存在。创建文件后，它将具有正确的运行历史记录.<br>
     * 在文件删除和创建之间保留运行历史记录信息。<br>
     * 调用此函数会将指定文件的运行日期更新为当前时间。<br>
     * 递增运行计数为 4294967295 （0xffffffff） 的文件不会执行任何操作。
     *
     * @param lpFileName 指向以 null 结尾的字符串的指针，该字符串在 Everything 索引中指定完全限定的文件名.
     * @return 该函数返回指定文件的新运行计数.<br>
     * 如果发生错误，该函数将返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}
     */
    WinDef.DWORD Everything_IncRunCountFromFileName(WString lpFileName);

    /**
     * Everything_IsAdmin 功能检查 Everything 是以管理员身份运行还是以标准用户身份运行。
     *
     * @return 如果 Everything 以管理员身份运行，则该函数返回非零。<br>
     * 如果该函数返回 0，则 Everything 以标准用户身份运行，或者如果发生了错误。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError}
     */
    boolean Everything_IsAdmin();

    /**
     * Everything_IsAppData 功能检查 Everything 是否将设置和数据保存到 %APPDATA%\Everything 或与Everything.exe相同的位置。
     *
     * @return 如果设置和数据保存在 %APPDATA%\Everything 中，则函数返回非零值。<br>
     * 如果设置和数据保存到与Everything.exe相同的位置，或者发生错误，则函数返回 0。要获取扩展错误信息，请调用
     * {@link EverythingLibrary#Everything_GetLastError}
     */
    boolean Everything_IsAppData();

    /**
     * Everything_IsDBLoaded 函数检查数据库是否已完全加载。<br>
     * 加载所有内容时，任何查询都不会返回任何结果。<br>
     * 在执行查询之前，使用 Everything_IsDBLoaded 确定是否已加载数据库。<br>
     *
     * @return 如果 Everything 数据库已完全加载，则该函数返回非零值。<br>
     * 如果数据库尚未完全加载或发生错误，则函数返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}
     */
    boolean Everything_IsDBLoaded();

    /**
     * Everything_IsFileResult 函数确定可见结果是否为 file。<br>
     * 您只能为可见结果调用此函数。要确定结果是否可见，请使用 {@link EverythingLibrary#Everything_GetNumFileResults} 函数。
     *
     * @param index 可见结果的从零开始的索引。
     * @return 如果可见结果是一个文件（例如：C：\ABC.123），则函数返回 TRUE。<br>
     * 如果可见结果是文件夹或卷（例如：C： 或 c：\WINDOWS），则函数返回 FALSE。<br>
     * 如果函数失败，则返回值为 FALSE。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}。
     */
    boolean Everything_IsFileResult(WinDef.DWORD index);

    /**
     * Everything_IsFolderResult 函数确定可见结果是否为文件夹。<br>
     * 您只能为可见结果调用此函数。要确定结果是否可见，请使用 {@link EverythingLibrary#Everything_GetNumFileResults} 函数。
     *
     * @param index 可见结果的从零开始的索引。
     * @return 如果可见结果是文件夹或卷（例如：C： 或 c：\WINDOWS），则函数返回 TRUE。<br>
     * 如果可见结果是文件（例如：C：\ABC.123），则函数返回 FALSE。<br>
     * 如果函数失败，则返回值为 FALSE。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}。
     */
    boolean Everything_IsFolderResult(WinDef.DWORD index);

    /**
     * Everything_IsQueryReply 函数检查指定的窗口消息是否为查询回复.
     *
     * @param message 指定消息标识符.
     * @param wParam  指定有关消息的其他信息.
     * @param lParam  指定有关消息的其他信息.
     * @param nId     使用 {@link EverythingLibrary#Everything_SetReplyID} 或 0 作为默认 ID 指定的唯一标识符.
     *                如果消息WM_COPYDATA，则此值用于与 COPYDATASTRUCT 的 dwData 成员进行比较。
     * @return 如果消息是查询回复，则返回 TRUE。<br>
     * 如果函数失败，则返回值为 FALSE。要获取扩展错误信息，请调用：{@link EverythingLibrary#Everything_GetLastError}。<br>
     * 此功能检查消息是否为 WM_COPYDATA 消息。如果消息是 WM_COPYDATA 消息，则函数将检查 ReplyID 是否与 COPYDATASTRUCT 的 dwData 成员匹配。如果它们匹配，则函数将复制查询结果。<br>
     * 如果在 bWait 设置为 FALSE 的情况下调用 {@link EverythingLibrary#Everything_QueryW}，
     * 则必须在 Windows 消息处理程序中调用 Everything_IsQueryReply 以检查 IPC 查询回复。<br>
     * 如果函数返回 TRUE，则应返回 TRUE。<br>
     * 如果函数返回 TRUE，您可以调用以下函数来读取结果：<br>
     * {@link EverythingLibrary#Everything_SortResultsByPath}<br>
     * {@link EverythingLibrary#Everything_Reset}<br>
     * {@link EverythingLibrary#Everything_GetNumFileResults}<br>
     * {@link EverythingLibrary#Everything_GetNumFolderResults}<br>
     * {@link EverythingLibrary#Everything_GetNumResults}<br>
     * {@link EverythingLibrary#Everything_GetTotFileResults}<br>
     * {@link EverythingLibrary#Everything_GetTotFolderResults}<br>
     * {@link EverythingLibrary#Everything_GetTotResults}<br>
     * {@link EverythingLibrary#Everything_IsVolumeResult}<br>
     * {@link EverythingLibrary#Everything_IsFolderResult}<br>
     * {@link EverythingLibrary#Everything_IsFileResult}<br>
     * {@link EverythingLibrary#Everything_GetResultFileNameW}<br>
     * {@link EverythingLibrary#Everything_GetResultPathW}<br>
     * {@link EverythingLibrary#Everything_GetResultFullPathNameW}<br>
     */
    boolean Everything_IsQueryReply(WinDef.UINT message, WinDef.WPARAM wParam, WinDef.LPARAM lParam, WinDef.DWORD nId);

    /**
     * Everything_IsVolumeResult 函数确定可见结果是否为卷的根文件夹。<br>
     * 您只能为可见的结果调用此函数。要确定结果是否可见，请使用 {@link EverythingLibrary#Everything_GetNumFileResults} 函数。
     *
     * @param nIndex 可见结果的从零开始的索引.
     * @return 如果可见结果是卷（例如：C：）.<br>
     * 如果可见结果是文件夹或文件（例如：C：\ABC.123），则函数返回 FALSE.<br>
     * 如果函数失败，则返回值为 FALSE。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}.<br>
     */
    boolean Everything_IsVolumeResult(int nIndex);

    /**
     * Everything_QueryW 函数使用当前搜索状态执行 Everything IPC 查询。<br>
     * 如果 bWait 为 FALSE，则调用 Everything_QueryW 前必须先调用 {@link EverythingLibrary#Everything_SetReplyWindow} 。<br>
     * 使用 {@link EverythingLibrary#Everything_IsQueryReply} 函数检查查询回复。<br>
     * （可选）调用以下函数以在调用 Everything_QueryW 之前设置搜索状态:<br>
     * {@link EverythingLibrary#Everything_SetSearchW}<br>
     * {@link EverythingLibrary#Everything_SetMatchPath}<br>
     * {@link EverythingLibrary#Everything_SetMatchCase}<br>
     * {@link EverythingLibrary#Everything_SetMatchWholeWord}<br>
     * {@link EverythingLibrary#Everything_SetRegex}<br>
     * {@link EverythingLibrary#Everything_SetMax}<br>
     * {@link EverythingLibrary#Everything_SetOffset}<br>
     * {@link EverythingLibrary#Everything_SetReplyID}<br>
     * {@link EverythingLibrary#Everything_SetRequestFlags}<br>
     * 您可以将 ANSI / Unicode 版本的 {@link EverythingLibrary#Everything_SetSearchW} 和 Everything_Query 混合使用.<br>
     * Everything_Query的 ANSI / Unicode 版本必须与 Everything_GetResultName 和 {@link EverythingLibrary#Everything_GetResultPathW} 的 ANSI / Unicode 版本匹配.<br>
     * 搜索状态不会从对 Everything_Query 的调用进行修改.<br>
     * 默认状态如下:<br>
     * 请参阅 {@link EverythingLibrary#Everything_Reset} 了解默认搜索状态.
     *
     * @param bWait 函数应该等待结果还是立即返回.<br>
     *              将此设置为 FALSE 以发布 IPC 查询并立即返回.<br>
     *              将此设置为 TRUE 以发送 IPC 查询并等待结果.
     * @return 如果函数成功，则返回值为 TRUE。<br>
     * 如果函数失败，则返回值为 FALSE。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}
     */
    boolean Everything_QueryW(boolean bWait);

    /**
     * Everything_RebuildDB 函数请求 Everything 强制重建 Everything 索引。
     *
     * @return 如果强制重建 Everything 索引的请求成功，则该函数返回非零值。<br>
     * 如果发生错误，该函数返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}
     */
    boolean Everything_RebuildDB();

    /**
     * Everything_Reset 函数将结果列表和搜索状态重置为默认状态，从而释放库分配的任何内存。<br>
     * 调用 {@link EverythingLibrary#Everything_SetSearchW} 将释放旧搜索并分配新的搜索字符串。<br>
     * 调用 {@link EverythingLibrary#Everything_QueryW} 将释放旧的结果列表并分配新的结果列表。<br>
     * 调用 Everything_Reset 将释放当前搜索和当前结果列表。<br>
     * 默认状态：<br>
     * Everything_SetSearch("");<br>
     * Everything_SetMatchPath(FALSE);<br>
     * Everything_SetMatchCase(FALSE);<br>
     * Everything_SetMatchWholeWord(FALSE);<br>
     * Everything_SetRegex(FALSE);<br>
     * Everything_SetMax(0xFFFFFFFF);<br>
     * Everything_SetOffset(0);<br>
     * Everything_SetReplyWindow(0);<br>
     * Everything_SetReplyID(0);<br>
     */
    void Everything_Reset();

    /**
     * Everything_SaveDB 函数请求 Everything 将索引保存到磁盘。<br>
     * 索引仅在您退出 Everything 时保存到磁盘。<br>
     * 调用 Everything_SaveDB 将索引写入文件：Everything.db
     *
     * @return 如果将 Everything 索引保存到磁盘的请求成功，则该函数返回非零。<br>
     * 如果发生错误，该函数返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}
     */
    boolean Everything_SaveDB();

    /**
     * Everything_SaveRunHistory 函数请求 Everything 将运行历史记录保存到磁盘。<br>
     * 仅当关闭 Everything 搜索窗口或退出 Everything 时，运行历史记录才会保存到磁盘。<br>
     * 调用 Everything_SaveRunHistory 将运行历史记录写入文件：Run History.csv
     *
     * @return 如果将运行历史记录保存到磁盘的请求成功，则该函数返回非零值。<br>
     * 如果发生错误，该函数返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}
     */
    boolean Everything_SaveRunHistory();

    /**
     * Everything_SetMatchCase 函数启用或禁用下次调用 {@link EverythingLibrary#Everything_QueryW} 的完整路径匹配。(默认情况下，Match case 处于禁用状态。)
     *
     * @param bEnable 指定搜索是区分大小写还是不区分大小写。<br>
     *                如果此参数为 TRUE，则搜索区分大小写。<br>
     *                如果参数为 FALSE，则搜索不区分大小写。
     */
    void Everything_SetMatchCase(boolean bEnable);

    /**
     * Everything_SetMatchPath 函数启用或禁用对 {@link EverythingLibrary#Everything_QueryW} 的下一次调用的完整路径匹配。<br>
     * 如果启用了匹配完整路径，则下次调用 {@link EverythingLibrary#Everything_QueryW} 将搜索每个文件和文件夹的完整路径和文件名。<br>
     * 如果禁用了匹配完整路径，则下次调用 {@link EverythingLibrary#Everything_QueryW} 将仅搜索每个文件和文件夹的文件名。<br>
     * 默认情况下，匹配路径处于禁用状态。<br>
     * 启用匹配路径将显著影响性能。
     *
     * @param bEnable 指定是启用还是禁用完整路径匹配。<br>
     *                如果此参数为 TRUE，则启用完整路径匹配。<br>
     *                如果该参数为 FALSE，则禁用完整路径匹配。
     */
    void Everything_SetMatchPath(boolean bEnable);

    /**
     * Everything_SetMatchWholeWord 函数启用或禁用下次调用 {@link EverythingLibrary#Everything_QueryW} 的全字匹配。<br>
     * 默认情况下，全字匹配处于禁用状态。
     *
     * @param bEnable 指定搜索是匹配整个单词，还是可以匹配任何位置。<br>
     *                如果此参数为 TRUE，则搜索仅匹配整个单词。<br>
     *                如果参数为 FALSE，则搜索可以在任何位置进行。
     */
    void Everything_SetMatchWholeWord(boolean bEnable);

    /**
     * Everything_SetMax 函数设置从 {@link EverythingLibrary#Everything_QueryW} 返回的最大结果数。<br>
     * 默认的最大结果数为 0xffffffff （所有结果）。<br>
     * 如果要在窗口中显示结果，请将最大结果数设置为窗口中可见项目数。<br>
     *
     * @param dwMaxResults 指定要返回的最大结果数。<br>
     *                     将此项设置为 0xffffffff 将返回所有结果。
     */
    void Everything_SetMax(WinDef.DWORD dwMaxResults);

    /**
     * Everything_SetOffset 函数设置从对 {@link EverythingLibrary#Everything_QueryW} 的调用返回的第一个结果偏移量.<br>
     * 默认偏移量为 0（第一个可用结果）.<br>
     * 如果要在具有自定义滚动条的窗口中显示结果，请将偏移量设置为垂直滚动条位置.<br>
     * 使用搜索窗口可以减少通过 IPC 发送的数据量，并显著提高搜索性能.
     *
     * @param dwOffset 指定可用结果的第一个结果。<br>
     *                 将此项设置为 0 将返回第一个可用结果。
     */
    void Everything_SetOffset(WinDef.DWORD dwOffset);

    /**
     * Everything_SetRegex 功能启用或禁用正则表达式搜索。(默认情况下，Regex 处于禁用状态。)
     *
     * @param bEnable 设置为非零以启用正则表达式，设置为 0 以禁用正则表达式。
     */
    void Everything_SetRegex(boolean bEnable);

    /**
     * Everything_SetReplyID 函数设置唯一编号以标识下一个查询。
     * 默认标识符为 0.<br>
     * 设置 IPC 查询的唯一标识符.<br>
     * 如果要发布具有相同窗口句柄的多个搜索查询，则必须调用 Everything_SetReplyID 函数为每个查询分配一个唯一标识符。<br>
     * nID 值是 WM_COPYDATA 回复消息中使用的 COPYDATASTRUCT 中的 dwData 成员.<br>
     * 如果在 bWait 设置为 true 的情况下调用 {@link EverythingLibrary#Everything_QueryW}，则不需要此函数.
     *
     * @param nId 用于标识下一个查询的唯一编号.
     */
    void Everything_SetReplyID(WinDef.DWORD nId);

    /**
     * Everything_SetReplyWindow 函数设置将接收 IPC 查询结果的窗口.<br>
     * 在调用 {@link EverythingLibrary#Everything_QueryW} 并将 bWait 设置为 FALSE 之前，必须调用此函数.<br>
     * 使用 {@link EverythingLibrary#Everything_IsQueryReply} 检查指定窗口的结果.<br>
     * 使用唯一标识符调用 {@link EverythingLibrary#Everything_SetReplyID} 以指定多个搜索.
     *
     * @param hWnd 将接收 IPC 查询回复的窗口的句柄.
     */
    void Everything_SetReplyWindow(WinDef.HWND hWnd);

    /**
     * Everything_SetRequestFlags 函数设置所需的结果数据。<br>
     * 确保包含 EVERYTHING_REQUEST_FILE_NAME 和 EVERYTHING_REQUEST_PATH 如果要返回结果文件名信息。<br>
     * 默认请求标志为 EVERYTHING_REQUEST_FILE_NAME |EVERYTHING_REQUEST_PATH （0x00000003）。<br>
     * 当默认标志 （EVERYTHING_REQUEST_FILE_NAME |EVERYTHING_REQUEST_PATH） 的查询，SDK 将使用旧版本 1 查询。<br>
     * 使用任何其他标志时，将首先尝试新版本 2 查询，然后回退到版本 1 查询。<br>
     * 请求的数据可能不可用，在这种情况下，在收到结果后，您应该致电 {@link EverythingLibrary#Everything_GetResultListRequestFlags} 以确定可用的结果数据。<br>
     * 此函数必须在 {@link EverythingLibrary#Everything_QueryW} 之前调用。
     *
     * @param dwRequestFlags 请求标志可以是EVERYTHING_REQUEST常量标志中的零个或多个。
     * @see EverythingRequestCode
     */
    void Everything_SetRequestFlags(WinDef.DWORD dwRequestFlags);

    /**
     * Everything_SetRunCountFromFileName 函数按文件名设置 Everything 索引中指定文件的运行计数.<br>
     * 将运行计数设置为 0 以删除指定文件的任何运行历史记录信息.<br>
     * 该文件不必存在。创建文件后，它将具有正确的运行历史记录.<br>
     * 在文件删除和创建之间保留运行历史记录信息.<br>
     * 调用此函数会将指定文件的运行日期更新为当前时间.
     *
     * @param lpFileName 指向以 null 结尾的字符串的指针，该字符串在 Everything 索引中指定完全限定的文件名.
     * @param dwRunCount 新的运行计数.
     * @return 如果成功，该函数将返回非零值.<br>
     * 如果发生错误，该函数将返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}
     */
    boolean Everything_SetRunCountFromFileName(WString lpFileName, WinDef.DWORD dwRunCount);

    /**
     * Everything_SetSearch 函数设置 IPC 查询的搜索字符串.<br>
     * （可选）在调用 {@link EverythingLibrary#Everything_QueryW} 之前调用此函数<br>
     * {@link EverythingLibrary#Everything_QueryW} 将使用此搜索字符串执行 IPC 查询.
     *
     * @param lpSearchString 指向要用作新搜索文本的以 null 结尾的字符串的指针.
     */
    void Everything_SetSearchW(WString lpSearchString);

    /**
     * Everything_SetSort 函数设置结果的排序方式。<br>
     * 默认排序为 EVERYTHING_SORT_NAME_ASCENDING （1）。这种方式是免费的。<br>
     * 建议使用快速排序，快速排序是即时的。<br>
     * 要在 Everything 中启用快速排序：<br>
     * 在 Everything 中，从 Tools 菜单中，单击 Options。<br>
     * 单击 Indexes 选项卡。<br>
     * 检查 fast sort 以获得所需的快速排序类型。<br>
     * 单击确定。<br>
     * 可能不支持排序，在这种情况下，在收到结果后，您应该调用 {@link EverythingLibrary#Everything_GetResultListSort} 来确定实际使用的排序。<br>
     * 此函数必须在 {@link EverythingLibrary#Everything_QueryW} 之前调用。
     *
     * @param dwSortType 排序类型值之一
     * @see EverythingSortCode
     */
    void Everything_SetSort(WinDef.DWORD dwSortType);

    /**
     * Everything_SortResultsByPath 函数先按路径排序，然后按文件名对当前结果进行排序。<br>
     * Everything_SortResultsByPath 是 CPU 密集型的。按路径排序可能需要几秒钟。<br>
     * 默认结果列表不包含任何结果。<br>
     * 在调用 Everything_SortResultsByPath 之前调用 {@link EverythingLibrary#Everything_QueryW} 以检索结果列表。<br>
     * 为了提高性能，请使用 {@link EverythingLibrary#Everything_SetSort}
     */
    void Everything_SortResultsByPath();

    /**
     * Everything_UpdateAllFolderIndexes 函数请求 Everything 重新扫描所有文件夹索引。<br>
     * 一切都将在后台开始更新所有文件夹索引。
     *
     * @return 如果重新扫描所有文件夹索引的请求成功，则该函数返回非零值。<br>
     * 如果发生错误，该函数返回 0。要获取扩展错误信息，请调用 {@link EverythingLibrary#Everything_GetLastError}
     */
    boolean Everything_UpdateAllFolderIndexes();
}
