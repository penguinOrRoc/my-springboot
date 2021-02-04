package com.penguin.bootweb.conf;


import com.penguin.bootweb.entity.ConvertorEntity;
import com.penguin.bootweb.entity.ConvertorRefEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration(proxyBeanMethods = false)
public class ConverterConf {
    @Bean
    public  WebMvcConfigurer converterWebMvcConfigurer(){
        return new  WebMvcConfigurer(){
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, ConvertorRefEntity>() {
                    @Override
                    public ConvertorRefEntity convert(String source) {
                        if (!StringUtils.isEmpty(source)){
                            ConvertorRefEntity convertorRefEntity = new ConvertorRefEntity();
                            String[] splits = source.split(",");
                            convertorRefEntity.setReffname(splits[0]);
                            convertorRefEntity.setReflname(splits[1]);
                            return convertorRefEntity;
                        }
                        return null;
                    }
                });
            }
        };
    }
}


