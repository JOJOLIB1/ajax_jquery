package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


/**
 * @className: servlet.AgencyServlet
 * @description:
 * @author: 江骏杰
 * @create: 2022-08-08 22:15
 */
@WebServlet("/agency")
public class AgencyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet("http://localhost:8080/ajax/target");
            // 执行get请求.
            CloseableHttpResponse resp = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = resp.getEntity();
                // 打印响应状态
                if (entity != null) {
                    response.setContentType("text/html");
                    response.getWriter().print(EntityUtils.toString(entity));
                }
            } finally {
                resp.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
