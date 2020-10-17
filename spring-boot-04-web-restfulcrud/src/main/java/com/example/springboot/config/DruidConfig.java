package com.example.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewFilter;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

        @ConfigurationProperties(prefix = "spring.datasource")
        @Bean
        public DataSource druid(){
            return new DruidDataSource();
        }

        //配置druid的监控
        //1.配置一个管理后台的servlet
        @Bean
        public ServletRegistrationBean statViewServlet(){
            ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
            Map<String,String> initParms=new HashMap<>();
            initParms.put("loginUsername","admin");
            initParms.put("loginPassword","123456");
            initParms.put("allow","");
//            initParms.put("deny","");

            bean.setInitParameters(initParms);
            return  bean;
        }

        //2.配置一个web监控的filter
        @Bean
        public FilterRegistrationBean webStatFilter(){
            FilterRegistrationBean bean = new FilterRegistrationBean();
            bean.setFilter(new WebStatFilter());
            Map<String,String> initParms=new HashMap<>();
            initParms.put("exclusions","*.js,*.css,/druid/*");
            bean.setInitParameters(initParms);

            bean.setUrlPatterns(Arrays.asList("/*"));
            return bean;
        }
}
