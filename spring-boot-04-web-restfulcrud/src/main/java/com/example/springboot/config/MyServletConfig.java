package com.example.springboot.config;

import com.example.springboot.Listener.Mylistener;
import com.example.springboot.servlet.Myservlet;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServletConfig {
    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new Myservlet(),"/myServlet");
        servletRegistrationBean.setLoadOnStartup(1);
        return  servletRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<Mylistener> registrationBean = new ServletListenerRegistrationBean<Mylistener>(new Mylistener());
        return registrationBean;
    }
}
