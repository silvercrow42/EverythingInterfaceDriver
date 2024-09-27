package org.joker.everything.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.joker.everything.http.EverythingDateReader;

/**
 * @auther joker
 * @date 2024/9/26 15:13
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class EverythingResult {
    private String type;
    private String name;
    private String path;
    private String size;
    @JSONField(name = "date_modified", deserializeUsing = EverythingDateReader.class)
    private String dateModified;
}
