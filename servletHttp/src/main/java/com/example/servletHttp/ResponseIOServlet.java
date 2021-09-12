package com.example.servletHttp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查看服务器使用的字符集类型
        System.out.println( response.getCharacterEncoding() );

        // 通过响应头，设置浏览器也是用UTF-8字符集
        /*response.setHeader("Content-Type","text/html;charset=UTF-8");*/

        // 它会同时设置服务器和客户端都使用UTF-8字符集，还设置了响应头
        //  此方法一定要在获取流对象之前调用才有效
        response.setContentType("text/html;charset=UTF-8");

        /*response.getOutputStream();*/
        PrintWriter writer = response.getWriter();
        writer.write("response's content!!!乐培");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
