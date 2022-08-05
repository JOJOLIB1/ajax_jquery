package servlet;

import bean.User;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: servlet.JsonServlet
 * @description:
 * @author: 江骏杰
 * @create: 2022-08-04 18:05
 */
@WebServlet("/json")
public class JsonServlet extends HttpServlet {
    // 使用fastjson动态拼接json
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT id, username, userpwd FROM user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String username = rs.getString("username");
                String userPwd = rs.getString("userpwd");
                list.add(new User(username, userPwd, id));
            }
            String jsonString = JSON.toJSONString(list);
            out.write(jsonString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
    }
}
