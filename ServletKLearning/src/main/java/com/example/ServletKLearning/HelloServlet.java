package com.example.ServletKLearning;

import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    /*private String message;*/

    public HelloServlet() {
        System.out.println("1 构造方法");
    }

    public void init(ServletConfig servletConfig) throws ServletException {
        /*message = "Hello World!";*/
        System.out.println("2 初始化");

        // 1、可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是：" + servletConfig.getServletName());
        // 2、获取初始化参数init-param
        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));
        // 3、获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    /*public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }*/
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service === Hello Servlet 被访问了");
        // 类型转换 (因为它有getMethod()方法)(转换为子类型)
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 获取请求的方式
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    public void destroy() {
        System.out.println("4 destory销毁方法");
    }

    /*
     * 做get请求的操作
     * */
    public void doGet(){
        System.out.println("get请求");
        System.out.println("get请求");
    }
    /*
     * 做post请求的操作
     * */
    public void doPost(){
        System.out.println("post请求");
        System.out.println("post请求");
    }
}