package com.example.springboot.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class logincontroller {
//        @PutMapping
//        @DeleteMapping
//        @GetMapping
        @PostMapping(value = "/user/login")
        //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
        public String login(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Map<String,Object> map,
                            HttpSession session){
            if(!StringUtils.isEmpty(username)&& "123456".equals(password)){
                //登陆成功,防止表单重复提交，重定向到主页
                session.setAttribute("loginUser",username);
                return  "redirect:/main.html";
            }else{
                //登陆失败
                map.put("msg","用户名密码错误");
                return "login";
            }
        }
}
