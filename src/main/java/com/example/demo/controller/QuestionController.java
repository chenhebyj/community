package com.example.demo.controller;


import com.example.demo.dto.PublishDTO;
import com.example.demo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.WebParam;

@Controller
public class QuestionController {

    @Autowired
    private PublishService publishService;

    @GetMapping("/question/{id}")
    public String showQuestion(@PathVariable(name = "id") Integer id,
                               Model model){
        PublishDTO publishDTO = publishService.selByQuestionId(id);
        model.addAttribute("question", publishDTO);
        return "question";
    }


}
