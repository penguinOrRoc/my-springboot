package com.penguin.bootweb.conf;

import com.penguin.bootweb.converter.PenguinMessageConverter;
import com.penguin.bootweb.entity.DemoRefEntity;
import com.penguin.bootweb.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
public class PenguinWebMvcConfiguration implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //所有请求都被拦截包括静态资源
                .excludePathPatterns("/**"); //放行的请求
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_method");
        return methodFilter;
    }
    @Bean
    public WebMvcConfigurer matrixWebMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);//不移除“；”后的内容
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }
    //消息转换器
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new PenguinMessageConverter());
    }
    //内容协商策略
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        Map<String,MediaType> mediaTypes = new HashMap<>();
        mediaTypes.put("json",MediaType.APPLICATION_JSON);
        mediaTypes.put("xml",MediaType.APPLICATION_ATOM_XML);
        mediaTypes.put("penguin",MediaType.parseMediaType("application/x-penguin"));
        //基于参数的内容协商管理器
        ParameterContentNegotiationStrategy parameterContentNegotiationStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
        // parameterContentNegotiationStrategy.setParameterName("format");
        //基于请求的内容协商管理器，自定义内容协商管理器后，若不添加下面的代码，会导致基于请求头的适配失效
        HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();
        configurer.strategies(Arrays.asList(parameterContentNegotiationStrategy,headerContentNegotiationStrategy));
    }
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, DemoRefEntity>() {
            @Override
            public DemoRefEntity convert(String source) {
                if (!StringUtils.isEmpty(source)){
                    DemoRefEntity convertorRefEntity = new DemoRefEntity();
                    String[] splits = source.split(",");
                    convertorRefEntity.setReffname(splits[0]);
                    convertorRefEntity.setReflname(splits[1]);
                    return convertorRefEntity;
                }
                return null;
            }
        });
    }
}


