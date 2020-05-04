package com.example.demo.controller;

import com.example.demo.dto.PageInfoDTO;
import com.example.demo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {

    @Autowired
    private PublishService publishService;

    @GetMapping("/")
    public String getIndex(Model model,
                           @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){

        PageInfoDTO pageInfoDTO = publishService.selectAll(pageNumber, pageSize);
        model.addAttribute("pageInfoDTO", pageInfoDTO);
        return "index";
    }
}
