package com.tang.commons.utils.page;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.CaseFormat;

/**
 * 分页数据
 *
 * @author Tang
 */
public class PageDomain {

    private static final String ASC = "asc";

    private static final String DESC = "desc";

    private static final String ASCENDING = "ascending";

    private static final String DESCENDING = "descending";

    /**
     * 当前记录起始索引
     */
    private Integer pageNum;

    /**
     * 每页显示记录数
     */
    private Integer pageSize;

    /**
     * 排序列
     */
    private String orderByColumn;

    /**
     * 排序的方向desc或者asc
     */
    private String isAsc = ASC;

    /**
     * 分页参数合理化
     */
    private Boolean reasonable = true;

    public String getOrderBy() {
        if (StringUtils.isBlank(orderByColumn)) {
            return "";
        }
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, orderByColumn) + " " + isAsc;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    public String getIsAsc() {
        return isAsc;
    }

    public Boolean getIsAscBoolean() {
        return ASC.equals(isAsc);
    }

    public void setIsAsc(String isAsc) {
        if (StringUtils.isNoneBlank(isAsc)) {
            this.isAsc = switch (isAsc) {
                case ASCENDING -> ASC;
                case DESCENDING -> DESC;
                default -> isAsc;
            };
        }
    }

    public Boolean getReasonable() {
        if (Objects.isNull(reasonable)) {
            return Boolean.TRUE;
        }
        return reasonable;
    }

    public void setReasonable(Boolean reasonable) {
        this.reasonable = reasonable;
    }

}
