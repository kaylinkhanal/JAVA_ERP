package com.laconic.cb.utils;

import com.laconic.cb.model.dto.PageDTO;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;

import java.util.List;

public class Pagination {
    public static final int PAGE_SIZE = 2;

    public static void getPagination(ModelMap model, Page<?> page, long totalCount, List<?> objects, String pageUrl) {
        int lastPageNo;
        if (totalCount % PAGE_SIZE != 0)
            lastPageNo = (int)(totalCount / PAGE_SIZE) + 1; // get last page No (zero based)
        else
            lastPageNo = (int)(totalCount / PAGE_SIZE);

        PageDTO pageDTO = PageDTO.builder()
                .currentPage(page.getNumber())
                .isFirstPage(page.isFirst())
                .isLastPage(page.isLast())
                .lastPageNo(lastPageNo)
                .objects(objects)
                .pageUrl(pageUrl)
                .build();
        model.put("page", pageDTO);
    }
}
