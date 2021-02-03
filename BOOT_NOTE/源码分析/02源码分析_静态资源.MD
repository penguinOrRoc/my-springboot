 #静态资源配置
    静态资源目录
        默认是/resources/**
        指定静态资源访问目录：spring.resources.static-locations = [classpath:/newresources/**,……,……]
    静态资源
        默认无前缀
        指定静态资源访问路径：spring.mvc.static-path-pattern = /res/**
        spring:
          mvc:
            static-path-pattern: /mystatic/**
        设置静态资源访问前缀 ，该配置会导致welcomepage、favicon.ico失效
    webjars
            
#静态资源原理
   #SpringMVC的主要配置类 
        org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.class  
   #有参构造函数
   #资源处理的默认规则
        reources.add-mapping : false 禁用所有静态资源
        
        @ConfigurationProperties(prefix = "spring.resources", ignoreUnknownFields = false)
        public class ResourceProperties {
        	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/",
        			"classpath:/resources/", "classpath:/static/", "classpath:/public/" };
        			……
        ｝
