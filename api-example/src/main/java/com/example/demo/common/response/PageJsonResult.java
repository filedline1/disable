package com.example.demo.common.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页
 *
 * @author Chunming Liu In 2022/07/28
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageJsonResult<T> extends JsonResult<T> {
    private static final long serialVersionUID = 1L;
    /**
     * 页码
     */
    private Long pageIndex;
    /**
     * 页大小
     */
    private Long pageSize;
    /**
     * 总数量
     */
    private Long total;

    public PageJsonResult(long pageIndex, long pageSize, Long total, T data) {
        super ( 200, data );
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
    }

    public static <T> PageJsonResult<T> success(long pageIndex, long pageSize, Long total, T data) {
        return new PageJsonResult<> ( pageIndex, pageSize, total, data );
    }
}
