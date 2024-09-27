package org.joker.everything.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @auther joker
 * @date 2024/9/26 14:53
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class EverythingResponse {
    private int totalResults;

    private List<EverythingResult> results;

}
