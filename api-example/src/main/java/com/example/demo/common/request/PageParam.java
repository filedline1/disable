package com.example.demo.common.request;

import lombok.Data;

/**
 * @author Chunming Liu In 2022/07/28
 */
@Data
public class PageParam<T> {
    /**
     * 页码
     */
    private Long pageIndex;
    /**
     * 页大小
     */
    private Long pageSize;
    /**
     * 搜索条件
     */
    private T paramDTO;
}
