package top.lep101.model2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现图书信息的录入
 */
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端发来的书编号和书名
        String book_id = req.getParameter("bookId");
        String book_name = req.getParameter("bookName");

        System.out.println(book_id);
        System.out.println(book_name);
    }
}
