package com.penguin.bootweb.converter;

import com.penguin.bootweb.entity.DemoEntity;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class PenguinMessageConverter implements HttpMessageConverter<DemoEntity>{
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(DemoEntity.class);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-penguin");
    }

    @Override
    public DemoEntity read(Class<? extends DemoEntity> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(DemoEntity demoEntity, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //自定义协议的写出
        String data ="<penguin>"+ demoEntity.getFname()+";"+demoEntity.getLname()+"</penguin>";
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());

    }
}


