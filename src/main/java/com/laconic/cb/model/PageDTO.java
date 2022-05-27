package com.laconic.cb.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
public class PageDTO {
    private int pageCount;
    private boolean isFirstPage;
    private boolean isLastPage;
    private int currentPage;
    private int lastPageNo;
    private int page;
    private String pageUrl;
    private List<?> objects;
}
