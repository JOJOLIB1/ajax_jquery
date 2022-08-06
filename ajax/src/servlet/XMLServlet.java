package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @className: servlet.XMLServlet
 * @description:
 * @author: 江骏杰
 * @create: 2022-08-06 10:10
 */
@WebServlet("/xml")
public class XMLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        out.print("<students>");
        out.print("<student>");
        out.print("<id>123</id>");
        out.print("<name>123</name>");
        out.print("</student>");
        out.print("<student>");
        out.print("<id>456</id>");
        out.print("<name>456</name>");
        out.print("</student>");
        out.print("<student>");
        out.print("<id>789</id>");
        out.print("<name>789</name>");
        out.print("</student>");
        out.print("</students>");
    }
}
