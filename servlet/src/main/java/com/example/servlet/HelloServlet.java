package com.example.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1 构造方法");
    }
    /*
    *  service 方法是专门用来处理请求和相应的
    *  @param servletRequest
    *  @param servletResponse
    *  @throws ServletException
    *  @throws IOException
    * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service === Hello Servlet 被访问了");
        // 类型转换 (因为它有getMethod()方法)
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 获取请求的方式
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 . destory销毁方法");
    }

    /*
    * 做get请求的操作
    * */
    public void doGet(){
        System.out.println("get请求");
        System.out.println("get请求");
    }
    public void doPost(){
        System.out.println("post请求");
        System.out.println("post请求");
    }
}

