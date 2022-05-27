package com.laconic.cb.model;

import lombok.Data;
import org.springframework.beans.support.PagedListHolder;

@Data
public class Pagination {
    private int pageCount;
    private boolean isFirstPage;
PagedListHolder pagedListHolder;
private int page;
}
