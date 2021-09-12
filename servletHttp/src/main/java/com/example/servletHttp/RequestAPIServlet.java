package com.example.servletHttp;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 访问资源路径
        System.out.println("URI => " + req.getRequestURI());
        // 访问绝对路径
        System.out.println("URL => " + req.getRequestURL());
        // 获取客户端的 ip 地址
        System.out.println("客户端 ip 地址 => " + req.getRemoteHost());
        // 获取请求头
        System.out.println("请求头User-Agent => " + req.getHeader("User-Agent"));
        // 获取请求的方式
        System.out.println("请求的方式 => " + req.getMethod());
    }
}
