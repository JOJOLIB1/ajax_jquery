package servlet;

import bean.Data;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBUtil;

import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: servlet.DataServlet
 * @description:
 * @author: 江骏杰
 * @create: 2022-08-08 21:13
 */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Data> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT data from website where data like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, data + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Data(rs.getString(1)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        response.setContentType("text/html");
        response.getWriter().print(JSON.toJSONString(list));
    }
}
