/*

package com.dj.xk.common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


*/
/**
 * @author qjt
 * @version 1.0
 * @date 2019/11/5 16:27
 *//*


@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {

    @Autowired
    private LoginIntercept loginIntercept;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        // excludePathPatterns 用户排除拦截
        */
/*, "/user1/**", "/swagger‐ui.html"*//*

        registry.addInterceptor(loginIntercept).addPathPatterns("/**")
                .excludePathPatterns("/user/toAdd","/user/add", "/user/login", "/user/toLogin");

        super.addInterceptors(registry);
    }

}



*/
