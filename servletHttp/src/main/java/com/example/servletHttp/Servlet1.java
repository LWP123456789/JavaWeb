package com.example.servletHttp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
        String username = req.getParameter("username");
        System.out.println("在Servlet1中查看参数：" + username);

        // 给材料 盖一个章，并传递到 Servlet2 去查看
        req.setAttribute("key","Servlet1 ");

        // 请求转发必须要以斜杠打头，斜杠表示地址为：http//ip:port/工程名/，映射到IDEA代码的web目录
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");

        // 走向Servlet2
        requestDispatcher.forward(req,resp);
    }
}
/*
*     请求转发的特点：
*          1、浏览器地址栏没有变化
*          2、他们是一次请求
*          3、他们共享Request域中的数据
*          4、可以转发到WEB-INF目录下
*          5、不可以访问工程以外的资源
* */