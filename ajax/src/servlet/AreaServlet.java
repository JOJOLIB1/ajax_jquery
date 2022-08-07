package servlet;

import bean.Area;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: servlet.AreaServlet
 * @description:
 * @author: 江骏杰
 * @create: 2022-08-07 11:01
 */
@WebServlet("/area")
public class AreaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pCode = request.getParameter("code");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Area> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            String sql = "";
            if (pCode == null) {
                sql = "SELECT code,name FROM t_area WHERE p_code IS NULL";
                ps = conn.prepareStatement(sql);
            }else {
                sql = "SELECT code,name FROM t_area WHERE p_code = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,pCode);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                int code = rs.getInt("code");
                String name = rs.getString("name");
                list.add(new Area(code, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        String json = JSON.toJSONString(list);
        response.setContentType("text/html");
        response.getWriter().print(json);
    }
}
