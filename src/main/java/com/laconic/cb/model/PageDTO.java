package com.laconic.cb.model;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageDTO {
    private int pageCount;
    private boolean isFirstPage;
    private boolean isLastPage;
    private int currentPage;
    private int lastPageNo;
    private int page;
    private String pageUrl;
    private List<?> objects;

    public int getPageCount() {
        return pageCount;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getLastPageNo() {
        return lastPageNo;
    }

    public int getPage() {
        return page;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public List<?> getObjects() {
        return objects;
    }
}
