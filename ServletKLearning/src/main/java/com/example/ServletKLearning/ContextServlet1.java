package com.example.ServletKLearning;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取ServletContext对象
        ServletContext servletContext = getServletContext();

        System.out.println(servletContext);

        System.out.println("保存之前：Context1 中获取域数据key1的值是：" + servletContext.getAttribute("key1"));


        servletContext.setAttribute("key1","value1");

        System.out.println("Context1 中获取域数据key1的值是：" + servletContext.getAttribute("key1"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
