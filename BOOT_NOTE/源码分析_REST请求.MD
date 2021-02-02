#请求处理原理
   #SpringMVC开启REST风格
        默认不支持put、delete
        SpringMVC需配置HiddenHttpMethodFilter ，在web.xml添加配置如下
                <filter>
                    <filter-name>HiddenHttpMethodFilter</filter-name>
                    <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
                </filter>
                
                <filter-mapping>
                    <filter-name>HiddenHttpMethodFilter</filter-name>
                    <url-pattern>/*</url-pattern>
                </filter-mapping>
   #SpringBoot开启REST风格
        1.表单需添加隐藏参数_method
            <form action="/hello" method = "post">
                <input name="_method" type="hidden" value="put">
                <input value="REST-PUT" type="submit">
            </form>
            <form action="/hello" method = "post">
                <input name="_method" type="hidden" value="delete">
                <input value="REST-DELETE" type="submit">
            </form>
        2.application.yml开启spring.mvc.hiddenmethod.filter.enabled = true
        
   #Rest实现原理（基于表单提交实现，表单只能使用get、post，其他客户端工具可直接发送PUT、DELETE）
        HiddenHttpMethodFilter
        1.PUT、DELETE请求携带_method参数
        2.HiddenHttpMethodFilter会拦截请求
                请求是否为POST请求，获取_method参数的值  
        3.兼容PUT、DELETE、PATCH
        4.原生request(post),包装模式requestWrapper重写了getMethod方法，返回的是传入的值
        5.过滤器链放行时用wrapper，以后的方法调用getMethod时调用requestWrapper
      
      
   #拓展 自定义_method参数


    