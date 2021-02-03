package com.penguin.bootweb.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Component
@Configuration(proxyBeanMethods = false)
public class MatrixVariableConf //implements  WebMvcConfigurer
{
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_method");
        return methodFilter;
    }
    /**
    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);//不移除“；”后的内容
        pathMatchConfigurer.setUrlPathHelper(urlPathHelper);
    }    */

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);//不移除“；”后的内容
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }

}


