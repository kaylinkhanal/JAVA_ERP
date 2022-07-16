package com.laconic.cb.controller;

import com.laconic.cb.model.Title;
import com.laconic.cb.service.ITitleService;
import com.laconic.cb.utils.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.laconic.cb.constants.AppConstants.DEFAULT_PAGE_NUMBER;

@Controller
@RequestMapping("/title/")
public class TitleController {
    private final ITitleService titleService;

    public TitleController(ITitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping("/create")
    public String createTitle(@RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                              ModelMap modelMap) {
        Page<Title> titlePage = titleService.getAllTitles(pageNo);
        List<Title> titleList = titlePage.getContent().stream().collect(Collectors.toList());
        long totalTitles = titleService.getTotalTitles();
        Pagination.getPagination(modelMap, titlePage, totalTitles, titleList, "/title/createTitle");
        return "title/createTitle";
    }

    @GetMapping("/editTitle/{id}")
    public String editTitle(@PathVariable("id") Long id, Model model) {
        Optional<Title> title = titleService.findById(id);
        if (title.isPresent()) {
            model.addAttribute("title", title.get());
        }
        return "title/createTitle";
    }

    @PostMapping("/addTitle")
    public String addTitle(Title title, RedirectAttributes redirectAttributes) {
        Title savedTitle;
        if (title.getTitleId() != null) {
            savedTitle = titleService.updateTitle(title);
        } else savedTitle = titleService.saveTitle(title);
        redirectAttributes.addFlashAttribute("title", savedTitle);
        return "redirect:/title/create";
    }

    @GetMapping("/titleList")
    @ResponseBody
    public List<Title> titleList() {
        List<Title> titleList = titleService.getAllTitles();
        return titleList;
    }
}
