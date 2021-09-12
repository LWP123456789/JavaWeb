package com.example.servletHttp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("have ever come to this place Response1");
        // 设置响应状态码302，表示重定向，（已搬迁）
        /*response.setStatus(302);*/
        // 设置响应头，说明新的地址在哪里
        /*response.setHeader("Location","http://localhost:8080/servletHttp/response2");*/

        // 请求重定向 一行代码搞定
        response.sendRedirect("http://localhost:8080");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
/*
*     请求重定向的特点：
*       1、浏览器地址栏会发生变化
*       2、两次请求
*       3、不共享Request域中数据   每次请求都封装成一个Request对象
*       4、不能访问到WEB-INF下的资源
*       5、可以访问工程外的资源
* */