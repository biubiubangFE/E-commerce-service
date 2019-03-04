package com.mhdss.shop.trade;

import com.mhdss.shop.client.dto.AuthAgent;
import com.mhdss.shop.core.CoreConfig;
import com.mhdss.shop.filestorage.FileStorage;
import com.mhdss.shop.trade.interceptor.Interceptor;
import com.mhdss.shop.util.FilterUtil;
import org.apache.commons.codec.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
@EnableWebMvc
@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties
@ComponentScans(value = {
        @ComponentScan(basePackageClasses = {FileStorage.class}),
        @ComponentScan(basePackageClasses = {CoreConfig.class})
})
public class Application extends WebMvcConfigurerAdapter{

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private Interceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns(interceptor.getIncludes());
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public AuthAgent requestMessage() {
        return new AuthAgent();
    }

    @Bean(destroyMethod = "shutdown")
    public ScheduledExecutorService scheduledExecutorService() {
        return Executors.newScheduledThreadPool(8);
    }

    @Bean
    public FilterRegistrationBean filterRegistration() {
        return FilterUtil.filterRegistration();
    }

    @Bean(destroyMethod = "destroy")
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler-");
        return threadPoolTaskScheduler;
    }


    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(50 * 1024 * 1024);
        multipartResolver.setDefaultEncoding(CharEncoding.UTF_8);
        return multipartResolver;
    }
}
