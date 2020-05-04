package com.example.demo.controller;

import com.example.demo.dto.PageInfoDTO;
import com.example.demo.model.User;
import com.example.demo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private PublishService publishService;


    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          HttpServletRequest request,
                          Model model,
                          @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){

        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/";
        }


        if("publish".equals(action)){
            model.addAttribute("section", "publish");
            model.addAttribute("sectionName", "我的发布");
        }else if("reply".equals(action)){
            model.addAttribute("section", "reply");
            model.addAttribute("sectionName", "最新回复");
        }

        PageInfoDTO pageInfoDTO = publishService.selectByUserId(user, pageNumber, pageSize);
        model.addAttribute("pageInfoDTO", pageInfoDTO);
        return "profile";
    }
}
