package org.joker.everything.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joker.everything.http.EverythingBooleanWriter;
import org.joker.everything.http.EverythingSortType;

/**
 * @auther joker
 * @date 2024/9/26 11:08
 */
@Getter
@Setter
@Accessors(chain = true)
public class EverythingRequest {
    /**
     * 搜索文本(s,q,search)
     */
    @JSONField(name = "s")
    private String search = "";
    /**
     * 显示第 nth 个结果(o,offset)
     */
    @JSONField(name = "o")
    private int offset = 0;
    /**
     * 返回不超过设定值的结果数(c,count)
     */
    @JSONField(name = "c")
    private int count = 100;
    /**
     * 数值非零时返回结果为 json 对象(j,json)
     */
    @JSONField(name = "j", serializeUsing = EverythingBooleanWriter.class)
    private boolean json = true;
    /**
     * 数值非零时匹配大小写(i,case)
     */
    @JSONField(name = "i", serializeUsing = EverythingBooleanWriter.class)
    private boolean caseSensitive = false;
    /**
     * 数值非零时匹配全字(w,wholeword)
     */
    @JSONField(name = "w", serializeUsing = EverythingBooleanWriter.class)
    private boolean wholeWord = false;
    /**
     * 数值非零时匹配路径(p,path)
     */
    @JSONField(name = "p", serializeUsing = EverythingBooleanWriter.class)
    private boolean path = false;
    /**
     * 数值非零时执行正则搜索(r,regex)
     */
    @JSONField(name = "r", serializeUsing = EverythingBooleanWriter.class)
    private boolean regex = false;
    /**
     * 数值非零时匹配变音标记(m,diacritics)
     */
    @JSONField(name = "m", serializeUsing = EverythingBooleanWriter.class)
    private boolean diacritics = false;
    /**
     * 数值非零时列举结果路径为 json 对象(path_column)
     */
    @JSONField(name = "path_column", serializeUsing = EverythingBooleanWriter.class)
    private boolean pathColumn = true;
    /**
     * 数值非零时列举结果大小为 json 对象(size_column)
     */
    @JSONField(name = "size_column", serializeUsing = EverythingBooleanWriter.class)
    private boolean sizeColumn = true;
    /**
     * 数值非零时列举结果修改日期为 json 对象(date_modified_column)
     */
    @JSONField(name = "date_modified_column", serializeUsing = EverythingBooleanWriter.class)
    private boolean dateModifiedColumn = true;
    /**
     * 数值非零时列举结果创建日期为 json 对象(date_created_column)
     */
    @JSONField(name = "date_created_column", serializeUsing = EverythingBooleanWriter.class)
    private boolean dateCreatedColumn = true;
    /**
     * 数值非零时列举结果属性为 json 对象(attributes_column)
     */
    @JSONField(name = "attributes_column", serializeUsing = EverythingBooleanWriter.class)
    private boolean attributesColumn = true;
    /**
     * 排序值可以为以下任一项：
     * name(按名称排序。
     * path	按路径排序。
     * date_modified	按修改日期排序。
     * size	按大小排序。
     */
    @JSONField(name = "sort")
    private EverythingSortType sort = EverythingSortType.NAME;
    /**
     * 数值非零时升序排列
     */
    @JSONField(name = "ascending", serializeUsing = EverythingBooleanWriter.class)
    private boolean ascending = true;
}
