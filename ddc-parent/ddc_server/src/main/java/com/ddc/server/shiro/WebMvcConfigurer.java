package com.ddc.server.shiro;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.json.JacksonSerializers;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dingpengfei
 * @since 2019-05-09
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }


    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        SimpleModule simpleModule = new SimpleModule();
//        JsonSerializer<Long> longJsonSerializer = new JsonSerializer<Long>() {
//            @Override
//            public void serialize(Long value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//                String text = (value == null ? null : String.valueOf(value));
//                if (text != null) {
//                    jsonGenerator.writeString(text);
//                }
//            }
//        };
//
//        simpleModule.addSerializer(Long.class, longJsonSerializer);
//        simpleModule.addSerializer(Long.TYPE, longJsonSerializer);
//
//        objectMapper.registerModule(simpleModule);
//
//        jackson2HttpMessageConverter.setObjectMapper(objectMapper);
//
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(new SerializerFeature[]{SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty});
//
//        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//
//        List<MediaType> supportedMediaTypes = new ArrayList();
//        supportedMediaTypes.add(MediaType.ALL);
//        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
//        converters.add(jackson2HttpMessageConverter);
//
//    }


}
