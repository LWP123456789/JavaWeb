package com.example.ServletKLearning;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet2 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("重写了init初始化方法，做了一些工作");
    }

    /*
    *  doGet()在get请求的时候调用
    * @param req
    * @param resp
    * @throws ServletException
    * @throws IOException
    * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 的doGet方法");
        // 也可以使用
        ServletConfig servletConfig = getServletConfig();
         System.out.println(servletConfig);
    }
    /*
     *  doPost()在post请求的时候调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 的doPost方法");
    }
}
