package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @className: servlet.Target
 * @description:
 * @author: 江骏杰
 * @create: 2022-08-08 22:27
 */
@WebServlet("/target")
public class TargetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String callback = request.getParameter("callback");
        response.setContentType("text/html");
        // jsonp必须要这么写
        response.getWriter().print(callback +"({\"name\":\"value\"})");
    }
}