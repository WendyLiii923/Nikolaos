package com.java18.nikolaos.used.model.util;

import java.util.List;

public class Page<T>{

    // 每頁顯示的數量
    private Integer limit;

    // 當前頁數
    private Integer currentPage;

    // 總頁數
    private Integer totalPages;

    //該項目總數量
    private Integer totalElement;


    //該項目當前頁數的 list
    private List<T> data;

    public Page(List<T> data,Integer currentPage, Integer limit, long totalElement) {
        this.limit = limit;
        this.currentPage = currentPage;
        this.totalPages = (int) Math.ceil(((double) totalElement)/limit);
        this.totalElement = (int)totalElement;
        this.data = data;
    }

    public Page() {

    }

    public void setPageInfo(PageInfo pageInfo) {
        this.limit = pageInfo.getLimit();
        this.currentPage = pageInfo.getCurrentPage();
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

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(Integer totalElement) {
        this.totalElement = totalElement;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean getIsFirstPage() {
        return this.currentPage == 1;
    }

    public boolean getIsLastPage() {
        return this.currentPage == this.totalPages;
    }

    public boolean getIsHasNext() {
        return this.currentPage < this.totalPages;
    }
}
