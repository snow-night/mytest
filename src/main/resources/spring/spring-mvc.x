<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
                         http://www.springframework.org/schema/context
                        http://www.springframework.org/schema/context/spring-context-3.2.xsd
                        http://www.springframework.org/schema/mvc
                        http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!-- ：启动Spring MVC的注解功能，完成请求和注解POJO的映射， 完成json自动转换 -->
    <!-- 避免IE执行AJAX时,返回JSON出现下载文件 -->
    <bean id="mappingJacksonHttpMessageConverter"
          class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
        <property name="supportedMediaTypes">
            <list>
                <value>text/plain</value>
                <value>multipart/form-data;charset=UTF8</value>
                <value>application/json;charset=UTF-8</value>
            </list>
        </property>
    </bean>
    <!--启用spring的一些annotation -->
    <!--<context:annotation-config/>-->

    <!-- 自动扫描该包，使SpringMVC认为包下用了@controller注解的类是控制器 -->
    <context:component-scan base-package="com.**.controller">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>


    <!--<bean id="demo" class="com.example.controller.Demo">-->
       <!--<constructor-arg index="1">-->
           <!--<value>18</value>-->
       <!--</constructor-arg>-->
        <!--<constructor-arg index="0">-->
            <!--<value>诸葛亮</value>-->
        <!--</constructor-arg>-->
    <!--</bean>-->

    <!--<bean id="single" class="com.example.controller.SingleController" scope="singleton">-->
        <!--<constructor-arg name="name" value="李白" />-->
        <!--<constructor-arg name="age" value="18"/>-->
    <!--</bean>-->

    <!-- 配置注解驱动 可以将request参数与绑定到controller参数上 -->
    <mvc:annotation-driven/>

    <!-- 消息转换器（防止返回json乱码） -->
    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
        <property name="messageConverters">
            <list>
                <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                    <property name="supportedMediaTypes">
                        <list>
                            <value>text/plain;charset=UTF-8</value>
                            <value>text/html;charset=UTF-8</value>
                            <value>application/json;charset=UTF-8</value>
                        </list>
                    </property>
                </bean>
                <ref bean="mappingJacksonHttpMessageConverter" />
            </list>
        </property>
    </bean>


    <!--HandlerMapping 无需配置，springmvc可以默认启动-->

    <!--静态资源映射-->
    <!--本项目把静态资源放在了WEB-INF的statics目录下，资源映射如下-->
    <mvc:resources mapping="/css/**" location="/statics/css/"/>
    <mvc:resources mapping="/js/**" location="/statics/js/"/>
    <mvc:resources mapping="/image/**" location="/statics/image/"/>

    <!--但是项目部署到linux下发现WEB-INF的静态资源会出现无法解析的情况，但是本地tomcat访问正常，因此建议还是直接把静态资源放在webapp的statics下，映射配置如下-->
    <!--<mvc:resources mapping="/css/**" location="/statics/css/"/>-->
    <!--<mvc:resources mapping="/js/**" location="/statics/js/"/>-->
    <!--<mvc:resources mapping="/image/**" location="/statics/images/"/>-->


    <!-- 对模型视图名称的解析，即在模型视图名称添加前后缀(如果最后一个还是表示文件夹,则最后的斜杠不要漏了) 使用JSP-->
    <!-- 默认的视图解析器 在上边的解析错误时使用 (默认使用html)- -->
    <bean id="defaultViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <property name="prefix" value="/WEB-INF/views/"/><!--设置JSP文件的目录位置-->
        <property name="suffix" value=".jsp"/>
    </bean>

    <!-- springmvc文件上传需要配置的节点-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="20971500"/>
        <property name="defaultEncoding" value="UTF-8"/>
        <property name="resolveLazily" value="true"/>
    </bean>
</beans>