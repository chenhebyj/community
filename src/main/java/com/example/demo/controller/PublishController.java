package com.example.demo.controller;

import com.example.demo.dto.PublishDTO;
import com.example.demo.mapper.PublishMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Publish;
import com.example.demo.model.User;
import com.example.demo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PublishMapper publishMapper;

    @Autowired
    private PublishService publishService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Integer id,
                       Model model){
        PublishDTO publishDTO = publishService.selByQuestionId(id);
        model.addAttribute("title", publishDTO.getTitle());
        model.addAttribute("description", publishDTO.getDescription());
        model.addAttribute("tag", publishDTO.getTag());
        model.addAttribute("id", id);
        return "publish";
    }



    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(@RequestParam(value = "title", required = false) String title,
                            @RequestParam(value = "description", required = false) String description,
                            @RequestParam(value = "tag", required = false) String tag,
                            @RequestParam(value = "id", required = false) Integer id,
                            HttpServletRequest request,
                            Model model
                            ){

        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        if(title == null || title.equals("")){
            model.addAttribute("error", "标题不能为空！");
            return "publish";
        }
        if(description == null || description.equals("")){
            model.addAttribute("error", "补充信息不能为空！");
            return "publish";
        }
        if(tag == null || tag.equals("")){
            model.addAttribute("error", "标签不能为空！");
            return "publish";
        }

        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("usererror", "用户未登录!");
            return "publish";
        }

        Publish publish = new Publish();
        publish.setTitle(title);
        publish.setDescription(description);
        publish.setTag(tag);
        publish.setCreator(user.getId());

        publish.setId(id);
        publishService.createOrUpdate(publish);


        return "redirect:/";
    }
}
