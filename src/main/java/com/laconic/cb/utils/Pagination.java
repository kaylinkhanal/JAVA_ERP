package com.laconic.cb.utils;

import com.laconic.cb.model.PageDTO;
import com.laconic.cb.model.Site;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;

import java.util.List;

public class Pagination {
    public static final int PAGE_SIZE = 2;

    public static void getPagination(ModelMap model, Page<?> page, long totalSites, List<?> objects, String pageUrl) {
        int lastPageNo;
        if (totalSites % PAGE_SIZE != 0)
            lastPageNo = (int)(totalSites / PAGE_SIZE) + 1; // get last page No (zero based)
        else
            lastPageNo = (int)(totalSites / PAGE_SIZE);
//        model.addAttribute("currentPage", page.getNumber());
//        model.addAttribute("isFirst", page.isFirst());
//        model.addAttribute("isLast", page.isLast());
//        model.addAttribute("lastPageNo", lastPageNo);

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
