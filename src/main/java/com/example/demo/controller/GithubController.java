package com.example.demo.controller;

import com.example.demo.dto.AccessToken;
import com.example.demo.dto.GithubUser;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.provider.GithubProvider;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class GithubController {
    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private UserService userService;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String clientUri;

    @GetMapping("/callback")
    public String getGithubUser(@RequestParam("code") String code,
                                @RequestParam("state") String state,
                                HttpServletRequest request,
                                HttpServletResponse response
                                ){

        AccessToken token = new AccessToken();
        token.setClient_id(clientId);
        token.setClient_secret(clientSecret);
        token.setCode(code);
        token.setRedirect_uri(clientUri);
        token.setState(state);
        String token1 = githubProvider.getToken(token);
        GithubUser githubuser = githubProvider.getUser(token1);

        if(githubuser != null){
            User user = new User();
            user.setAccountId(String.valueOf(githubuser.getId()));
            user.setName(githubuser.getName());
            String token2 = UUID.randomUUID().toString();
            user.setToken(token2);
            user.setAvatarUrl(githubuser.getAvatar_url());
            userService.insertOrUpdate(user);
            response.addCookie(new Cookie("token", token2));

            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie token = new Cookie("token", null);
        token.setMaxAge(0);
        response.addCookie(token);

        return "redirect:/";
    }
}
