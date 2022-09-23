package com.java18.nikolaos.used.model.util;


import java.util.Map;
import com.java18.nikolaos.used.model.util.PageInfo.Sort.Direction;
import org.springframework.util.StringUtils;

public class PageInfo {

    // 每頁顯示的數量
    private Integer limit;

    // 當前頁數
    private Integer currentPage;

    // 排序方式
    private Sort sort;

    public PageInfo(Integer limit, Integer currentPage) {
        this.limit = (limit != null) ? limit : Const.DEFAULT_PAGE_SIZE;
        this.currentPage = (currentPage != null) ? currentPage : Const.FIRST_PAGE_NUM;
        // check the value and use the default setting
    }

    public PageInfo(Integer limit, Integer currentPage, Sort sort) {
        this.limit = (limit != null) ? limit : Const.DEFAULT_PAGE_SIZE;
        this.currentPage = (currentPage != null) ? currentPage : Const.FIRST_PAGE_NUM;
        // check the value and use the default setting
        this.sort = sort;
    }

    public PageInfo(Map<String, Object> map) {
        String pageSize = String.valueOf(map.get(Const.PAGE_SIZE));
        String pageNum = String.valueOf(map.get(Const.PAGE_NUM));

        this.limit = (pageSize != null) ? Integer.valueOf(pageSize) : Const.DEFAULT_PAGE_SIZE;
        this.currentPage = (pageNum != null) ? Integer.valueOf(pageNum) : Const.FIRST_PAGE_NUM;
        // check the value and use the default setting

        if (hasSortInfo(map)) {
            String[] columnNames = String.valueOf(map.get(Const.ORDER_COLUMNS)).split(",");
            String direction = String.valueOf(map.get(Const.ORDER_DIRECTION));
            if (Direction.ASC.toString().equalsIgnoreCase(direction)) {
                this.sort = new Sort(Direction.ASC, columnNames);
            } else if (Direction.DESC.toString().equalsIgnoreCase(direction)) {
                this.sort = new Sort(Direction.DESC, columnNames);
            }
        }

    }

    private boolean hasSortInfo(Map<String,Object> map) {
        if(map.get(Const.ORDER_COLUMNS)!= null && map.get(Const.ORDER_DIRECTION)!= null){
            if(StringUtils.hasText(String.valueOf(map.get(Const.ORDER_COLUMNS))) &&
                    StringUtils.hasText(String.valueOf(map.get(Const.ORDER_DIRECTION)))) {
                return true;
            }
        }
        return false;
    }

    // for calling
    public boolean hasSortInfo() {
        return this.sort != null;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    //
    public static class Sort {

        // Sorting direction
        private Direction direction;

        // column Names
        private String[] columnNames;

        public Sort(Direction direction, String[] columnNames) {
            this.direction = direction;
            this.columnNames = columnNames;
        }

        public Direction getDirection() {

            return direction;

        }

        public String[] getColumeNames() {
            return columnNames;
        }

        public static enum Direction {
            ASC, DESC
        }
    }
}
