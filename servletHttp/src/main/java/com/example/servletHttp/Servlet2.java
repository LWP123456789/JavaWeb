package com.example.servletHttp;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
        String username = req.getParameter("username");
        System.out.println("在Servlet2中查看参数：" + username);

        // 查看 Servlet1 是否有盖章
        Object key = req.getAttribute("key");
        System.out.println("Servlet1是否有章 " +
                "" + key);

        // 处理自己的业务
        System.out.println("Servlet2 处理自己的业务");
    }
}
