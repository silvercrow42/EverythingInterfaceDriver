package org.joker.everything.ddl;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.Getter;
import org.joker.everything.ddl.constant.EverythingRequestCode;
import org.joker.everything.ddl.constant.EverythingSortCode;
import org.joker.everything.entity.EverythingRequest;
import org.joker.everything.entity.EverythingResponse;
import org.joker.everything.entity.EverythingResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @auther joker
 * @date 2024/9/26 22:15
 */
@Getter
public class EverythingDllFinder extends EverythingDllErrorCatcher {
    private static final Logger logger = LoggerFactory.getLogger(EverythingDllFinder.class);

    public EverythingDllFinder() {
        this("");
    }

    public EverythingDllFinder(String dllRootPath) {
        super(dllRootPath);
    }

    private static final Cache<String, EverythingLibrary> cache = CacheUtil.newWeakCache(60);


    /**
     * @see EverythingLibrary#Everything_GetBuildNumber()
     */
    public int getBuildNumber() {
        return instance.Everything_GetBuildNumber().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetLastError()
     */
    private int getLastError() {
        return instance.Everything_GetLastError().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetMajorVersion()
     */
    public int getMajorVersion() {
        return instance.Everything_GetMajorVersion().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetMatchCase()
     */
    public boolean getMatchCase() {
        return instance.Everything_GetMatchCase();
    }

    /**
     * @see EverythingLibrary#Everything_GetMatchPath()
     */
    public boolean getMatchPath() {
        return instance.Everything_GetMatchPath();
    }

    /**
     * @see EverythingLibrary#Everything_GetMatchWholeWord()
     */
    public boolean getMatchWholeWord() {
        return instance.Everything_GetMatchWholeWord();
    }

    /**
     * @see EverythingLibrary#Everything_GetMax()
     */
    public int getMax() {
        return instance.Everything_GetMax().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetMinorVersion()
     */
    public int getMinorVersion() {
        return instance.Everything_GetMinorVersion().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetNumFileResults()
     */
    public int getNumFileResults() {
        return instance.Everything_GetNumFileResults().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetNumFolderResults()
     */
    public int getNumFolderResults() {
        return instance.Everything_GetNumFolderResults().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetNumResults()
     */
    public int getNumResults() {
        return instance.Everything_GetNumResults().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetIntNumResults()
     */
    public int getIntNumResults() {
        return instance.Everything_GetIntNumResults();
    }

    /**
     * @see EverythingLibrary#Everything_GetOffset()
     */
    public int getOffset() {
        return instance.Everything_GetOffset().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetRegex()
     */
    public boolean getRegex() {
        return instance.Everything_GetRegex();
    }

    /**
     * @see EverythingLibrary#Everything_GetReplyID()
     */
    public int getReplyID() {
        return instance.Everything_GetReplyID().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetRequestFlags()
     */
    public int getRequestFlags() {
        return instance.Everything_GetRequestFlags().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultAttributes(WinDef.DWORD dwIndex)
     */
    public int getResultAttributes(int index) {
        return instance.Everything_GetResultAttributes(new WinDef.DWORD(index)).intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultDateAccessed(WinDef.DWORD dwIndex, WinBase.FILETIME pFileTime)
     */
    public Date getResultDateAccessed(int index) {
        WinBase.FILETIME filetime = new WinBase.FILETIME();
        instance.Everything_GetResultDateAccessed(new WinDef.DWORD(index), filetime);
        return filetime.toDate();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultDateCreated(WinDef.DWORD dwIndex, WinBase.FILETIME pFileTime)
     */
    public Date getResultDateCreated(int index) {
        WinBase.FILETIME filetime = new WinBase.FILETIME();
        instance.Everything_GetResultDateCreated(new WinDef.DWORD(index), filetime);
        return filetime.toDate();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultDateModified(WinDef.DWORD dwIndex, WinBase.FILETIME pFileTime)
     */
    public Date getResultDateModified(int index) {
        WinBase.FILETIME filetime = new WinBase.FILETIME();
        instance.Everything_GetResultDateModified(new WinDef.DWORD(index), filetime);
        return filetime.toDate();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultDateRecentlyChanged(WinDef.DWORD dwIndex, WinBase.FILETIME pFileTime)
     */
    public Date getResultDateRecentlyChanged(int index) {
        WinBase.FILETIME filetime = new WinBase.FILETIME();
        instance.Everything_GetResultDateRecentlyChanged(new WinDef.DWORD(index), filetime);
        return filetime.toDate();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultDateRun(WinDef.DWORD dwIndex, WinBase.FILETIME pFileTime)
     */
    public Date getResultDateRun(int index) {
        WinBase.FILETIME filetime = new WinBase.FILETIME();
        instance.Everything_GetResultDateRun(new WinDef.DWORD(index), filetime);
        return filetime.toDate();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultExtensionW(WinDef.DWORD dwIndex)
     */
    public String getResultExtension(int index) {
        return instance.Everything_GetResultExtensionW(new WinDef.DWORD(index)).toString();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultFileListFileNameW(WinDef.DWORD dwIndex)
     */
    public String getResultFileListFileName(int index) {
        return instance.Everything_GetResultFileListFileNameW(new WinDef.DWORD(index)).toString();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultFileNameW(WinDef.DWORD dwIndex)
     */
    public String getResultFileName(int index) {
        return instance.Everything_GetResultFileNameW(new WinDef.DWORD(index)).toString();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultFullPathNameW(WinDef.DWORD dwIndex, char[] lpString, WinDef.DWORD nMaxCount)
     */
    public String getResultFullPathName(int index) {
        char[] lpString = new char[1024];
        instance.Everything_GetResultFullPathNameW(new WinDef.DWORD(index), lpString, new WinDef.DWORD(1024));
        return new String(lpString);
    }

    /**
     * @see EverythingLibrary#Everything_GetResultHighlightedFileNameW(int dwIndex)
     */
    public String getResultHighlightedFileName(int index) {
        return instance.Everything_GetResultHighlightedFileNameW(index).toString();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultHighlightedFullPathAndFileNameW(int dwIndex)
     */
    public String getResultHighlightedFullPathAndFileName(int index) {
        return instance.Everything_GetResultHighlightedFullPathAndFileNameW(index).toString();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultHighlightedPathW(int dwIndex)
     */
    public String getResultHighlightedPath(int index) {
        return instance.Everything_GetResultHighlightedPathW(index).toString();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultListRequestFlags()
     */
    public int getResultListRequestFlags() {
        return instance.Everything_GetResultListRequestFlags().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultListSort()
     */
    public int getResultListSort() {
        return instance.Everything_GetResultListSort().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultPathW(int dwIndex)
     */
    public String getResultPath(int index) {
        return instance.Everything_GetResultPathW(index).toString();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultRunCount(WinDef.DWORD dwIndex)
     */
    public int getResultRunCount(int index) {
        return instance.Everything_GetResultRunCount(new WinDef.DWORD(index)).intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetResultSize(WinDef.DWORD dwIndex, WinDef.LONGByReference pSize)
     */
    public String getResultSize(int index) {
        WinDef.LONGByReference size = new WinDef.LONGByReference();
        instance.Everything_GetResultSize(new WinDef.DWORD(index), size);
        return size.getValue().toString();
    }

    /**
     * @see EverythingLibrary#Everything_GetRevision()
     */
    public int getRevision() {
        return instance.Everything_GetRevision().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetRunCountFromFileName(WString lpFileName)
     */
    public int getRunCountFromFileName(String lpFileName) {
        return instance.Everything_GetRunCountFromFileName(new WString(lpFileName)).intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetSearchW()
     */
    public String getSearch() {
        return instance.Everything_GetSearchW().toString();
    }

    /**
     * @see EverythingLibrary#Everything_GetSort()
     */
    public int getSort() {
        return instance.Everything_GetSort().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetTargetMachine()
     */
    public int getTargetMachine() {
        return instance.Everything_GetTargetMachine().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetTotFileResults()
     */
    public int getTotFileResults() {
        return instance.Everything_GetTotFileResults().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetTotFolderResults()
     */
    public int getTotFolderResults() {
        return instance.Everything_GetTotFolderResults().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_GetTotResults()
     */
    public int getTotResults() {
        return instance.Everything_GetTotResults().intValue();
    }

    /**
     * @see EverythingLibrary#Everything_IncRunCountFromFileName(WString lpFileName)
     */
    public int incRunCountFromFileName(String lpFileName) {
        return instance.Everything_IncRunCountFromFileName(new WString(lpFileName)).intValue();
    }

    /**
     * @see EverythingLibrary#Everything_IsAdmin()
     */
    public boolean isAdmin() {
        return instance.Everything_IsAdmin();
    }

    /**
     * @see EverythingLibrary#Everything_IsAppData()
     */
    public boolean isAppData() {
        return instance.Everything_IsAppData();
    }

    /**
     * @see EverythingLibrary#Everything_IsDBLoaded()
     */
    public boolean isDBLoaded() {
        return instance.Everything_IsDBLoaded();
    }

    /**
     * @see EverythingLibrary#Everything_IsFileResult(WinDef.DWORD dwIndex)
     */
    public boolean isFileResult(int index) {
        return instance.Everything_IsFileResult(new WinDef.DWORD(index));
    }

    /**
     * @see EverythingLibrary#Everything_IsFolderResult(WinDef.DWORD dwIndex)
     */
    public boolean isFolderResult(int index) {
        return instance.Everything_IsFolderResult(new WinDef.DWORD(index));
    }

    /**
     * @see EverythingLibrary#Everything_IsQueryReply(WinDef.UINT message, WinDef.WPARAM wParam, WinDef.LPARAM lParam, WinDef.DWORD nId)
     */
    public boolean isQueryReply(long message, long wParam, long lParam, long nId) {
        return instance.Everything_IsQueryReply(new WinDef.UINT(message), new WinDef.WPARAM(wParam), new WinDef.LPARAM(lParam), new WinDef.DWORD(nId));
    }

    /**
     * @see EverythingLibrary#Everything_IsVolumeResult(int nIndex)
     */
    public boolean isVolumeResult(int nIndex) {
        return instance.Everything_IsVolumeResult(nIndex);
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_QueryW(boolean bWait)
     */
    public EverythingDllFinder query(boolean bWait) {
        doWithThrow(() -> instance.Everything_QueryW(bWait), r -> r);
        return this;
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_Reset()
     */
    public EverythingDllFinder reset() {
        instance.Everything_Reset();
        return this;
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_SetMatchCase(boolean b)
     */
    public EverythingDllFinder setMatchCase(boolean b) {
        instance.Everything_SetMatchCase(b);
        return this;
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_SetMatchPath(boolean b)
     */
    public EverythingDllFinder setMatchPath(boolean b) {
        instance.Everything_SetMatchPath(b);
        return this;
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_SetMatchWholeWord(boolean b)
     */
    public EverythingDllFinder setMatchWholeWord(boolean b) {
        instance.Everything_SetMatchWholeWord(b);
        return this;
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_SetMax(WinDef.DWORD dwMax)
     */
    public EverythingDllFinder setMax(int nMax) {
        instance.Everything_SetMax(new WinDef.DWORD(nMax));
        return this;
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_SetOffset(WinDef.DWORD dwOffset)
     */
    public EverythingDllFinder setOffset(int nOffset) {
        instance.Everything_SetOffset(new WinDef.DWORD(nOffset));
        return this;
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_SetRegex(boolean b)
     */
    public EverythingDllFinder setRegex(boolean b) {
        instance.Everything_SetRegex(b);
        return this;
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_SetReplyID(WinDef.DWORD nId)
     */
    public EverythingDllFinder setReplyID(int nId) {
        instance.Everything_SetReplyID(new WinDef.DWORD(nId));
        return this;
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_SetRequestFlags(WinDef.DWORD dwFlags)
     */
    public EverythingDllFinder setRequestFlags(EverythingRequestCode... codes) {
        if (codes.length == 0) return null;
        int value = codes[0].getValue();
        for (int i = 1; i < codes.length; i++) {
            value |= codes[i].getValue();
        }
        instance.Everything_SetRequestFlags(new WinDef.DWORD(value));
        return this;
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_SetRunCountFromFileName(WString lpFileName, WinDef.DWORD nCount)
     */
    public EverythingDllFinder setRunCountFromFileName(String lpFileName, int nCount) {
        doWithThrow(() -> instance.Everything_SetRunCountFromFileName(new WString(lpFileName), new WinDef.DWORD(nCount)), r -> r);
        return this;
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_SetSearchW(WString lpSearchString)
     */
    public EverythingDllFinder setSearch(String lpSearchString) {
        instance.Everything_SetSearchW(new WString(lpSearchString));
        return this;
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_SetSort(WinDef.DWORD dwSort)
     */
    public EverythingDllFinder setSort(EverythingSortCode sortCode) {
        instance.Everything_SetSort(new WinDef.DWORD(sortCode.getValue()));
        return this;
    }

    /**
     * @return
     * @see EverythingLibrary#Everything_SortResultsByPath()
     */
    public EverythingDllFinder sortResultsByPath() {
        instance.Everything_SortResultsByPath();
        return this;
    }

    public synchronized <R> R query(Consumer<EverythingDllFinder> condSetter, Function<EverythingDllFinder, R> resBuilder) {
        logger.debug("request reset");
        this.reset();
        logger.debug("request set");
        condSetter.accept(this);
        logger.debug("request query");
        this.query(true);
        logger.debug("request result build");
        return resBuilder.apply(this);
    }

    public EverythingResponse query(EverythingRequest request) {
        return this.query(finder -> finder.setSearch(request.getSearch())
                        .setOffset(request.getOffset())
                        .setMax(request.getCount())
                        .setMatchCase(request.isCaseSensitive())
                        .setMatchWholeWord(request.isWholeWord()).setMatchPath(request.isPath())
                        .setRegex(request.isRegex())
                        .setSort(EverythingSortCode.parse(request.getSort(), request.isAscending()))
                        .setRequestFlags(EverythingRequestCode.EVERYTHING_REQUEST_FILE_NAME,
                                EverythingRequestCode.EVERYTHING_REQUEST_FILE_PATH,
                                EverythingRequestCode.EVERYTHING_REQUEST_FILE_SIZE,
                                EverythingRequestCode.EVERYTHING_REQUEST_FULL_PATH_AND_FILE_NAME,
                                EverythingRequestCode.EVERYTHING_REQUEST_FILE_DATE_MODIFIED),
                finder -> {
                    int num = getNumResults();
                    ArrayList<EverythingResult> everythingResults = new ArrayList<>(num);

                    for (int i = 0; i < num; i++) {
                        EverythingResult everythingResult = new EverythingResult();

                        // 获取文件名
                        everythingResult.setName(getResultFileName(i));

                        // 获取完整路径
                        everythingResult.setPath(getResultPath(i));

                        // 获取文件大小
                        everythingResult.setSize(getResultSize(i));

                        // 获取修改日期
                        everythingResult.setDateModified(String.valueOf(getResultDateModified(i).getTime()));

                        everythingResults.add(everythingResult);
                    }
                    return new EverythingResponse().setTotalResults(num).setResults(everythingResults);
                });
    }
}
